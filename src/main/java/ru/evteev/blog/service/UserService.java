package ru.evteev.blog.service;

import ru.evteev.blog.model.dto.api.response.UserIdNameDTO;
import ru.evteev.blog.model.entity.User;

public interface UserService {

    User getUser(int id);

    Boolean getApiAuthCheck();

    UserIdNameDTO getUserIdNameResponse(User user);
}
