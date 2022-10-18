package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维修经费属性对应")
public class KeepFunds {
    @ApiModelProperty(value = "id",name = "维修单号")
    private int id;
    @ApiModelProperty("装备编号")
    private int equipmentNumber;

    @ApiModelProperty("装备ID")
    private Integer equipmentId;

    @ApiModelProperty("装备实体")
    private Equipment equipment;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("维修结果  0:成功 1:待维修")
    private Integer testResults;
    @ApiModelProperty("维修经费")
    private int keepMoney;
}
