package ru.evteev.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor

@Controller
public class DefaultController {

    @GetMapping("/")
    public String greeting() {
        return "index";
    }
}
