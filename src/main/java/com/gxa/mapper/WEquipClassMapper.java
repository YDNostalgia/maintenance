package com.gxa.mapper;

import com.gxa.dto.WFacilityClass2AddDto;
import com.gxa.dto.WFacilityClass2UpdateDto;
import com.gxa.entity.WFacilityClass1;
import com.gxa.entity.WFacilityClass2;

import java.util.List;

public interface WEquipClassMapper {

    //查询出所有二级分类和一级分类的对应关系
    public List<WFacilityClass2> queryAllWfacilityClass2();
    //查询出所有二级器材的数量
    public List<WFacilityClass2> queryALLWfacilityClass2Quantity();
    //查询出所有一级器材
    public List<WFacilityClass1> queryAllWfacilityClass1();
    public void addWfacilityClass1(String wFacilityClass1Name);
    public void addWfacilityClass2(WFacilityClass2AddDto wFacilityClass2AddDto);
    public void updateWfacilityClass1Name(WFacilityClass1 wFacilityClass1);
    public void updateWfacilityClass2Name(WFacilityClass2UpdateDto wFacilityClass2UpdateDto);
    public void deleteWfacilityClass1(Integer id);
    public void deleteWfacilityClass2(Integer id);
}
