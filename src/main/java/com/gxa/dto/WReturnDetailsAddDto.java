package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "添加部门退料明细")
public class WReturnDetailsAddDto {
    @ApiModelProperty(value = "退料单号",name = "returnNo")
    private Integer returnNo;
    @ApiModelProperty(value = "批次号（入库单号）",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材编号",name = "wfacilityManagementId")
    private Integer wfacilityManagementId;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}
