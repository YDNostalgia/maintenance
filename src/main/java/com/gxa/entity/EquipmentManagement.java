package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@ApiModel("装备实体")
public class EquipmentManagement {
    @ApiModelProperty("装备编号")
    private Integer id;

    @ApiModelProperty("装备名称")
    private  String equipmentName;

    @ApiModelProperty("装备分类")
    private  String equipmentclassificationName;

    @ApiModelProperty("装备状态")
    private  String state;

    @ApiModelProperty("价格")
    private  String price;

    @ApiModelProperty("筹措方式")
    private  String modalities;

    @ApiModelProperty("使用单位")
    private  String useunitsName;

    @ApiModelProperty("存放位置")
    private  String storagelocationName;

    @ApiModelProperty("责任人")
    private  String responsiblePerson;

    @Override
    public String toString() {
        return "EquipmentManagementMapper{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentclassificationName='" + equipmentclassificationName + '\'' +
                ", state='" + state + '\'' +
                ", price='" + price + '\'' +
                ", modalities='" + modalities + '\'' +
                ", useunitsName='" + useunitsName + '\'' +
                ", storagelocationName='" + storagelocationName + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                '}';
    }
}
