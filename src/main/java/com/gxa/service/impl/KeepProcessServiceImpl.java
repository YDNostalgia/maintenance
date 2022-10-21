package com.gxa.service.impl;

import com.gxa.dto.KeepProcessDto;
import com.gxa.entity.KeepProcess;
import com.gxa.mapper.KeepProcessMapper;
import com.gxa.service.KeepProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeepProcessServiceImpl implements KeepProcessService {
    @Autowired
    private KeepProcessMapper keepProcessMapper;
    @Override
    public List<KeepProcess> queryByKeepId(Integer keepId) {
        List<KeepProcess> keepProcesses = keepProcessMapper.queryByKeepId(keepId);
        return keepProcesses;
    }

    @Override
    public void addKeepProcess(KeepProcessDto keepProcessDto) {
        keepProcessMapper.addKeepProcess(keepProcessDto);
    }
}
