package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("区域内货位添加")
public class WlocationAddDto {
    @ApiModelProperty(value = "区域ID",name = "wRegionId")
    private Integer wRegionId;
    @ApiModelProperty(value = "货架名称",name = "wLocationName")
    private String wLocationName;
}
