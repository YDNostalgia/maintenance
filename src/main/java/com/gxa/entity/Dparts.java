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
public class Dparts {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "区域名称",name = "name")
    private String name;
    @ApiModelProperty(value = "数量",name = "count")
    private Integer count;
    @ApiModelProperty(value = "器材表id",name = "dequip")
    private Dequip dequip;
}
