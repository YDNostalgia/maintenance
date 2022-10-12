package com.gxa.service.impl;

import com.gxa.entity.StatuteType;
import com.gxa.mapper.StatuteTypeMapper;
import com.gxa.service.StatuteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatuteTypeServiceImpl implements StatuteTypeService {

    @Autowired
    private StatuteTypeMapper statuteTypeMapper;

    @Override
    /**
     * 查询所有法规类型
     */
    public List<StatuteType> queryAll() {
        List<StatuteType> statuteTypes = this.statuteTypeMapper.queryAll();
        return statuteTypes;
    }
}
