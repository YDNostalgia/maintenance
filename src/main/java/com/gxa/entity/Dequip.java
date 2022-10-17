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
public class Dequip {
    @ApiModelProperty(value = "id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "器材编号",name = "code")
    private String code;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "规格型号",name = "model")
    private String model;
    @ApiModelProperty(value = "单价",name = "price")
    private Double price;
    @ApiModelProperty(value = "数量",name = "sum")
    private Integer sum;
    @ApiModelProperty(value = "货架编号",name = "goodsId")
    private String goodsId;

    @ApiModelProperty(value = "器材分类id",name = "detype")
    private Detype detype;
    @ApiModelProperty(value = "货位信息id",name = "desave")
    private Desave desave;
    @ApiModelProperty(value = "单位表id",name = "decompany")
    private Decompany decompany;

}
