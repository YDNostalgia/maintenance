package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("法规查询条件")
public class StatuteDto {
    @ApiModelProperty(value = "当前页", name = "page")
    private Integer page;
    @ApiModelProperty(value = "每页显示条数", name = "limit")
    private Integer limit;
    @ApiModelProperty(value = "法规名", name = "statuteName")
    private String statuteName;
    @ApiModelProperty(value = "法规类型名", name = "statuteTypeName")
    private String statuteTypeName;
}
