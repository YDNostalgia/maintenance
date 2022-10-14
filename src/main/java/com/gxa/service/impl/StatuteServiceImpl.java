package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.StatuteAddDto;
import com.gxa.dto.StatuteEditDto;
import com.gxa.dto.StatuteQueryDto;
import com.gxa.entity.Statute;
import com.gxa.mapper.StatuteMapper;
import com.gxa.service.StatuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatuteServiceImpl implements StatuteService {

    @Autowired
    private StatuteMapper statuteMapper;

    @Override
    /**
     * 查询所有法规
     */
    public PageInfo<Statute> queryByIdAndName(StatuteQueryDto statuteQueryDto){

        PageHelper.startPage(statuteQueryDto.getPage(),statuteQueryDto.getLimit());

        String statuteName = statuteQueryDto.getStatuteName();

        if (statuteName != null && !statuteName.equals("")){
            statuteName = "%" + statuteQueryDto.getStatuteName() + "%";
        }

        List<Statute> statutes = statuteMapper.queryByIdAndName(statuteName, statuteQueryDto.getStatuteTypeId());

        PageInfo<Statute> pageInfo = new PageInfo<>(statutes);

        return pageInfo;
    }

    @Override
    public void add(StatuteAddDto statuteAddDto) {
        statuteMapper.add(statuteAddDto);
    }

    @Override
    public void update(StatuteEditDto statuteEditDto) {
        statuteMapper.update(statuteEditDto);
    }
}
