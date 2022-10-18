package com.gxa.service;



import com.github.pagehelper.PageInfo;
import com.gxa.dto.TDataAddDropDownFrame;
import com.gxa.dto.TDataDropDownFrame;
import com.gxa.dto.TDataDto;
import com.gxa.entity.EquipmentData;
import com.gxa.entity.TData;
import com.gxa.entity.TDataToAdd;
import com.gxa.entity.TDataToUpdate;

import java.util.List;

public interface TDataService {
    PageInfo<TData> queryTDatas(Integer page, Integer limit, TDataDto tDataDto);

    void deleteByDataId(Integer dataId);

    void add(TDataToAdd tDataToAdd);

    void update(TDataToUpdate tDataToUpdate);

    List<String> selectEquipmentModel();

    List<String> selectTDataType();
}
