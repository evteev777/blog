package ru.evteev.blog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.evteev.blog.model.dto.api.response.PostDTO;
import ru.evteev.blog.model.dto.projection.PostWithCountsDTO;

@Mapper
public interface PostDTOMapper {

    @Mapping(target = "id", source = "postWithCountsDTO.post.id")
    @Mapping(target = "timestamp", expression = "java(Utils.getTimestamp(postWithCountsDTO))")
    @Mapping(target = "userIdName", source = "postWithCountsDTO.post.user")
    @Mapping(target = "title", source = "postWithCountsDTO.post.title")
    @Mapping(target = "announce", expression = "java(Utils.getAnnounce(postWithCountsDTO))")
    @Mapping(target = "viewCount", source = "postWithCountsDTO.post.viewCount")
    PostDTO postWithCountsDTOToPostDTO(PostWithCountsDTO postWithCountsDTO);
}
