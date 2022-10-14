package com.gxa.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("装备分类实体")
public class EquipmentClassification {
    private String equipmentClassificationName;
    private Integer num;
}
