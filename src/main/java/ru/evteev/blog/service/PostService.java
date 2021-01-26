package ru.evteev.blog.service;

import ru.evteev.blog.api.response.PostsResponse;
import ru.evteev.blog.model.entity.Post;

public interface PostService {

    Post getPost(int id);

    PostsResponse getPosts(int offset, int limit, String mode);
}
