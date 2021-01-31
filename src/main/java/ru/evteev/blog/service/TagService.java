package ru.evteev.blog.service;

import ru.evteev.blog.model.api.response.TagListResponse;

public interface TagService {

    TagListResponse getTagList();
}
