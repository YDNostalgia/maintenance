package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "法规")
public class Statute {
    @ApiModelProperty (value = "法规编号",name = "statuteId")
    private Integer statuteId;
    @ApiModelProperty (value = "法规名称",name = "statuteName")
    private String statuteName;
    @ApiModelProperty (value = "法规类型",name = "statuteType")
    private StatuteType statuteType;
    @ApiModelProperty (value = "法规详情",name = "details")
    private String details;
    @ApiModelProperty (value = "更新时间",name = "statuteUpdateTime")
    private Date statuteUpdateTime;
    @ApiModelProperty (value = "文件地址",name = "fileAddress")
    private String fileAddress;
}
