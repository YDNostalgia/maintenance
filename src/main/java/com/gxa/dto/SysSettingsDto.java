package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统设置")
public class SysSettingsDto {

    @ApiModelProperty(value = "ID", name = "id")
    private Integer id;
    @ApiModelProperty(value = "系统名称", name = "sysName")
    private String sysName;
    @ApiModelProperty(value = "系统远程地址", name = "sysAddress")
    private Integer sysAddress;


}
