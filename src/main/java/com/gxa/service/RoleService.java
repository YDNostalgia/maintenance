package com.gxa.service;

import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.entity.User;

import java.util.List;

public interface RoleService {
    List<Role> queryAll(UserDto userDto);
    void add(Role role);
    void update(Role role);
    void delete(List<Role> roles);
}
