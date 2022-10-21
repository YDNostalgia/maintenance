package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("添加二级器材种类")
public class WFacilityClass2AddDto {
    @ApiModelProperty(value = "器材一级分类ID",name = "wFacilityClass1Id")
    private Integer wFacilityClass1Id;
    @ApiModelProperty(value = "器材二级分类名称",name = "wFacilityClass2Name")
    private String wFacilityClass2Name;
}
