package ru.evteev.blog.service;

import ru.evteev.blog.model.api.response.PostListResponse;
import ru.evteev.blog.model.entity.Post;

public interface PostService {

    Post getPost(int id);

    PostListResponse getPostList(int offset, int limit, String mode);
}
