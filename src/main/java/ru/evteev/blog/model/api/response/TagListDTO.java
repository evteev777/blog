package ru.evteev.blog.model.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagListDTO {

    @JsonProperty("tags")
    private List<TagDTO> tagDTOList;
}
