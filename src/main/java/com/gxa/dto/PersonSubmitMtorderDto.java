package com.gxa.dto;

import com.gxa.entity.KeepPlan;
import com.gxa.entity.KeepRecord;
import com.gxa.entity.Personal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("人员抽组数据类型")
public class PersonSubmitMtorderDto {
    @ApiModelProperty(value = "已选维修人员id",name = "personalId")
    private List<Integer> personalId;
    @ApiModelProperty(value = "已选待维修任务任务编号",name = "keepRecordId")
    private List<Integer> keepRecordId;
}
