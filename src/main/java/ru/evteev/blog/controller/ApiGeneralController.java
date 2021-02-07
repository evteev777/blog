package ru.evteev.blog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evteev.blog.model.api.response.GlobalSettingsDTO;
import ru.evteev.blog.model.api.response.InitDTO;
import ru.evteev.blog.model.api.response.TagListDTO;
import ru.evteev.blog.service.GlobalSettingsService;
import ru.evteev.blog.service.TagService;

@Data

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final InitDTO initDTO;
    private final GlobalSettingsService globalSettingsService;
    private final TagService tagService;

    @GetMapping("/init")
    public ResponseEntity<InitDTO> init() {
        return ResponseEntity.ok(initDTO);
    }

    @GetMapping("/settings")
    public ResponseEntity<GlobalSettingsDTO> getGlobalSettings() {
        return ResponseEntity.ok(globalSettingsService.getGlobalSettings());
    }

    @GetMapping("/tag")
    public ResponseEntity<TagListDTO> getTagList() {
        return ResponseEntity.ok(tagService.getTagList());
    }
}
