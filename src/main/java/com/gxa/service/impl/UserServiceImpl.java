package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.dto.UserRoleDto;
import com.gxa.entity.User;
import com.gxa.mapper.UserMapper;
import com.gxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String pwd) {
        User user = this.userMapper.queryByUserNameAndPwd(userName,pwd);
        return user ;
    }

    @Override
    public PageInfo<User> queryAll(UserDto userDto, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<User> users = this.userMapper.queryAll(userDto);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public List<String> queryRoleName() {
        List<String> name=this.userMapper.queryRoleName();
        return name;
    }


    @Override
    public Integer add(User user) {
        Integer userId=this.userMapper.add(user);
        return userId;
    }

    public void addUserRoleId(Integer userId,Integer roleId){
        this.userMapper.addUserRoleId(userId,roleId);
    }

    @Override
    public void update(User user) {
        this.userMapper.update(user);
    }

    @Override
    public Integer queryRoleId(String userName) {
        Integer roleId = this.userMapper.queryRoleId(userName);
        return roleId;
    }

    @Override
    public void delete(Integer id) {
        this.userMapper.delete(id);
    }
}
