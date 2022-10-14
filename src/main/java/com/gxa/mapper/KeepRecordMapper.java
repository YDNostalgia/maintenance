package com.gxa.mapper;

import com.gxa.dto.KeepRecordDto;
import com.gxa.entity.KeepRecord;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepRecordMapper {
    List<KeepRecord> queryAllKeepRecord(KeepRecordDto keepRecordDto);

    void addKeepRecord(KeepRecord keepRecord);

    void updateKeepRecord(KeepRecord keepRecord);

    void deleteKeepRecord(Integer id);

}
