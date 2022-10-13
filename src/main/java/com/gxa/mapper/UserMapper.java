package com.gxa.mapper;

import com.gxa.dto.UserDto;
import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    User queryByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);
    User queryByUserName(String userName);

    Set<String> queryPermsByUserName(String userName);
    List<User> queryAll(UserDto userDto);
    void add(User user);
    void update(User user);
    User queryById(Integer id);
    void delete(List<User> users);
}
