package ru.evteev.blog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.api.response.UserIdNameResponse;
import ru.evteev.blog.model.entity.User;
import ru.evteev.blog.repository.UserRepository;

@Data
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public Boolean getApiAuthCheck() {
        return false;
    }

    @Override
    public UserIdNameResponse getUserIdNameResponse(User user) {
        UserIdNameResponse userIdNameResponse = new UserIdNameResponse();
        userIdNameResponse.setId(user.getId());
        userIdNameResponse.setName(user.getName());
        return userIdNameResponse;
    }
}
