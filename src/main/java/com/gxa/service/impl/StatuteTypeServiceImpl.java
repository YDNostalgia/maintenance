package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.dto.StatuteTypeQueryDto;
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
    public List<StatuteType> queryAll() {
        return statuteTypeMapper.queryAll();
    }

    @Override
    /**
     * 查询所有法规类型
     */
    public PageInfo<StatuteType> queryByCondition(StatuteTypeQueryDto statuteTypeQueryDto) {

        PageHelper.startPage(statuteTypeQueryDto.getPage(), statuteTypeQueryDto.getLimit());
        List<StatuteType> statuteTypes = this.statuteTypeMapper.queryByCondition();
        PageInfo<StatuteType> pageInfo = new PageInfo<>(statuteTypes);
        return pageInfo;
    }

    @Override
    public void add(String statuteTypeName) {
        statuteTypeMapper.add(statuteTypeName);
    }

    @Override
    public void update(StatuteTypeEditDto statuteTypeEditDto) {
        statuteTypeMapper.save(statuteTypeEditDto);
    }

    @Override
    public void delete(Integer statuteTypeId) {
        statuteTypeMapper.delete(statuteTypeId);
    }
}
