package ru.evteev.blog.service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.dto.mapper.PostDTOMapper;
import ru.evteev.blog.model.dto.api.response.PostDTO;
import ru.evteev.blog.model.dto.api.response.PostListDTO;
import ru.evteev.blog.model.dto.projection.PostWithCountsDTO;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.model.enums.ModerationStatus;
import ru.evteev.blog.repository.PostRepository;

@Data
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PostDTOMapper postDTOMapper;

    @Override
    public Post getPost(int id) {
        return postRepository.getById(id);
    }

    public PostListDTO getPostList(int offset, int limit, String mode) {

        int count = postRepository.getPostCount(
            true, ModerationStatus.ACCEPTED, LocalDateTime.now(Clock.systemUTC()));

        List<PostWithCountsDTO> postWithCountsDTOList = postRepository.getPostWithCountsDTOList(
            true, ModerationStatus.ACCEPTED, LocalDateTime.now(Clock.systemUTC()),
            getPageRequest(offset, limit, mode));

        List<PostDTO> postDTOList = postWithCountsDTOList.stream()
            .map(postDTOMapper::postWithCountsDTOToPostDTO)
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
                    .and(sortByViewCountDesc)
                    .and(sortByTimeDesc);
                break;
            case "best":
                sort = JpaSort.unsafe(Direction.DESC, "size(p.postVotes)")
                    .and(sortByViewCountDesc)
                    .and(sortByTimeDesc);
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
}
