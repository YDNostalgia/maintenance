package com.gxa.mapper;

import com.gxa.dto.BreakdownDto;
import com.gxa.dto.UserDto;
import com.gxa.dto.StateDto;
import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    User getUserByName(String userName);

    Set<String> queryPermsByUserName(String roleName);

    List<User> queryAll(UserDto userDto);

    List<String> queryRoleName();
    Integer add(User user);
    Integer addUserRoleId(@Param("userId") Integer userId,@Param("roleId") Integer roleId);
    void update(User user);
    void updateState(StateDto stateDto);
    void updatePassword(User user);
    Integer queryRoleId(String roleName);
    void delete(Integer id);
    void deleteRoleId(Integer id);


}
