package com.gxa.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("查询用户角色ID")
public class UserRoleDto {
    @ApiModelProperty(value = "用户Id", name = "userId")
    private Integer userId;
    @ApiModelProperty(value = "角色Id", name = "roleId")
    private Integer roleId;

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
