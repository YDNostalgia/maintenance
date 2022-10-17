package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("货位信息")
public class Desave {

    @ApiModelProperty(value = "id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "存放区域",name = "saveArea")
    private String saveArea;
}
