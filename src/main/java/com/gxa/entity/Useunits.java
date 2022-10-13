package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@ApiModel("使用单位实体")
public class Useunits {
    @ApiModelProperty("使用单位id")
    private Integer id;
    @ApiModelProperty("使用单位名字")
    private String useunitName;
}
