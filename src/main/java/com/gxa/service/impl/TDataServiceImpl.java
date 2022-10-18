package com.gxa.service.impl;




import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.TDataAddDropDownFrame;
import com.gxa.dto.TDataDropDownFrame;
import com.gxa.dto.TDataDto;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.TData;
import com.gxa.entity.TDataToAdd;
import com.gxa.entity.TDataToUpdate;
import com.gxa.mapper.TDataMapper;
import com.gxa.service.TDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDataServiceImpl implements TDataService {

    @Autowired
    private TDataMapper tDataMapper;


    @Override
    public PageInfo<TData> queryTDatas(Integer page, Integer limit, TDataDto tDataDto) {
        PageHelper.startPage(page,limit);
        List<TData> tDatas = tDataMapper.queryTDatas(tDataDto);
        PageInfo<TData> pageInfo = new PageInfo<>(tDatas);
        return pageInfo;
    }

    @Override
    public void deleteByDataId(Integer dataId) {
        this.tDataMapper.deleteByDataId(dataId);
    }

    @Override
    public void add(TDataToAdd tDataToAdd) {
        this.tDataMapper.add(tDataToAdd);
    }

    @Override
    public void update(TDataToUpdate tDataToUpdate) {
        this.tDataMapper.update(tDataToUpdate);
    }

    @Override
    public List<String> selectEquipmentModel() {
        List<String> tDataDropDownFrameList=this.tDataMapper.selectEquipmentModel();
        System.out.println(tDataDropDownFrameList.get(1)+"44444");
        return tDataDropDownFrameList;
    }

    @Override
    public List<String> selectTDataType() {
        List<String> tDataAddDropDownFrames = this.tDataMapper.selectTDataType();
        return tDataAddDropDownFrames;
    }
}
