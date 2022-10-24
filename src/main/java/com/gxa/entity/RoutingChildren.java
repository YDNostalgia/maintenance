package com.gxa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("子级路由实体")
public class RoutingChildren {
    @ApiModelProperty("二级标题")
    private String title;
    @ApiModelProperty("二级路由地址")
    private String href;
    @ApiModelProperty("一级路由地址")
    private String com;
}
