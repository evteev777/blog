package ru.evteev.blog.service;

import ru.evteev.blog.model.dto.api.response.PostListDTO;
import ru.evteev.blog.model.entity.Post;

public interface PostService {

    Post getPost(int id);

    PostListDTO getPostList(int offset, int limit, String mode);
}
