package com.gxa.mapper;

import com.gxa.dto.UserDto;
import com.gxa.dto.UserRoleDto;
import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    User queryByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);
    User queryByUserName(String userName);

    Set<String> queryPermsByUserName(String userName);
    List<User> queryAll(UserDto userDto);
    List<String> queryRoleName();
    Integer add(User user);
    Integer addUserRoleId(@Param("userId") Integer userId,@Param("roleId") Integer roleId);
    void update(User user);
    Integer queryRoleId(String roleName);
    void delete(Integer id);
}
