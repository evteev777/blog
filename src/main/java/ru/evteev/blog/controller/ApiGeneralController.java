package ru.evteev.blog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evteev.blog.api.response.GlobalSettingsDto;
import ru.evteev.blog.api.response.InitResponse;
import ru.evteev.blog.api.response.TagListResponse;
import ru.evteev.blog.service.GlobalSettingsService;
import ru.evteev.blog.service.TagService;

@Data

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final GlobalSettingsService globalSettingsService;
    private final TagService tagService;

    @GetMapping("/init")
    public ResponseEntity<InitResponse> init() {
        return ResponseEntity.ok(initResponse);
    }

    @GetMapping("/settings")
    public ResponseEntity<GlobalSettingsDto> getGlobalSettings() {
        return ResponseEntity.ok(globalSettingsService.getGlobalSettings());
    }

    @GetMapping("/tag")
    public ResponseEntity<TagListResponse> getTagList() {
        return ResponseEntity.ok(tagService.getTagList());
    }
}
