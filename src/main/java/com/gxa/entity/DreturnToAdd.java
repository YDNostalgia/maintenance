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
@ApiModel("部门新增退料表")
public class DreturnToAdd {
    @ApiModelProperty(value = "单据时间",name = "time")
    private Date time;
    @ApiModelProperty(value = "领料单号",name = "code")
    private String code;
    @ApiModelProperty(value = "备注内容",name = "note")
    private String note;
}