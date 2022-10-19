package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("入库管理")
public class WReceiptManagement {
    @ApiModelProperty(value = "入库单号",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "入库日期",name = "warehousingDate")
    private Date receiptDate;
    @ApiModelProperty(value = "制单人",name = "preparedBy")
    private User preparedBy;
    @ApiModelProperty(value = "审核状态(1:待审核，2：审核通过，3，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "审核人",name = "reviewedBy")
    private User reviewedBy;
}
