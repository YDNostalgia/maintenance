package com.gxa.dto;

import com.gxa.entity.Dreview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("入库管理条件")
public class DwarehouseDto {
    @ApiModelProperty(value = "入库日期",name = "time")
    private Date time;
    @ApiModelProperty(value = "入库日期",name = "bill")
    private String bill;
    @ApiModelProperty(value = "入库日期",name = "dreview")
    private Dreview dreview;
    @ApiModelProperty(value = "入库日期",name = "code")
    private String code;
}
