package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Role> queryAll(Role role, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Role> roles = this.roleMapper.queryAll(role);
        PageInfo pageInfo=new PageInfo<>(roles);
        return pageInfo;
    }

    @Override
    public void add(Role role) {
        this.roleMapper.add(role);
    }

    @Override
    public void update(Role role) {
        this.roleMapper.update(role);
    }

    @Override
    public void delete(Integer id) {
        this.roleMapper.delete(id);

    }
}
