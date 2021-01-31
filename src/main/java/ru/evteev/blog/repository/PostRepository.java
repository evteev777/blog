package ru.evteev.blog.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.model.enums.ModerationStatus;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post getById(int id);

    List<Post> findAllByIsActiveIsTrueAndModerationStatusAndTimeBefore(
        ModerationStatus moderationStatus, LocalDateTime time);

    // "recent" sorting mode
    List<Post> findAllByIsActiveIsTrueAndModerationStatusAndTimeBeforeOrderByTime(
        ModerationStatus moderationStatus, LocalDateTime time);

    // "popular" sorting mode
//    List<Post> getPopularPosts(boolean isActive,
//        ModerationStatus moderationStatus, LocalDateTime time);

    @Query(value =
        "SELECT count(c) AS comments_count,  p.* AS post "
            + "FROM posts p "
            + "LEFT JOIN post_comments c on p.id = c.post_id "
            + "WHERE p.is_active = :isActive "
                + "AND p.moderation_status = :moderationStatus "
                + "AND p.time <= :time "
            + "GROUP BY p.id "
            + "ORDER BY comments_count DESC, p.view_count DESC, p.time DESC;",
        nativeQuery = true)
    List<Post> getPopularPosts(
        @Param("isActive") boolean isActive,
        @Param("moderationStatus") String moderationStatus,
        @Param("time") LocalDateTime time);

    // "early" sorting mode
    List<Post> findAllByIsActiveIsTrueAndModerationStatusAndTimeBeforeOrderByTimeDesc(
        ModerationStatus moderationStatus, LocalDateTime time);

}
