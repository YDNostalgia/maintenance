package com.gxa.mapper;

import com.gxa.dto.KeepRecordDto;
import com.gxa.entity.KeepRecord;
import com.gxa.entity.KeepRecordAU;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepRecordMapper {
    List<KeepRecord> queryAllKeepRecord(KeepRecordDto keepRecordDto);

    void addKeepRecord(KeepRecordAU keepRecordAU);

    void updateKeepRecord(KeepRecord keepRecord);

    void deleteKeepRecord(Integer id);

}
