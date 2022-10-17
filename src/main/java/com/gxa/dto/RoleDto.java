package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("角色查询条件")
public class RoleDto {

    @ApiModelProperty(value = "账号", name = "id")
    private Integer id;
    @ApiModelProperty(value = "角色名", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "状态", name = "state")
    private String state;

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
