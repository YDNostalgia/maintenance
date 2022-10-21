package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维护计划搜索信息")
public class EquipCallDto {
    @ApiModelProperty("数量")
    private int num;
    @ApiModelProperty("器材单号")
    private int kid;
    @ApiModelProperty("维修记录单号")
    private int keepId;
}
