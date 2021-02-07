package ru.evteev.blog.model.dto.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagDTO {

    private String name;
    private Double weight;
}