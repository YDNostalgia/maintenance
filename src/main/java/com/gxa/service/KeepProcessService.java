package com.gxa.service;

import com.gxa.dto.KeepProcessDto;
import com.gxa.entity.KeepProcess;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepProcessService {
    List<KeepProcess> queryByKeepId(Integer keepId);

    void addKeepProcess(KeepProcessDto keepProcessDto);
}
