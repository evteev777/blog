package ru.evteev.blog.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagsResponse {

    @JsonProperty("tags")
    private List<TagResponse> tagResponses;
}
