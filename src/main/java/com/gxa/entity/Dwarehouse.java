package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("入库管理")
public class Dwarehouse {

    @ApiModelProperty(value = "ID",name = "ID")
    private Integer id;
    @ApiModelProperty(value = "入库单号",name = "code")
    private String code;
    @ApiModelProperty(value = "单据类型",name = "bill")
    private String bill;
    @ApiModelProperty(value = "内容备注",name = "note")
    private String note;
    @ApiModelProperty(value = "入库日期",name = "time")
    private Date time;

    @ApiModelProperty(value = "审核表id",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器材id",name = "dequip")
    private Dequip dequip;
}