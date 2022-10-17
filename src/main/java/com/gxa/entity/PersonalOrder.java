package com.gxa.entity;

import com.gxa.dto.PersonSubmitMtorderDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel("维修工单列表")
public class PersonalOrder {
    @ApiModelProperty(value = "维修人员",name = "pname")
    private String pname;
    @ApiModelProperty(value = "任务量",name = "orders")
    private Integer orders;
    @ApiModelProperty(value = "是否有任务  1-有，2-没有",name = "isOrder")
    private Integer isOrder;
    @ApiModelProperty(value = "维修人员与维修任务的对应关系",name = "personSubmitMtorderDto")
    private PersonSubmitMtorderDto personSubmitMtorderDto;
    @ApiModelProperty(value = "维修人员",name = "personal")
    private Personal personal;
    @ApiModelProperty(value = "维修任务",name = "keepRecord")
    private KeepRecord keepRecord;
}
