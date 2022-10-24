package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户管理实体")
public class User {

    private Integer id;
    @ApiModelProperty(value = "账号", name = "account")
    private String account;
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;
    @ApiModelProperty(value = "密码", name = "pwd")
    private String pwd;
    private String captcha;
    @ApiModelProperty(value = "手机号码", name = "phoneNumber")
    private String phoneNumber;
    @ApiModelProperty(value = "添加时间", name = "addTime")
    private Date addTime;
    @ApiModelProperty(value = "角色", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "状态", name = "state")
    private Integer state;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;
    private List<Routing> routing;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addTime=" + addTime +
                ", roleName='" + roleName + '\'' +
                ", state='" + state + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
