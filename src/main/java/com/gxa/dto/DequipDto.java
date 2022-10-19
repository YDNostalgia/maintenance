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
    @ApiModelProperty(value = "器材类型",name = "typeId")
    private Integer typeId;
    @ApiModelProperty(value = "货区信息",name = "saveId")
    private Integer saveId;
    @ApiModelProperty(value ="当前页码" ,name ="page" )
    private Integer page;
    @ApiModelProperty(value ="每页记录数" ,name ="limit" )
    private Integer limit;
}
