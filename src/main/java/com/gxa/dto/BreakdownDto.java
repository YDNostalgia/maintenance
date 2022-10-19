package com.gxa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreakdownDto {
    private  String num;
    private String equipmentName;
    private Date planTime;
}
