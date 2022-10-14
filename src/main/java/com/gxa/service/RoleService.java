package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.entity.User;

import java.util.List;

public interface RoleService {
    PageInfo<Role> queryAll(Role role,Integer page,Integer limit);
    void add(Role role);
    void update(Role role);
    void delete(Integer id);
}
