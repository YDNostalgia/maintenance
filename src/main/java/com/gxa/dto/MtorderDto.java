package com.gxa.dto;

import com.gxa.entity.KeepPlan;
import com.gxa.entity.Personal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("人员抽组数据类型")
public class MtorderDto {
    @ApiModelProperty(value = "已选人员",name = "personals")
    private List<Personal> personals;
    @ApiModelProperty(value = "已选任务",name = "keepPlans")
    private List<KeepPlan> keepPlans;
}
