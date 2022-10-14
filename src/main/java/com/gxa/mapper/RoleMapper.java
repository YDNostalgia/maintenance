package com.gxa.mapper;

import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.entity.User;

import java.util.List;


public interface RoleMapper {
    List<Role> queryAll(Role role);
    void add(Role role);
    void update(Role role);
    void delete(Integer id);
}
