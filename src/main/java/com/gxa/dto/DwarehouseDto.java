package com.gxa.dto;

import com.gxa.entity.Dreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("入库管理查询条件")
public class DwarehouseDto {

    @ApiModelProperty(value = "开始时间",name = "startTime")
    private java.sql.Date startTime;
    @ApiModelProperty(value = "结束时间",name = "endTime")
    private Date endTime;
    @ApiModelProperty(value = "单据类型",name = "bill")
    private String bill;
    @ApiModelProperty(value = "入库单号",name = "code")
    private String code;
    @ApiModelProperty(value = "审核状态",name = "dreview")
    private Dreview dreview;

}
