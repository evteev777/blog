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

    default List<Post> getRecentPosts(
        boolean isActive, ModerationStatus moderationStatus, LocalDateTime time) {
        return findAllByIsActiveAndModerationStatusAndTimeBeforeOrderByTime(
            isActive, moderationStatus, time);
    }

    List<Post> findAllByIsActiveAndModerationStatusAndTimeBeforeOrderByTime(
        boolean isActive, ModerationStatus moderationStatus, LocalDateTime time);


    @Query(value = "select p AS post from Post p "
        + "where p.isActive = :isActive AND p.moderationStatus = :moderationStatus AND p.time <= :time "
        + "order by size(p.postComments) desc, p.viewCount desc, p.time desc ")
    List<Post> getPopularPosts(
        @Param("isActive") boolean isActive,
        @Param("moderationStatus") ModerationStatus moderationStatus,
        @Param("time") LocalDateTime time);

    @Query(value = "select p AS post from Post p "
        + "where p.isActive = :isActive AND p.moderationStatus = :moderationStatus AND p.time <= :time "
        + "order by "
//TODO       + "size(p.) desc, "
        + "p.time desc ")
    List<Post> getBestPosts(
        @Param("isActive") boolean isActive,
        @Param("moderationStatus") ModerationStatus moderationStatus,
        @Param("time") LocalDateTime time);


    default List<Post> getEarlyPosts(
        boolean isActive, ModerationStatus moderationStatus, LocalDateTime time) {
        return findAllByIsActiveAndModerationStatusAndTimeBeforeOrderByTimeDesc(
            isActive, moderationStatus, time);
    }

    List<Post> findAllByIsActiveAndModerationStatusAndTimeBeforeOrderByTimeDesc(
        boolean isActive, ModerationStatus moderationStatus, LocalDateTime time);
}
