package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("人员信息")
public class Personal {
    @ApiModelProperty(value = "人员id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门对象",name = "personalDept")
    private PersonalDept personalDept;
    @ApiModelProperty(value = "工种对象",name = "personalJob")
    private PersonalJob personalJob;
    @ApiModelProperty(value = "工种等级对象",name = "personalClass")
    private PersonalClass personalClass;

}
