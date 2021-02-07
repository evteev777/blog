package ru.evteev.blog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.evteev.blog.model.api.response.PostListDTO;
import ru.evteev.blog.service.PostService;

@Data
@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<PostListDTO> getPosts(
        @RequestParam(name = "offset") int offset,
        @RequestParam(name = "limit") int limit,
        @RequestParam(name = "mode") String mode) {

        return ResponseEntity.ok(postService.getPostList(offset, limit, mode));
    }

}
