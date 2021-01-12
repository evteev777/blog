package ru.evteev.blog.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evteev.blog.api.response.InitResponse;

@Data

@RestController
public class ApiGeneralController {

    private final InitResponse initResponse;

    @GetMapping("/api/init")
    public InitResponse init() {
        return initResponse;
    }
}
