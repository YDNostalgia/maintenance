package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "添加库存盘点明细")
public class WInventoryDetailsAddDto {
    @ApiModelProperty(value = "盘点单号",name = "inventoryNo")
    private Integer inventoryNo;
    @ApiModelProperty(value = "批次号（入库单号）",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材编号",name = "wfacilityManagement")
    private Integer wfacilityManagementId;
    @ApiModelProperty(value = "盘点数量",name = "quantity")
    private Integer quantity;

}
