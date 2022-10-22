package com.gxa.service.impl;

import com.gxa.dto.WFacilityClass2AddDto;
import com.gxa.dto.WFacilityClass2UpdateDto;
import com.gxa.entity.WEquipClass;
import com.gxa.entity.WFacilityClass1;
import com.gxa.entity.WFacilityClass2;
import com.gxa.mapper.WEquipClassMapper;
import com.gxa.service.WEquipClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WEquipClassServiceImpl implements WEquipClassService {

    @Autowired
    private WEquipClassMapper wEquipClassMapper;

    @Override
    public List<WEquipClass> queryAllWEquipClass() {

        //创建一个List<WEquipClass>集合
        List<WEquipClass> wEquipClasses = new ArrayList<>();

        //查询出所有一级器材和二级器材的对应关系
        List<WFacilityClass2> wFacilityClass2s = this.wEquipClassMapper.queryAllWfacilityClass2();
//        System.out.println("service层输出所有一级器材和二级器材的对应关系： " + wFacilityClass2s);

        //查询出所有二级器材的数量
        List<WFacilityClass2> wFacilityClass2sqt = this.wEquipClassMapper.queryALLWfacilityClass2Quantity();
//        System.out.println("service层输出所有二级器材的数量： " + wFacilityClass2sqt);
        //查询出所有一级器材分类
        List<WFacilityClass1> wFacilityClass1s = this.wEquipClassMapper.queryAllWfacilityClass1();
//        System.out.println("service层输出所有一级器材分类： " + wFacilityClass1s);

        for(int i = 0;i < wFacilityClass2s.size();i++){
            WFacilityClass2 wFacilityClass2 = wFacilityClass2s.get(i);

            for(int j = 0;j < wFacilityClass2sqt.size();j++){
                WFacilityClass2 wFacilityClass2q = wFacilityClass2sqt.get(j);
                if(wFacilityClass2.getId() == wFacilityClass2q.getId()){
                    int count = wFacilityClass2q.getCount();
                    wFacilityClass2.setCount(count);
                }
            }
        }

        System.out.println("service层输出整合后二级器材和器材数对应关系： " + wFacilityClass2s);

        for(int i = 0;i < wFacilityClass1s.size();i++){
            //为每一条二级器材记录创建一个对象
            WEquipClass wEquipClass = new WEquipClass();
            WFacilityClass1 wFacilityClass11 = wFacilityClass1s.get(i);
            Integer id = wFacilityClass11.getId();
            String name = wFacilityClass11.getName();

            wEquipClass.setId(id);
            wEquipClass.setName(name);
            //为每个对象创建一个装WFacilityClass2的集合
            List<WFacilityClass2> wFacilityClass2s1 = new ArrayList<>();
            int count = 0;

            for (int j = 0;j < wFacilityClass2s.size();j++){
                WFacilityClass2 class2 = new WFacilityClass2();
                class2 = wFacilityClass2s.get(j);

                if(wFacilityClass11.getId() == class2.getFacilityClass1().getId()){
                    wFacilityClass2s1.add(class2);
                    int total = class2.getCount();
                    count = count + total;
                }
            }
            wEquipClass.setCount(count);
            wEquipClass.setWFacilityClass2s(wFacilityClass2s1);

            wEquipClasses.add(wEquipClass);
        }
        return wEquipClasses;
    }

    @Override
    public void addWfacilityClass1(String wFacilityClass1Name) {
        this.wEquipClassMapper.addWfacilityClass1(wFacilityClass1Name);
    }

    @Override
    public void addWfacilityClass2(WFacilityClass2AddDto wFacilityClass2AddDto) {
        this.wEquipClassMapper.addWfacilityClass2(wFacilityClass2AddDto);
    }

    @Override
    public void updateWfacilityClass1Name(WFacilityClass1 wFacilityClass1) {
        this.wEquipClassMapper.updateWfacilityClass1Name(wFacilityClass1);
    }

    @Override
    public void updateWfacilityClass2Name(WFacilityClass2UpdateDto wFacilityClass2UpdateDto) {
        this.wEquipClassMapper.updateWfacilityClass2Name(wFacilityClass2UpdateDto);
    }

    @Override
    public void deleteWfacilityClass1(Integer id) {
        this.wEquipClassMapper.deleteWfacilityClass1(id);
    }

    @Override
    public List<WFacilityClass2> queryALLWfacilityClass2Quantity() {
        List<WFacilityClass2> wFacilityClass2s = this.wEquipClassMapper.queryALLWfacilityClass2Quantity();
        return wFacilityClass2s;
    }

    @Override
    public void deleteWfacilityClass2(Integer id) {
        this.wEquipClassMapper.deleteWfacilityClass2(id);
    }
}
