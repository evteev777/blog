package ru.evteev.blog.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.api.response.TagListResponse;
import ru.evteev.blog.model.api.response.TagResponse;
import ru.evteev.blog.repository.TagRepository;

@Data
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagListResponse getTagList() {
        List<TagResponse> tagResponseList = new ArrayList<>();
        tagRepository.findAll().forEach(tag ->
            tagResponseList.add(new TagResponse(tag.getName(), getTagWeight())));
        return new TagListResponse(tagResponseList);
    }

    // TODO tag weight - Math.random()
    private double getTagWeight() {
        return Math.random();
    }
}
