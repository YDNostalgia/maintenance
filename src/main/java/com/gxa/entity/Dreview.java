package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("制表审核")
public class Dreview {
    @ApiModelProperty(value = "ID",name = "id")
    private Integer id;
    @ApiModelProperty(value = "制单人",name = "mperson")
    private String mperson;
    @ApiModelProperty(value = "审核状态",name = "status")
    private Integer status;
    @ApiModelProperty(value = "审核人",name = "reviewer")
    private String reviewer;
}
