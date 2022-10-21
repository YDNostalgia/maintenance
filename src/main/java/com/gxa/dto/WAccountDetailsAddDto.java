package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("库存台账添加")
public class WAccountDetailsAddDto {
    @ApiModelProperty(value = "批次号(入库单号)",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材Id",name = "wfacilityManagementId")
    private Integer wfacilityManagementId;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}
