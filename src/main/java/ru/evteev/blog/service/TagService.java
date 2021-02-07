package ru.evteev.blog.service;

import ru.evteev.blog.model.dto.api.response.TagListDTO;

public interface TagService {

    TagListDTO getTagList();
}
