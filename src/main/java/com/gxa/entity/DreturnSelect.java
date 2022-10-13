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
@ApiModel("部门退料查询")
public class DreturnSelect {
    @ApiModelProperty(value = "退料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "退料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "退料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "制表审核",name = "dreview")
    private Dreview dreview;
}
