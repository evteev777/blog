package ru.evteev.blog.model.dto.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDTO {

    private int id;
    private long timestamp;
    @JsonProperty("user")
    private UserIdNameDTO userIdName;
    private String title;
    private String announce;
    private int viewCount;
    private int commentCount;
    private int likeCount;
    private int dislikeCount;
}
