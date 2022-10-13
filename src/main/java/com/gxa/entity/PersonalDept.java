package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("部门信息")
public class PersonalDept {

    @ApiModelProperty(value = "部门id",name = "id")
    private Integer pdeptId;
    @ApiModelProperty(value = "部门",name = "pdept")
    private String pdept;

}
