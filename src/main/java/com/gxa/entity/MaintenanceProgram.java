package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("维修方案的实体")
public class MaintenanceProgram {
    @ApiModelProperty("序号")
    private Integer id;
    @ApiModelProperty("描述")
    private String desc;
}
