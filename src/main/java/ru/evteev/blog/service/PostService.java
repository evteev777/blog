package ru.evteev.blog.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evteev.blog.enums.ModerationStatus;
import ru.evteev.blog.model.Post;
import ru.evteev.blog.model.User;

@RequiredArgsConstructor

@Service
public class PostService {

    public Post getTestPost() {
        Post post = new Post();
        post.setIsActive(true);
        post.setModerationStatus(ModerationStatus.NEW);
        post.setUser(new User());
        post.setTime(LocalDateTime.now());
        post.setTitle("New title");
        post.setText("New text");
        post.setViewCount(1000);
        return post;
    }
}
