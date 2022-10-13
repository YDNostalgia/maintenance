package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("人员查询条件")
public class PersonalQueryDto {

    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门id",name = "pdeptId")
    private String pdeptId;
    @ApiModelProperty(value = "工种id",name = "pjobId")
    private String pjobId;
}
