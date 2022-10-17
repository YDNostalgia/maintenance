package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepRecordDto;
import com.gxa.entity.KeepRecord;
import com.gxa.mapper.KeepRecordMapper;
import com.gxa.service.KeepRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KeepRecordServiceImpl implements KeepRecordService {

    @Autowired
    private KeepRecordMapper keepRecordMapper;
    @Override
    public PageInfo<KeepRecord> queryAllKeepRecord(KeepRecordDto keepRecordDto,Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<KeepRecord> keepRecords = keepRecordMapper.queryAllKeepRecord(keepRecordDto);
        PageInfo<KeepRecord> pageInfo = new PageInfo<>(keepRecords);
        return pageInfo;
    }

    @Override
    public void addKeepRecord(KeepRecord keepRecord) {
        keepRecordMapper.addKeepRecord(keepRecord);
    }

    @Override
    public void updateKeepRecord(KeepRecord keepRecord) {
        keepRecordMapper.updateKeepRecord(keepRecord);
    }

    @Override
    public void deleteKeepRecord(Integer id) {
        keepRecordMapper.deleteKeepRecord(id);
    }
}
