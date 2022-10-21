package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("器材 属性对应")
public class KeepManagement {
    @ApiModelProperty("器材编号")
    private int number;
    @ApiModelProperty("器材名字")
    private String name;
    @ApiModelProperty("规格型号")
    private String model;
}
