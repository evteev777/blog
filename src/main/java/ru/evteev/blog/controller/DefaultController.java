package ru.evteev.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.evteev.blog.model.Post;
import ru.evteev.blog.service.PostService;

@RequiredArgsConstructor

@Controller
public class DefaultController {

    private final PostService postService;

    @GetMapping("/")
    public String greeting(Model model) {
        Post post = postService.getPost(1);
        model.addAttribute("post", post);
        return "index";
    }
}
