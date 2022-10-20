package com.gxa.dto;

import com.gxa.entity.WFacilityManagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "条件查询库存台账")
public class WAccountDetailsQueryDto {
    @ApiModelProperty(value = "批次号(入库单号)",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "器材编号",name = "wfacilityManagementId")
    private Integer wfacilityManagementId;
}
