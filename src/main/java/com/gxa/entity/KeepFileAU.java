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
@ApiModel("维修档案修改属性对应")
public class KeepFileAU {
    @ApiModelProperty(value = "id",name = "维修单号")
    private int id;
    @ApiModelProperty("装备编号")
    private int equipmentNumber;
    @ApiModelProperty("故障描述")
    private String desc;
    @ApiModelProperty("装备ID")
    private Integer equipmentId;

    @ApiModelProperty("维修结果  1:成功 2:待维修")
    private Integer testResults;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
