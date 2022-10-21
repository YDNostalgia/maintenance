package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("区域货位信息")
public class WStore {
    @ApiModelProperty(value = "区域id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "区域名称",name = "name")
    private String name;
    @ApiModelProperty(value = "区域总货位数",name = "count")
    private Integer count;
    @ApiModelProperty(value = "区域下所有货位信息",name = "wLocations")
    private List<WLocation> wLocations;
}
