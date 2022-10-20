package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepRecordDto;
import com.gxa.entity.KeepRecord;
import com.gxa.entity.KeepRecordAU;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepRecordService {
    PageInfo<KeepRecord> queryAllKeepRecord(KeepRecordDto keepRecordDto, Integer page, Integer limit);

    void addKeepRecord(KeepRecordAU keepRecordAU);
    void updateKeepRecord(KeepRecord keepRecord);

    void deleteKeepRecord(Integer id);
}
