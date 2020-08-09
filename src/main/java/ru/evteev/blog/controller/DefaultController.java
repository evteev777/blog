package ru.evteev.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.evteev.blog.model.Post;
import ru.evteev.blog.repo.PostRepo;
import ru.evteev.blog.service.PostService;

@RequiredArgsConstructor

@Controller
public class DefaultController {

    private final PostService postService;
    private final PostRepo postRepo;

    @GetMapping("/")
    public String greeting() {
        Post testPost = postService.getTestPost();
        postRepo.save(testPost);
        return "index";
    }
}
