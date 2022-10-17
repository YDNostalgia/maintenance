package com.gxa.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户查询条件")
public class UserDto {
    @ApiModelProperty(value = "账号", name = "account")
    private String account;
    @ApiModelProperty(value = "角色", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "状态", name = "state")
    private String state;

    @Override
    public String toString() {
        return "UserDto{" +
                "account=" + account +
                ", roleName='" + roleName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
