package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFile;
import com.gxa.entity.KeepFileAU;
import com.gxa.mapper.KeepFileMapper;
import com.gxa.service.KeepFileService;
import com.gxa.service.KeepRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeepFileServiceImpl implements KeepFileService {
    @Autowired
    private KeepFileMapper keepFileMapper;
    @Override
    public PageInfo<KeepFile> queryAllKeepFile(KeepPlanDto keepPlanDto, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<KeepFile> keepFiles = keepFileMapper.queryAllKeepFile(keepPlanDto);
        PageInfo<KeepFile> pageInfo = new PageInfo<>(keepFiles);
        return pageInfo;
    }

    @Override
    public void addKeepFile(KeepFileAU keepFileAU) {
        keepFileMapper.addKeepFile(keepFileAU);
    }

    @Override
    public void updateKeepFile(KeepFileAU keepFileAU) {
        keepFileMapper.updateKeepFile(keepFileAU);
    }

    @Override
    public void deleteKeepFile(Integer id) {
        keepFileMapper.deleteKeepFile(id);
    }
}
