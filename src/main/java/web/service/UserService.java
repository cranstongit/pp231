package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(long id, User user);
    void delete(long id);
    List<User> findAll();
}