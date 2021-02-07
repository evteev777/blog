package ru.evteev.blog.model.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostListDTO {

    private int count;

    @JsonProperty("posts")
    private List<PostDTO> postDTOList;
}
