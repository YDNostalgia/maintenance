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
@ApiModel("部门领料查询")
public class DpickingSelect {
    @ApiModelProperty(value = "领料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "领料部门",name = "department")
    private String department;
    @ApiModelProperty(value = "制表审核",name = "dreview")
    private Dreview dreview;

}
