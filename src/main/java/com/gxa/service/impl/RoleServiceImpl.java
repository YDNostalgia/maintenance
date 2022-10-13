package com.gxa.service.impl;

import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.mapper.RoleMapper;

import com.gxa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryAll(UserDto userDto) {
        List<Role> roles = this.roleMapper.queryAll(userDto);
        return roles;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(List<Role> roles) {

    }
}
