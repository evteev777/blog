package ru.evteev.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

    Tag getById(int id);
}
