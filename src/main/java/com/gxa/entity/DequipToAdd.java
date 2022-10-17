package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材添加页和添加")
public class DequipToAdd {

    @ApiModelProperty(value = "器材编号",name = "code")
    private String code;
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "器材分类",name = "type")
    private String type;
    @ApiModelProperty(value = "规格型号",name = "model")
    private String model;
    @ApiModelProperty(value = "单位",name = "company")
    private String company;
    @ApiModelProperty(value = "存放区域",name = "saveArea")
    private String saveArea;
    @ApiModelProperty(value = "货架编号",name = "goodsId")
    private String goodsId;
}
