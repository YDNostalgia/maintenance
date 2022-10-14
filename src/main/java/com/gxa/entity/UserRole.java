package com.gxa.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    private Integer userId;

    private Integer roleId;

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
