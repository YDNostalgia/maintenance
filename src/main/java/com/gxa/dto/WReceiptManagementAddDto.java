package com.gxa.dto;

import com.gxa.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "添加 入库单")
public class WReceiptManagementAddDto {
    @ApiModelProperty(value = "入库单号",name = "receiptNo")
    private Integer receiptNo;
    @ApiModelProperty(value = "入库日期",name = "warehousingDate")
    private Date receiptDate;
    @ApiModelProperty(value = "制单人",name = "preparedBy")
    private Integer preparedById;
    @ApiModelProperty(value = "入库明细",name = "wReceiptDetails")
    private List<WReceiptDetailsAddDto> wReceiptDetailsAddDtos;
}
