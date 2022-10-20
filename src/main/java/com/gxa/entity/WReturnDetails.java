package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("退料明细")
public class WReturnDetails {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "退料单号",name = "returnNo")
    private Integer returnNo;
    @ApiModelProperty(value = "入库单号",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材",name = "wfacilityManagement")
    private WFacilityManagement wfacilityManagement;
    @ApiModelProperty(value = "数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "单价",name = "unitPrice")
    private double unitPrice;
}
