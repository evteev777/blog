package ru.evteev.blog.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.dto.api.response.UserIdNameDTO;
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
    public UserIdNameDTO getUserIdNameResponse(User user) {
        UserIdNameDTO userIdNameDTO = new UserIdNameDTO();
        userIdNameDTO.setId(user.getId());
        userIdNameDTO.setName(user.getName());
        return userIdNameDTO;
    }
}
