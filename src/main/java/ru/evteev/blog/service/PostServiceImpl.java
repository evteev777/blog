package ru.evteev.blog.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.api.response.PostListDTO;
import ru.evteev.blog.model.api.response.PostDTO;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.model.enums.ModerationStatus;
import ru.evteev.blog.model.projection.PostWithCountsDTO;
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

    public PostListDTO getPostList(int offset, int limit, String mode) {

        int count = postRepository.getPostCount(
            true, ModerationStatus.ACCEPTED, LocalDateTime.now());

        List<PostWithCountsDTO> list = postRepository.getPostWithCountsList(
            true, ModerationStatus.ACCEPTED, LocalDateTime.now(),
            getPageRequest(offset, limit, mode));

        List<PostDTO> postDTOList = list.stream()
            .map(this::getPostResponse)
            .collect(Collectors.toList());
        return new PostListDTO(count, postDTOList);
    }

    private PageRequest getPageRequest(int offset, int limit, String mode) {
        Sort sortByViewCountDesc = Sort.by(Direction.DESC, "viewCount");
        Sort sortByTimeDesc = Sort.by(Direction.DESC, "time");

        Sort sort;
        switch (mode) {
            case "popular":
                sort = JpaSort.unsafe(Direction.DESC, "size(p.postComments)")
                    .and(sortByViewCountDesc).and(sortByTimeDesc);
                break;
            case "best":
                sort = JpaSort.unsafe(Direction.DESC, "size(p.postVotes)")
                    .and(sortByViewCountDesc).and(sortByTimeDesc);
                break;
            case "early":
                sort = Sort.by("time");
                break;
            default: // include "recent"
                sort = sortByTimeDesc;
                break;
        }
        int pageNum = offset / limit;
        return PageRequest.of(pageNum, limit, sort);
    }

    private PostDTO getPostResponse(PostWithCountsDTO postWithCounts) {
        PostDTO postDTO = new PostDTO();
        Post post = postWithCounts.getPost();

        postDTO.setId(post.getId());
        postDTO.setTimestamp(post.getTime().toEpochSecond(ZoneOffset.UTC));
        postDTO.setUserIdName(userService.getUserIdNameResponse(post.getUser()));
        postDTO.setTitle(post.getTitle());
        postDTO.setAnnounce(getAnnounce(post));
        postDTO.setLikeCount(postWithCounts.getLikesCount());
        postDTO.setDislikeCount(postWithCounts.getDislikesCount());
        postDTO.setCommentCount(postWithCounts.getCommentsCount());
        postDTO.setViewCount(post.getViewCount());

        return postDTO;
    }

    private String getAnnounce(Post post) {
        String postText = post.getText();
        return postText.length() < announceLength ?
            postText : postText.substring(0, announceLength);
    }
}
