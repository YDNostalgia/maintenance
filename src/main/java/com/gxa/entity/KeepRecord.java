package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维修记录属性对应")
public class KeepRecord implements Serializable {
    @ApiModelProperty(value = "id",name = "维修单号")
    private int id;
    @ApiModelProperty("装备编号")
    private int equipmentNumber;
    @ApiModelProperty("故障描述")
    private String desc;

    @ApiModelProperty("装备实体")
    private Equipment equipment;

    @ApiModelProperty("装备ID")
    private Integer equipmentId;

    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("维修状态 _ 2:待维修 1 :维修完成  0 ：维修中")
    private Integer testStatus;
}
