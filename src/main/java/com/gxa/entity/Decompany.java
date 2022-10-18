package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("单位表")
public class Decompany {

    @ApiModelProperty(value = "201个，202台，203套",name = "id")
    private Integer id;
    @ApiModelProperty(value = "单位",name = "company")
    private String company;
}
