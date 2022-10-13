package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("入库管理删除")
public class DwarehouseDelete {
    @ApiModelProperty(value = "入库单号",name = "code")
    private String code;
}
