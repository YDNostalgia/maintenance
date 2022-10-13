package com.gxa.service.impl;




import com.gxa.entity.TData;
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
    public List<TData> queryAllDatas() {
        List<TData> tData = this.tDataMapper.queryAllDatas();
        return tData;
    }
}
