package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新增器材工具类")
public class WequipManageAddDto {
    @ApiModelProperty(value = "器材编号",name = "number")
    private Integer number;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材分类ID",name = "classId")
    private Integer classId;
    @ApiModelProperty(value = "器材型号",name = "model")
    private String model;
    @ApiModelProperty(value = "器材单位",name = "unitId")
    private Integer unitId;
    @ApiModelProperty(value = "货架编号ID",name = "locationId")
    private Integer locationId;
}
