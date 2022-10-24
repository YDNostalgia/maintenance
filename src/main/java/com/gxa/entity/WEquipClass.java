package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("器材分类信息汇总")
public class WEquipClass {
    @ApiModelProperty(value = "器材分类一级器材ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "器材分类一级器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材分类一级器材总数量",name = "count")
    private Integer count;
    @ApiModelProperty(value = "器材分类一级器材下二级器材",name = "wFacilityClass2s")
    private List<WFacilityClass2> wFacilityClass2s;
}
