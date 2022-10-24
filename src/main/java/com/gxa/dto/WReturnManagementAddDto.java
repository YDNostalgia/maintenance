package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "添加部门退料单")
public class WReturnManagementAddDto {
    @ApiModelProperty(value = "退料单号",name = "returnNo")
    private Integer returnNo;
    @ApiModelProperty(value = "退料日期",name = "returnDate")
    private Date returnDate;
    @ApiModelProperty(value = "退料部门ID",name = "personalDept")
    private Integer personalDeptId;
    @ApiModelProperty(value = "制单人ID",name = "preparedBy")
    private Integer preparedById;
    @ApiModelProperty(value = "退料明细",name = "wReturnDetailsAddDtos")
    private List<WReturnDetailsAddDto> wReturnDetailsAddDtos;
}
