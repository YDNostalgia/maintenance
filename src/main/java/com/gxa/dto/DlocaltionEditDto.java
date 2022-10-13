package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("货位信息修改")
public class DlocaltionEditDto {
    @ApiModelProperty(value = "货位信息id",name = "id")
    private Integer id;

    @ApiModelProperty(value = "区域名称",name = "name")
    private String name;
}
