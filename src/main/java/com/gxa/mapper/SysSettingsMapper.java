package com.gxa.mapper;



import com.gxa.dto.SysSettingsDto;
import com.gxa.entity.SysSettings;

import java.util.List;


public interface SysSettingsMapper {
    List<SysSettings> queryAll();

    void update(SysSettingsDto sysSettingsDto);

}
