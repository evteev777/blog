package ru.evteev.blog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.User;
import ru.evteev.blog.repository.UserRepository;

@Data
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.getById(id);
    }
}
