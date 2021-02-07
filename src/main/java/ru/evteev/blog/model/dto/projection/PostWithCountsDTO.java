package ru.evteev.blog.model.dto.projection;

import ru.evteev.blog.model.entity.Post;

public interface PostWithCountsDTO {

    Post getPost();
    Integer getCommentsCount();
    Integer getLikesCount();
    Integer getDislikesCount();
}
