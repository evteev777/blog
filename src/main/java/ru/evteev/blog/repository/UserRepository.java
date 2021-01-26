package ru.evteev.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getById(int id);
}
