package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("器材单位 属性对应")
public class KeepUnit {
    @ApiModelProperty("器材单位id")
    private int id;
    @ApiModelProperty("器材单位名字")
    private String unit;

}
