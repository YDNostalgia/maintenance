package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("器材查询条件")
public class DequipDto {
    @ApiModelProperty(value = "器材编号",name = "code")
    private String code;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材类型",name = "type")
    private String type;
    @ApiModelProperty(value = "存放区域",name = "saveArea")
    private String saveArea;
}
