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
@ApiModel("部门退料")
public class Dreturn {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "退料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "退料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "退料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "制表审核",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器材管理",name = "dequip")
    private Dequip dequip;
}
