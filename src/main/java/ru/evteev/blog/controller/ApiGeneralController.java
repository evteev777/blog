package ru.evteev.blog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evteev.blog.api.response.InitResponse;
import ru.evteev.blog.api.response.SettingsResponse;
import ru.evteev.blog.api.response.TagsResponse;
import ru.evteev.blog.service.SettingsService;
import ru.evteev.blog.service.TagService;

@Data

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final SettingsService settingsService;
    private final TagService tagService;

    @GetMapping("/init")
    public ResponseEntity<InitResponse> init() {
        return ResponseEntity.ok(initResponse);
    }

    @GetMapping("/settings")
    public ResponseEntity<SettingsResponse> settings() {
        return ResponseEntity.ok(settingsService.getGlobalSettings());
    }

    @GetMapping("/tag")
    public ResponseEntity<TagsResponse> getTags() {
        return ResponseEntity.ok(tagService.getTags());
    }
}
