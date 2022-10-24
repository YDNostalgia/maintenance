package com.gxa.dto;

import com.gxa.entity.WInventoryManagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("添加库存盘点单")
public class WInventoryManagementAddDto {

    @ApiModelProperty(value = "盘点单号",name = "inventoryNo")
    private Integer inventoryNo;
    @ApiModelProperty(value = "盘点日期",name = "inventoryDate")
    private Date inventoryDate;
    @ApiModelProperty(value = "制单人ID",name = "preparedBy")
    private Integer preparedById;
    @ApiModelProperty(value = "盘点明细",name = "wInventroyDetails")
    private List<WInventoryDetailsAddDto> wInventoryDetailsAddDtos;
}
