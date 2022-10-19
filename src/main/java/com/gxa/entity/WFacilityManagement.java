package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材管理")
public class WFacilityManagement {
    @ApiModelProperty(value = "器材编号",name = "number")
    private String number;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "规格型号",name = "model")
    private String model;
    @ApiModelProperty(value = "货位",name = "location")
    private WLocation location;
    @ApiModelProperty(value = "器材二级分类",name = "facilityClass2")
    private WFacilityClass2 wfacilityClass2;
    @ApiModelProperty(value = "器材计数单位",name = "facilityUnit")
    private WFacilityUnit facilityUnit;

}
