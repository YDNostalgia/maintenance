package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造
@Data   //提供类的get、set、equals、hashCode、toString等方法
@ApiModel("装备分类的资料实体") //在实体类上边使用，标记类时swagger的解析类
public class EquipmentData {

    @ApiModelProperty(value = "类别id",name = "categoryId")   //使用在被 @ApiModel 注解的模型类的属性上
    private Integer categoryId;

    @ApiModelProperty(value = "类别名称",name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "资料数",name = "dataCount")
    private Integer dataCount;

    @ApiModelProperty(value = "更新时间",name = "updateTime")
    private Date updateTime;

}
