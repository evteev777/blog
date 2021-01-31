package ru.evteev.blog.model.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagResponse {

    private String name;
    private Double weight;
}