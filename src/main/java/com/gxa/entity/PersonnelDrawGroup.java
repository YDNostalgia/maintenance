package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("人员抽组的实体")
public class PersonnelDrawGroup {
    @ApiModelProperty("人员名称")
    private String username;
    @ApiModelProperty("人员部门")
    private String dept;
    @ApiModelProperty("人员工作")
    private String job;
    @ApiModelProperty("工作等级")
    private String pclass;
}
