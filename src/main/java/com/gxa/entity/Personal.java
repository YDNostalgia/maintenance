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
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门",name = "pdept")
    private String pdept;
    @ApiModelProperty(value = "工种",name = "pjob")
    private String pjob;
    @ApiModelProperty(value = "工种等级",name = "pclass")
    private String pclass;
}
