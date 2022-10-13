package com.gxa.service;

import com.gxa.entity.User;

import java.util.List;

public interface UserService {
    User login(String userName, String pwd);
    List<User> queryAll();
    void add(User user);
    void update(User user);
    void delete(List<User> users);
}
