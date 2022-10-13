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
@ApiModel("部门领料")
public class Dpicking {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "领料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "领料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "制表审核",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器材管理",name = "dequip")
    private Dequip dequip;
}
