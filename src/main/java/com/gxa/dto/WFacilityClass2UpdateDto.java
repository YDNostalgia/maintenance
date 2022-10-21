package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改二级器材种类名称")
public class WFacilityClass2UpdateDto {
    @ApiModelProperty(value = "器材二级分类ID",name = "wFacilityClass2Id")
    private Integer wFacilityClass2Id;
    @ApiModelProperty(value = "器材二级分类名称",name = "wFacilityClass2Name")
    private String wFacilityClass2Name;
}
