package ru.evteev.blog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.evteev.blog.model.entity.Post;

@AllArgsConstructor
@Getter
public class PostTitleWithCommentsCount {

    Post post;
    int postCommentCount;
}
