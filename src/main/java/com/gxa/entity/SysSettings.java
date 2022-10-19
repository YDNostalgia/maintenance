package com.gxa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSettings {
    private Integer id;
    private String sysName;
    private String sysAddress;
}
