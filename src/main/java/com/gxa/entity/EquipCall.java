package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("器材调用   属性对应")
public class EquipCall {
    @ApiModelProperty("维修单号")
    private int kid;
    @ApiModelProperty("器材调用 ID")
    private int id;
    @ApiModelProperty("数量")
    private String num;

    @ApiModelProperty("器材 属性实体")
    private  KeepManagement keepManagement;

    @ApiModelProperty("器材单位 属性对应")
    private  KeepUnit keepUnit;

    @ApiModelProperty("器材类型 属性对应")
    private  KeepFacility keepFacility;



    @ApiModelProperty("维修记录单号")
    private int keepId;

}
