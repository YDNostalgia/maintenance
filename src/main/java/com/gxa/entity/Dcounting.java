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
@ApiModel("盘点库存")
public class Dcounting {
    @ApiModelProperty(value = "盘点库存id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "盘点单号",name = "code")
    private String code;

    @ApiModelProperty(value = "盘点数",name = "countingsum")
    private Integer countingsum;
    @ApiModelProperty(value = "内容备注",name = "note")
    private Integer note;
    @ApiModelProperty(value = "盘点时间",name = "time")
    private Date time;

    @ApiModelProperty(value = "审核id",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "器材表id",name = "dequip")
    private Dequip dequip;
}
