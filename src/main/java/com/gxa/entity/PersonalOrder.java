package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@ApiModel("维修工单列表")
public class PersonalOrder {
    private Integer id;
    @ApiModelProperty(value = "维修人员",name = "pname")
    private String pname;
    @ApiModelProperty(value = "待维修任务编号",name = "keepRecordId")
    private Integer keepRecordId;
    @ApiModelProperty(value = "任务量",name = "orders")
    private int orders;
    @ApiModelProperty(value = "任务",name = "order")
    private Map<String,Integer> order;
    @ApiModelProperty(value = "任务开始时间",name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "任务结束时间",name = "endTime")
    private Date endTime;


}

