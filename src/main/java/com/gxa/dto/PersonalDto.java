package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("人员抽组人员信息搜索")
public class PersonalDto {
    @ApiModelProperty(value = "页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "姓名",name = "pname")
    private String pname;
    @ApiModelProperty(value = "部门Id",name = "pdeptId")
    private Integer pdeptId;
    @ApiModelProperty(value = "工种Id",name = "pjobId")
    private Integer pjobId;
    @ApiModelProperty(value = "工种等级Id",name = "pclassId")
    private Integer pclassId;
}
