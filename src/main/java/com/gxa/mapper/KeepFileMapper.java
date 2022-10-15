package com.gxa.mapper;

import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFile;
import com.gxa.entity.KeepFileAU;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepFileMapper {
    List<KeepFile> queryAllKeepFile(KeepPlanDto keepPlanDto);

    void addKeepFile(KeepFileAU keepFileAU);

    void updateKeepFile(KeepFileAU keepFileAU);

    void deleteKeepFile(Integer id);
}
