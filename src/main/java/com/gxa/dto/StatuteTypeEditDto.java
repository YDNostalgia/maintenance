package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("法规类型修改")
public class StatuteTypeEditDto {
    @ApiModelProperty(value = "法规类型编号", name = "statuteTypeId")
    private String statuteTypeId;
    @ApiModelProperty(value = "法规类型名称", name = "statuteTypeName")
    private String statuteTypeName;
}
