package com.gxa.service;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.KeepPlanDto;
import com.gxa.entity.KeepFile;
import com.gxa.entity.KeepFileAU;

public interface KeepFileService{
    PageInfo<KeepFile> queryAllKeepFile(KeepPlanDto keepPlanDto,Integer page,Integer limit);

    void addKeepFile(KeepFileAU keepFileAU);

    void updateKeepFile(KeepFileAU keepFileAU);
    void deleteKeepFile(Integer id);
}
