package com.gxa.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("修改状态")
public class StateDto {
    private Integer id;
    @ApiModelProperty(value = "状态", name = "state")
    private Integer state;

    @Override
    public String toString() {
        return "UserStateDto{" +
                "id='" + id + '\'' +
                ", state=" + state +
                '}';
    }
}
