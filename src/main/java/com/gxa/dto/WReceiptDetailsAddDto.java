package com.gxa.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "添加 入库明细单")
public class WReceiptDetailsAddDto {
    @ApiModelProperty(value = "入库单号",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材编号",name = "wfacilityManagement")
    private Integer wfacilityManagementId;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}
