package ru.evteev.blog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.Post;
import ru.evteev.blog.repository.PostRepository;

@Data
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post getPost(int id) {
        return postRepository.getById(id);
    }
}
