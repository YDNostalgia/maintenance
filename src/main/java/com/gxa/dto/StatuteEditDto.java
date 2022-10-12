package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "修改法规")
public class StatuteEditDto {
    @ApiModelProperty (value = "法规编号",name = "statuteId")
    private Integer statuteId;
    @ApiModelProperty (value = "法规名称",name = "statuteName")
    private String statuteName;
    @ApiModelProperty (value = "法规类型编号",name = "statuteTypeId")
    private Integer statuteTypeId;
    @ApiModelProperty (value = "法规详情",name = "details")
    private String details;
    @ApiModelProperty (value = "文件地址",name = "fileAddress")
    private String fileAddress;
}
