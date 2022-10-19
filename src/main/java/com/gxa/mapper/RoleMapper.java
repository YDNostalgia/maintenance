package com.gxa.mapper;

import com.gxa.dto.RoleDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.Role;

import java.util.List;


public interface RoleMapper {
    List<Role> queryAll(RoleDto roleDto);
    void add(Role role);
    void update(Role role);
    void updateRoleState(StateDto stateDto);
    void delete(Integer id);
}
