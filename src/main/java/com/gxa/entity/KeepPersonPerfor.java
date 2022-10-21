package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("数据统计---维修人员绩效 属性对应")
public class KeepPersonPerfor {

    @ApiModelProperty("维修单量")
    private String keepTotal;

    @ApiModelProperty("维修人实体")
    private PersonList personList;
}
