package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.BreakdownDto;
import com.gxa.dto.UserDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserByName(String userName);

    PageInfo<User> queryAll(UserDto userDto,Integer page,Integer limit);
    List<String> queryRoleName();
    Integer add(User user);

    void addUserRoleId(Integer userId,Integer roleId);
    void update(User user);
    void updateState(StateDto stateDto);
    void updatePassword(User user);
    Integer queryRoleId(String roleName);
    void delete(Integer id);
    void deleteRoleId(Integer id);



}
