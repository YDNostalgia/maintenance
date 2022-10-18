package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材调用的实体")
public class EquipmentCall {
    @ApiModelProperty("序号")
    private Integer id;
    @ApiModelProperty("器材编号")
    private String code;
    @ApiModelProperty("器材名称")
    private String name;
    @ApiModelProperty("规格型号")
    private String model;
    @ApiModelProperty("单位")
    private String company;
    @ApiModelProperty("数量")
    private Integer desum;
    @ApiModelProperty("类型")
    private String type;
}
