package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("维修工单搜索")
public class PersonalMtorderListDto {
    @ApiModelProperty(value = "页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "维修人员",name = "pname")
    private String pname;
    @ApiModelProperty(value = "开始时间",name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "结束时间",name = "endTime")
    private Date endTime;
}
