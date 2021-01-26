package ru.evteev.blog.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.api.response.TagResponse;
import ru.evteev.blog.api.response.TagsResponse;
import ru.evteev.blog.repository.TagRepository;

@Data
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagsResponse getTags() {
        List<TagResponse> tagResponseList = new ArrayList<>();

        // TODO
        String tagNameFamily = tagRepository.getById(1).getName();
        tagResponseList.add(new TagResponse(tagNameFamily, 0.5));

        String tagNameWork = tagRepository.getById(2).getName();
        tagResponseList.add(new TagResponse(tagNameWork, 0.8));

        return new TagsResponse(tagResponseList);
    }
}
