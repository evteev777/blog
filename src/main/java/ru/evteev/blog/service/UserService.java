package ru.evteev.blog.service;

import ru.evteev.blog.model.api.response.UserIdNameResponse;
import ru.evteev.blog.model.entity.User;

public interface UserService {

    User getUser(int id);

    Boolean getApiAuthCheck();

    UserIdNameResponse getUserIdNameResponse(User user);
}
