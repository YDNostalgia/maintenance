package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@ApiModel("盘点库存表")
public class DcountingDto {
    @ApiModelProperty(value = "盘点库存id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "盘点单号",name = "code")
    private String code;
    @ApiModelProperty(value = "库存",name = "stock")
    private Integer stock;
    @ApiModelProperty(value = "盘点库存",name = "countingsum")
    private Integer countingsum;
    @ApiModelProperty(value = "盘点时间",name = "time")
    private Date time;
}
