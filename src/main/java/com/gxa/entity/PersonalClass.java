package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工种等级信息")
public class PersonalClass {
    @ApiModelProperty(value = "工种等级id",name = "id")
    private Integer pclassId;
    @ApiModelProperty(value = "工种等级",name = "pclass")
    private String pclass;

}
