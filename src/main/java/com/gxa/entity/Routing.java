package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("路由实体")
public class Routing {
    @ApiModelProperty("一级标题")
    private String title;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("子级路由内容")
    private List<RoutingChildren> children;
}
