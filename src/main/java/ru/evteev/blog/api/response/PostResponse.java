package ru.evteev.blog.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponse {

    private int id;
    private long timestamp;
    @JsonProperty("user")
    private UserIdNameResponse userIdName;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;
}
