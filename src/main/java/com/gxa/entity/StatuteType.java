package com.gxa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatuteType {
    private Integer id;
    private String statuteTypeName;
    private Date updateTime;
}
