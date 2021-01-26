package ru.evteev.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.api.response.PostResponse;
import ru.evteev.blog.api.response.PostsResponse;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.repository.PostRepository;

@Data
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post getPost(int id) {
        return postRepository.getById(id);
    }

    public PostsResponse getPosts(int offset, int limit, String mode) {
        // TODO
        int postCount = 0;
        List<Post> availablePosts = getAvailablePosts(offset, limit, mode);
        return new PostsResponse(postCount, getPostsResponse(availablePosts));
    }

    private List<PostResponse> getPostsResponse(List<Post> posts) {
        List<PostResponse> postsResponse = new ArrayList<>();

        // TODO
        Post post = postRepository.getById(1);
        PostResponse postResponse = new PostResponse();

        postResponse.setId(post.getId());
        Date postDate = post.getTime();
        postResponse.setTimestamp(postDate.getTime());
        postResponse.setUserIdName(
            userService.getUserIdNameResponse(post.getUser()));
        postResponse.setTitle(post.getTitle());
        postResponse.setAnnounce(null);
        postResponse.setLikeCount(5);
        postResponse.setDislikeCount(2);
        postResponse.setCommentCount(7);
        postResponse.setViewCount(20);

        postsResponse.add(postResponse);

        // TODO
        return postsResponse;
    }

    private List<Post> getAvailablePosts(int offset, int limit, String mode) {
        List<Post> availablePosts = new ArrayList<>();
        // TODO
        return availablePosts;
    }
}
