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
@ApiModel("部门领料修改页和修改")
public class DpickingToUpdate {
    @ApiModelProperty(value = "领料日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "备注内容",name = "remarks")
    private String remarks;
    @ApiModelProperty(value = "器材管理",name = "dequip")
    private Dequip dequip;
}
