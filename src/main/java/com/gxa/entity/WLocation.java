package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("货位信息")
public class WLocation {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "货位名称",name = "name")
    private String name;
    @ApiModelProperty(value = "数量",name = "count")
    private int count;
    @ApiModelProperty(value = "区域",name = "region")
    private WRegion region;
}
