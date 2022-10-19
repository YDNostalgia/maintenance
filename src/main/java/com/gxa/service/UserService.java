package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.BreakdownDto;
import com.gxa.dto.UserDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.User;

import java.util.List;

public interface UserService {
    User login(String userName, String pwd);
    PageInfo<User> queryAll(UserDto userDto,Integer page,Integer limit);
    List<String> queryRoleName();
    Integer add(User user);

    void addUserRoleId(Integer userId,Integer roleId);
    void update(User user);
    void updateState(StateDto stateDto);
    Integer queryRoleId(String roleName);
    void delete(Integer id);

}
