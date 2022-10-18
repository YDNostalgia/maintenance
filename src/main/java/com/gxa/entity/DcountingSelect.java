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

    @ApiModelProperty(value = "器械名称",name = "name")
    private String name;
    @ApiModelProperty(value = "数量",name = "desum")
    private Integer desum;

    @ApiModelProperty(value = "盘点数",name = "countingsum")
    private Integer countingsum;
    @ApiModelProperty(value = "盘盈盘亏",name = "counting")
    private Integer counting;
}
