package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("器材分类修改")
public class DpartsEditDto {
    @ApiModelProperty(value = "器材分类id",name = "id")
    private Integer id;

    @ApiModelProperty(value = "分类名称",name = "name")
    private String name;
}
