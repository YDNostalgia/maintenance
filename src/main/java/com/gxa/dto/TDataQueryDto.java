package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "查询资料")   //@ApiModel：用在返回对象类上，描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
public class TDataQueryDto {

    @ApiModelProperty(value = "当前页",name = "page")  //@ApiModelProperty：描述一个model的属性
    private Integer page;

    @ApiModelProperty(value = "每页显示条数",name = "limit")
    private Integer limit;

    @ApiModelProperty(value = "资料名称",name = "dataName")
    private String dataName;

    @ApiModelProperty(value = "资料类型id",name = "categoryId")
    private Integer categoryId;
}
