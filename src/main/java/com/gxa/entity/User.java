package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户实体")
public class User {
    @ApiModelProperty("编号id")
    private Integer id;
    @ApiModelProperty("用户名userName")
    private String userName;
    @ApiModelProperty("密码pwd")
    private String pwd;
    @ApiModelProperty("盐值salt")
    private String salt;
    @ApiModelProperty("电话phoneNumber")
    private String phoneNumber;
    @ApiModelProperty("添加时间addTime")
    private Data addTime;

}
