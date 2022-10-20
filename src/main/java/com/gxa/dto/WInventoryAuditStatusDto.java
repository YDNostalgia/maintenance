package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("盘点状态实体")
public class WInventoryAuditStatusDto {
    @ApiModelProperty(value = "盘点单号",name = "inventoryNo")
    private Integer inventoryNo;
    @ApiModelProperty(value = "审核状态(0:待审核，1：审核通过，2，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
}
