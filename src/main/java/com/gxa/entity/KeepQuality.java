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
@ApiModel("维修质量属性对应")
public class KeepQuality {
    @ApiModelProperty(value = "id",name = "维修单号")
    private int id;
    @ApiModelProperty("装备编号")
    private int equipmentNumber;
    @ApiModelProperty("装备实体")
    private Equipment equipment;
    @ApiModelProperty("维修结果  0:成功 1:待维修")
    private int testResults;
    @ApiModelProperty("检测状态  0:未检测 1:已检测")
    private int testStatus;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
