package ru.evteev.blog.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.dto.projection.PostWithCountsDTO;
import ru.evteev.blog.model.entity.Post;
import ru.evteev.blog.model.enums.ModerationStatus;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post getById(int id);

    @Query(value = "select count(p) as count "
        + "from Post p "
        + "where p.isActive = :isActive "
        + "  and p.moderationStatus = :moderationStatus "
        + "  and p.time <= :time ")
    int getPostCount(
        @Param("isActive") boolean isActive,
        @Param("moderationStatus") ModerationStatus moderationStatus,
        @Param("time") LocalDateTime time);

    @Query(value = "select p as post, "
        + "  size(p.postComments) as commentsCount, "
        + "  coalesce((select size(v) from v where v.value > 0 group by p), 0) as likesCount,"
        + "  coalesce((select size(v) from v where v.value < 0 group by p), 0) as dislikesCount "
        + "from Post p left join p.postVotes v "
        + "where p.isActive = :isActive "
        + "  and p.moderationStatus = :moderationStatus "
        + "  and p.time <= :time "
        + "group by p ")
    List<PostWithCountsDTO> getPostWithCountsList(
        @Param("isActive") boolean isActive,
        @Param("moderationStatus") ModerationStatus moderationStatus,
        @Param("time") LocalDateTime time,
        Pageable pageable);
}
