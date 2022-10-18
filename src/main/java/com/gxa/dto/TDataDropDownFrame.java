package com.gxa.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "资料管理的下拉列表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDataDropDownFrame {
    private String equipmentModel;

}
