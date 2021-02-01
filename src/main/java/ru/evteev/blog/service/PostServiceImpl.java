package ru.evteev.blog.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.api.response.PostListResponse;
import ru.evteev.blog.model.api.response.PostResponse;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.model.enums.ModerationStatus;
import ru.evteev.blog.repository.PostRepository;

@Data
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Value("${blog.post.announceLength}")
    private int announceLength;

    @Override
    public Post getPost(int id) {
        return postRepository.getById(id);
    }

    public PostListResponse getPostList(int offset, int limit, String mode) {
        List<Post> activePostList = getActiveAcceptedPostList(offset, limit, mode);
        // TODO postCount
        int postCount = activePostList.size();
        return new PostListResponse(postCount, getPostResponseList(activePostList));
    }

    private List<Post> getActiveAcceptedPostList(int offset, int limit, String mode) {
        List<Post> postList;

        switch (mode) {
            case "popular":
                postList = postRepository.getPopularPosts(
                    true, ModerationStatus.ACCEPTED, LocalDateTime.now());
                break;
            case "best":
                postList = postRepository.getBestPosts(
                    true, ModerationStatus.ACCEPTED, LocalDateTime.now());
                break;
            case "early":
                postList = postRepository.getEarlyPosts(
                    true, ModerationStatus.ACCEPTED, LocalDateTime.now());
                break;
            default: // including "recent"
                postList = postRepository.getRecentPosts(
                    true, ModerationStatus.ACCEPTED, LocalDateTime.now());
                break;
        }
        return postList;
    }

    private List<PostResponse> getPostResponseList(List<Post> postList) {
        List<PostResponse> postResponseList = new ArrayList<>();
        postList.forEach(post -> postResponseList.add(getPostResponse(post)));
        return postResponseList;
    }

    private PostResponse getPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();

        postResponse.setId(post.getId());
        postResponse.setTimestamp(post.getTime().toEpochSecond(ZoneOffset.UTC));
        postResponse.setUserIdName(
            userService.getUserIdNameResponse(post.getUser()));
        postResponse.setTitle(post.getTitle());
        postResponse.setAnnounce(getAnnounce(post));
        postResponse.setLikeCount(5);
        postResponse.setDislikeCount(2);
        postResponse.setCommentCount(7);
        postResponse.setViewCount(20);
        return postResponse;
    }

    private String getAnnounce(Post post) {
        String postText = post.getText();
        return postText.length() < announceLength ?
            postText : postText.substring(0, announceLength);
    }
}
