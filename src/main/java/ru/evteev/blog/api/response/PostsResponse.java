package ru.evteev.blog.api.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostsResponse {

    private int count;
    private List<PostResponse> posts;
}
