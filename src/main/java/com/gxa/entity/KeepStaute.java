package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("维修状态属性对应")
public class KeepStaute {
    @ApiModelProperty("Id")
    private Integer id;
    @ApiModelProperty("状态编号")
    private Integer statueId;
    @ApiModelProperty("状态")
    private String statue;

}
