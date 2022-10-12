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
@ApiModel("法规类型")
public class StatuteType {
    @ApiModelProperty(value = "法规类型编号",name = "statuteTypeId")
    private Integer statuteTypeId;
    @ApiModelProperty(value = "法规类型名称",name = "statuteTypeName")
    private String statuteTypeName;
    @ApiModelProperty(value = "法规条数",name = "numberOfDocuments")
    private Integer numberOfDocuments;
    @ApiModelProperty(value = "更新时间",name = "updateTime")
    private Date statuteTypeUpdateTime;
}
