package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("单位表")
public class Decompany implements Serializable{
    public static final long serialVersionUID= 1L;

    @ApiModelProperty(value = "id",name = "id")
    private Integer id;
    @ApiModelProperty(value = "单位",name = "company")
    private String company;
}
