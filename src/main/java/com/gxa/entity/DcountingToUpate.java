package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门盘点修改页和添加")
public class DcountingToUpate {
    @ApiModelProperty(value = "单据日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "盘点单号",name = "code")
    private String code;
    @ApiModelProperty(value = "备注内容",name = "note")
    private String note;
}
