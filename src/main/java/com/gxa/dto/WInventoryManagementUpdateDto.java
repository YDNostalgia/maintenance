package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "更改盘点审核状态")
public class WInventoryManagementUpdateDto {
    @ApiModelProperty(value = "盘点单号",name = "inventory_No")
    private Integer inventoryNo;
    @ApiModelProperty(value = "审核状态(1:待审核，2：审核通过，3，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
}
