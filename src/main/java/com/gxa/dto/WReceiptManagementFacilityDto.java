package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("器材型号 下拉查询")
public class WReceiptManagementFacilityDto {
    @ApiModelProperty(value = "器材编号",name = "number")
    private Integer number;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "规格型号",name = "model")
    private String model;
}
