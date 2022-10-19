package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("货位信息")
public class Desave {

    @ApiModelProperty(value = "10A区，11B区，12C区，13D区，14E区",name = "id")
    private Integer id;
    @ApiModelProperty(value = "存放区域",name = "saveArea")
    private String saveArea;
}
