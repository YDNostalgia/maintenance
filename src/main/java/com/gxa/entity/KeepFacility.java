package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("器材类型 属性对应")
public class KeepFacility {
    @ApiModelProperty("器材类型id")
    private int id;
    @ApiModelProperty("器材类型名字")
    private String name;
}
