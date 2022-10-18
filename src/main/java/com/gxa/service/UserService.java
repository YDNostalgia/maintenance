package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.dto.UserRoleDto;
import com.gxa.entity.User;
import com.gxa.entity.UserRole;

import java.util.List;

public interface UserService {
    User login(String userName, String pwd);
    PageInfo<User> queryAll(UserDto userDto,Integer page,Integer limit);
    List<String> queryRoleName();
    Integer add(User user);

    void addUserRoleId(Integer userId,Integer roleId);
    void update(User user);
    Integer queryRoleId(String roleName);
    void delete(Integer id);
}
