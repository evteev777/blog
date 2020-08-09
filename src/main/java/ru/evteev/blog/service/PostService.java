package ru.evteev.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evteev.blog.enums.ModerationStatus;
import ru.evteev.blog.model.Post;

import java.time.LocalDateTime;

@RequiredArgsConstructor

@Service
public class PostService {

    public Post getTestPost() {
        Post post = new Post();
        post.setIsActive(true);
        post.setModerationStatus(ModerationStatus.NEW);
        post.setUserId(0);
        post.setTime(LocalDateTime.now());
        post.setTitle("New title");
        post.setText("New text");
        post.setViewCount(1000);
        return post;
    }
}
