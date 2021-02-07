package ru.evteev.blog.model.dto.mapper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.evteev.blog.model.dto.projection.PostWithCountsDTO;

@Component
public class Utils {

    private static int announceLength;

    @Value("${blog.post.announceLength}")
    public void setAnnounceLength(int value) {
        announceLength = value;
    }

    public static String getAnnounce(PostWithCountsDTO postWithCountsDTO) {
        String text = postWithCountsDTO.getPost().getText();
        return text.length() < announceLength ?
            text : text.substring(0, announceLength);
    }

    public static long getTimestamp(PostWithCountsDTO postWithCountsDTO) {
        LocalDateTime time = postWithCountsDTO.getPost().getTime();
        return time.toEpochSecond(ZoneOffset.UTC);
    }
}
