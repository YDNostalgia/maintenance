package com.gxa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer equipmentNumber;

    @JsonIgnore
    @ApiModelProperty("装备ID")
    private Integer equipmentId;

    @ApiModelProperty("装备实体")
    private Equipment equipment;
    @ApiModelProperty("检测结果  1:已解决 2:已检测")
    private Integer testResults;
    @ApiModelProperty("检测状态 _ 2:待维修 3 :成功  2 ：维修中")
    private Integer testStatus;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;

//    @ApiModelProperty("故障描述")
//    private String desc;
}
