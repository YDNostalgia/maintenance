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
@ApiModel("入库管理添加页和添加")
public class DwarehouseToAdd {

    @ApiModelProperty(value = "入库单号",name = "code")
    private String code;
    @ApiModelProperty(value = "单据类型",name = "bill")
    private String bill;
    @ApiModelProperty(value = "入库日期",name = "time")
    private Date time;

    @ApiModelProperty(value = "备注",name = "note")
    private String note;

    @ApiModelProperty(value = "制单审核",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器械管理",name = "dequip")
    private Dequip dequip;


    @ApiModelProperty(value = "器材名称",name = "name")//新加入的name
    private String name;
    @ApiModelProperty(value = "规格型号",name = "model")//新添加的model
    private String model;
}
