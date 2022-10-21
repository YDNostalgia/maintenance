package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WInventoryDetails;
import com.gxa.entity.WInventoryManagement;
import com.gxa.mapper.WAccountDetailsMapper;
import com.gxa.mapper.WInventoryDetailsMapper;
import com.gxa.mapper.WInventoryManagementMapper;
import com.gxa.service.WInventoryManageMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WIventoryManagementServiceImpl implements WInventoryManageMentService {
    @Autowired
    private WInventoryManagementMapper wInventoryManagementMapper;
    @Autowired
    private WInventoryDetailsMapper wInventoryDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;

    @Override
    public PageInfo<WInventoryManagement> queryByCondition(WInventoryManagementQueryDto wInventoryManagementQueryDto) {

        PageHelper.startPage(wInventoryManagementQueryDto.getPage(),wInventoryManagementQueryDto.getLimit());

        List<WInventoryManagement> wInventoryManagements=wInventoryManagementMapper.queryByCondition(wInventoryManagementQueryDto);

        PageInfo<WInventoryManagement> pageInfo=new PageInfo<>(wInventoryManagements);

        return pageInfo;
    }


    @Override
    public void add(WInventoryManagementAddDto wInventoryManagementAddDto) {
        Integer inventoryNo=wInventoryManagementAddDto.getInventoryNo();
        List<WInventoryDetailsAddDto> wInventoryDetailsAddDtos=wInventoryManagementAddDto.getWInventoryDetailsAddDtos();

        for (WInventoryDetailsAddDto wInventoryDetailsAddDto:wInventoryDetailsAddDtos){
            wInventoryDetailsAddDto.setInventoryNo(inventoryNo);
        }
        wInventoryManagementAddDto.setWInventoryDetailsAddDtos(null);
        wInventoryManagementMapper.add(wInventoryManagementAddDto);
        wInventoryDetailsMapper.add(wInventoryDetailsAddDtos);
    }

    @Override
    public void update(WInventoryManagementUpdateDto wInventoryManagementUpdateDto) {
        wInventoryManagementMapper.update(wInventoryManagementUpdateDto);
        Integer auditStatus = wInventoryManagementUpdateDto.getAuditStatus();

        if (auditStatus==2){
            Integer inventoryNo=wInventoryManagementUpdateDto.getInventoryNo();
            List<WInventoryDetails> wInventoryDetails=wInventoryDetailsMapper.queryByInventoryNo(inventoryNo);
            for (int i=0;i<wInventoryDetails.size();i++){

                System.out.println(wInventoryDetails.get(i));

                Integer receiptNo= wInventoryDetails.get(i).getReceiptNo();//提取单号

                Integer number=wInventoryDetails.get(i).getWfacilityManagement().getNumber();//获取装备编号

                Integer quantity=wInventoryDetails.get(i).getQuantity();

                System.out.println("盘点数量"+quantity);

                //通过盘点单号和装备编号查询库存信息
                WAccountDetailsQueryDto wAccountDetailsQueryDto=new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);
                WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);

                //获取库存数量
//                Integer quantity1=wAccountDetails.getQuantity();
//                System.out.println("这个是库存数量--->>"+quantity1);

                WAccountDetailsUpdateDto wAccountDetailsUpdateDto=new WAccountDetailsUpdateDto();
                wAccountDetailsUpdateDto.setReceiptNo(receiptNo);
                wAccountDetailsUpdateDto.setWfacilityManagementId(number);
                wAccountDetailsUpdateDto.setQuantity(quantity);

                System.out.println("查询条件：----->"+quantity);
                wAccountDetailsMapper.update(wAccountDetailsUpdateDto);
            }
        }
        else {
            System.out.println("——————————>审核未通过不能修改!");
        }
    }



}
