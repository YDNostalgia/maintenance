package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.RoleDto;
import com.gxa.dto.StateDto;
import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.entity.User;

import java.util.List;

public interface RoleService {
    PageInfo<Role> queryAll(RoleDto roleDto, Integer page, Integer limit);
    void add(Role role);
    void update(Role role);
    void updateRoleState(StateDto stateDto);
    void delete(Integer id);
}
