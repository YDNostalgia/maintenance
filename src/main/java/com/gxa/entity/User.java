package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户管理实体")
public class User {
    @ApiModelProperty(value = "账号", name = "id")
    private Integer id;
    @ApiModelProperty(value = "用户名", name = "userName")

    private String userName;
    @ApiModelProperty(value = "手机号码", name = "phoneNumber")
    private String pwd;
    private String salt;
    @ApiModelProperty(value = "手机号码", name = "phoneNumber")
    private String phoneNumber;
    @ApiModelProperty(value = "添加时间", name = "addTime")
    private Date addTime;
    @ApiModelProperty(value = "角色", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

}
