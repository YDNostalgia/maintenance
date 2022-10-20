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
@ApiModel("部门退料")
public class WReturnManagement {
    @ApiModelProperty(value = "退料单号",name = "returnNo")
    private Integer returnNo;
    @ApiModelProperty(value = "退料日期",name = "returnDate")
    private Date returnDate;
    @ApiModelProperty(value = "退料部门",name = "personalDept")
    private PersonalDept personalDept;
    @ApiModelProperty(value = "制单人",name = "preparedBy")
    private User preparedBy;
    @ApiModelProperty(value = "审核状态(0:待审核，1：审核通过，2，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "审核人",name = "reviewedBy")
    private User reviewedBy;
}
