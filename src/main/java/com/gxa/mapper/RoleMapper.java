package com.gxa.mapper;

import com.gxa.dto.UserDto;
import com.gxa.entity.Role;

import java.util.List;


public interface RoleMapper {
    List<Role> queryAll(UserDto userDto);
}
