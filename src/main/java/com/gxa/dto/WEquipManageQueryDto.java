package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("器材管理列表查询条件封装")
public class WEquipManageQueryDto {
    @ApiModelProperty(value = "页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "装备分类ID",name = "wFacilityClass2Id")
    private Integer wFacilityClass2Id;
    @ApiModelProperty(value = "存放区域ID",name = "wRegionId")
    private Integer wRegionId;
    @ApiModelProperty(value = "器材名称或编号",name = "wEquipManagemhb")
    private String wEquipManagemhb;
    @ApiModelProperty(value = "工具属性Id")
    private Integer wEquipManageId;
    @ApiModelProperty(value = "工具属性Name")
    private String wEquipManageName;
}
