package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("审核表")
public class DreviewDto {
    @ApiModelProperty(value = "审核表id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "库管",name = "mperson")
    private String mperson;
    @ApiModelProperty(value = "审核状态",name = "status")
    private Integer status;
    @ApiModelProperty(value = "审核员",name = "mperson")
    private String reviewer;
}
