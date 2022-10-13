package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "资料")
public class TData {

    @ApiModelProperty(value = "资料id",name = "dataId")
    private Integer dataId;

    @ApiModelProperty(value = "资料名称",name = "dataName")
    private String dataName;

    @ApiModelProperty(value = "资料类型",name = "equipmentData")
    private EquipmentData equipmentData;

    @ApiModelProperty(value = "装备型号",name = "equipmentModel")
    private String equipmentModel;

    @ApiModelProperty(value = "资料详情",name = "dataDesc")
    private String dataDesc;

    @ApiModelProperty(value = "文件地址",name = "fileAddress")
    private String fileAddress;

    @ApiModelProperty(value = "文件上传的时间",name = "fileUploadTime")
    private Date fileUploadTime;
}
