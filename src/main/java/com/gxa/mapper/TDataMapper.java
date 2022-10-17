package com.gxa.mapper;

import com.gxa.dto.TDataDto;
import com.gxa.entity.TData;
import com.gxa.entity.TDataToAdd;

import java.util.List;

public interface TDataMapper {


    List<TData> queryTDatas(TDataDto tDataDto);

    void deleteByDataId(Integer dataId);

    void add(TDataToAdd tDataToAdd);
}
