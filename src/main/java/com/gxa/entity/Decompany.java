package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("单位表")
public class Decompany {

    @ApiModelProperty(value = "id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "单位",name = "company")
    private String company;
}
