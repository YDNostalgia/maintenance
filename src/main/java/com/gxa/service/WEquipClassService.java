package com.gxa.service;

import com.gxa.dto.WFacilityClass2AddDto;
import com.gxa.dto.WFacilityClass2UpdateDto;
import com.gxa.entity.WEquipClass;
import com.gxa.entity.WFacilityClass1;
import com.gxa.entity.WFacilityClass2;

import java.util.List;

public interface WEquipClassService {
    //查询出所有一级，二级器材和数量
    public List<WEquipClass> queryAllWEquipClass();
    //添加一级分类器材种类
    public void addWfacilityClass1(String wFacilityClass1Name);
    //添加二级分类器材种类
    public void addWfacilityClass2(WFacilityClass2AddDto wFacilityClass2AddDto);
    //修改一级分类器材名称
    public void updateWfacilityClass1Name(WFacilityClass1 wFacilityClass1);
    //修改二级分类器材名称
    public void updateWfacilityClass2Name(WFacilityClass2UpdateDto wFacilityClass2UpdateDto);
    //根据id删除器材一级种类
    public void deleteWfacilityClass1(Integer id);
    //查询出所有二级器材的数量
    public List<WFacilityClass2> queryALLWfacilityClass2Quantity();
    //根据id删除器材二级种类
    public void deleteWfacilityClass2(Integer id);

}
