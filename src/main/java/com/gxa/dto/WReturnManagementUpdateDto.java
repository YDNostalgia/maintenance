package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "更改部门退料单审核状态")
public class WReturnManagementUpdateDto {
    @ApiModelProperty(value = "退料单号",name = "returnNo")
    private Integer returnNo;
    @ApiModelProperty(value = "审核状态(1:待审核，2：审核通过，3，审核拒绝)",name = "auditStatus")
    private Integer auditStatus;
    @ApiModelProperty(value = "审核人Id",name = "reviewedById")
    private Integer reviewedById;
}
