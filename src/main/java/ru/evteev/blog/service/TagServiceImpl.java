package ru.evteev.blog.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.api.response.TagListDTO;
import ru.evteev.blog.model.api.response.TagDTO;
import ru.evteev.blog.repository.TagRepository;

@Data
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagListDTO getTagList() {
        List<TagDTO> tagDTOList = new ArrayList<>();
        tagRepository.findAll().forEach(tag ->
            tagDTOList.add(new TagDTO(tag.getName(), getTagWeight())));
        return new TagListDTO(tagDTOList);
    }

    // TODO tag weight - Math.random()
    private double getTagWeight() {
        return Math.random();
    }
}
