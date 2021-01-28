package ru.evteev.blog.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostListResponse {

    private int count;

    @JsonProperty("posts")
    private List<PostResponse> postResponseList;
}
