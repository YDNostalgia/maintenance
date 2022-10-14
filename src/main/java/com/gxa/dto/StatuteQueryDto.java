package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "查询法规")
public class StatuteQueryDto {
    @ApiModelProperty(value = "当前页", name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页显示条数", name = "limit")
    private Integer limit;
    @ApiModelProperty (value = "法规名称",name = "statuteName")
    private String statuteName;
    @ApiModelProperty (value = "法规类型编号",name = "statuteTypeId")
    private Integer statuteTypeId;
}
