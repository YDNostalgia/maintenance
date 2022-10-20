package com.gxa.dto;

import com.gxa.entity.Equipment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("待维修任务搜索")
public class PersonalMtorderDto {
    @ApiModelProperty(value = "页码",name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页记录数",name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "维修单号",name = "id")
    private Integer id;
    @ApiModelProperty(value = "装备对象",name = "equipment")
    private Equipment equipment;
    @ApiModelProperty(value = "装备编号",name = "equipmentNumber")
    private Integer equipmentNumber;
}
