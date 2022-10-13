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
public class Dlocaltion {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "区域名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材管理",name = "dequip")
    private Dequip dequip;
}
