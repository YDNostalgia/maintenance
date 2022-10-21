package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.StateDto;
import com.gxa.dto.SysSettingsDto;
import com.gxa.dto.UserDto;
import com.gxa.entity.SysSettings;
import com.gxa.entity.User;
import com.gxa.mapper.SysSettingsMapper;
import com.gxa.mapper.UserMapper;
import com.gxa.service.SysSettingsService;
import com.gxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysSettingsServiceImpl implements SysSettingsService {
    @Autowired
    private SysSettingsMapper sysSettingsMapper;

    @Override
    public List<SysSettings> queryAll() {
        return this.sysSettingsMapper.queryAll();
    }

    @Override
    public void update(SysSettingsDto sysSettingsDto) {
        this.sysSettingsMapper.update(sysSettingsDto);
    }
}
