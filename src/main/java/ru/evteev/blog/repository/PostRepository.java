package ru.evteev.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    Post getById(int id);
}
