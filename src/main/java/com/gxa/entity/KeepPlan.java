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
@ApiModel("维修计划属性对应")
public class KeepPlan {
    @ApiModelProperty(value = "id",name = "维修单号")
    private int id;
    @ApiModelProperty("装备编号")
    private int equipmentNumber;
    @ApiModelProperty("故障描述")
    private String desc;
    @ApiModelProperty("计划时间")
    private Date planTime;
    @ApiModelProperty("装备实体")
    private Equipment equipment;
    @ApiModelProperty("装备ID")
    private int equipmentId;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty(value = "部门id",name = "id")
    private Integer deptId;
    @ApiModelProperty( "维修部门实体")
    private PersonalDept personalDept;

}
