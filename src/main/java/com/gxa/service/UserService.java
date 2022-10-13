package com.gxa.service;

import com.gxa.dto.UserDto;
import com.gxa.entity.User;

import java.util.List;

public interface UserService {
    User login(String userName, String pwd);
    List<User> queryAll(UserDto userDto);
    void add(User user);
    void update(User user);
    User queryById(Integer id);
    void delete(List<User> users);
}
