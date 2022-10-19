package com.gxa.service;


import com.gxa.dto.SysSettingsDto;
import com.gxa.entity.SysSettings;

import java.util.List;

public interface SysSettingsService {

    List<SysSettings> queryAll();

    void update(SysSettingsDto sysSettingsDto);
}
