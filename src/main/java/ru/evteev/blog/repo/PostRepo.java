package ru.evteev.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.evteev.blog.model.Post;

public interface PostRepo extends CrudRepository<Post, Integer> {
}
