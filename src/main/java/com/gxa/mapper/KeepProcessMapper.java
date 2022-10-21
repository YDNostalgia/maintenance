package com.gxa.mapper;

import com.gxa.dto.KeepProcessDto;
import com.gxa.entity.KeepProcess;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KeepProcessMapper {
        List<KeepProcess> queryByKeepId(Integer keepId);

        void addKeepProcess(KeepProcessDto keepProcessDto);
}
