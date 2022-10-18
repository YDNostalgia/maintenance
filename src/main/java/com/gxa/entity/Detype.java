package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("器材分类")
public class Detype {

    @ApiModelProperty(value = "101发动机配件，102电器配件，103刹车配件",name = "id")
    private Integer id;
    @ApiModelProperty(value = "器材分类",name = "type")
    private String type;
}
