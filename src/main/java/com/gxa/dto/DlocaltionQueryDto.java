package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("货位信息查询条件")
public class DlocaltionQueryDto {
    @ApiModelProperty(value = "当前页",name = "page")
    private Integer page;

    @ApiModelProperty(value = "每页显示条数",name = "limit")
    private Integer limit;
}