package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("区域内货位名称修改信息")
public class WlocationUpdateDto {
    @ApiModelProperty(value = "货位ID",name = "wLocationId")
    private Integer wLocationId;
    @ApiModelProperty(value = "货位名称",name = "wLocationName")
    private String wLocationName;
}
