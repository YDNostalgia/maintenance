package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("库存盘点查询")
public class DcountingSelect {
    @ApiModelProperty(value = "器材名称",name = "name")
    private String name;
    @ApiModelProperty(value = "库存",name = "stock")
    private Integer stock;
    @ApiModelProperty(value = "盘点数量",name = "countingsum")
    private Integer countingsum;
}
