package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材二级分类")
public class WFacilityClass2 {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "器材二级分类名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材二级分类数量",name = "count")
    private int count;
    @ApiModelProperty(value = "器材一级分类",name = "facilityClass1")
    private WFacilityClass1 facilityClass1;
}
