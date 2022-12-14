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
import com.gxa.utils.DocNoGenerationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WInventoryManagementServiceImpl implements WInventoryManageMentService {
    @Autowired
    private WInventoryManagementMapper wInventoryManagementMapper;
    @Autowired
    private WInventoryDetailsMapper wInventoryDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;
    @Autowired
    private DocNoGenerationUtil docNoGenerationUtil;

    @Override
    public Integer addNo() {
        Integer inventoryNo=docNoGenerationUtil.generateDocNo(4);
        return inventoryNo;
    }

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
    public String update(WInventoryManagementUpdateDto wInventoryManagementUpdateDto) {

        Integer inventoryNo=wInventoryManagementUpdateDto.getInventoryNo();
        Integer auditStatus=wInventoryManagementMapper.queryByInventoryNo(inventoryNo);

        if (auditStatus==2){
            return "????????????????????????????????????????????????????????????";
        }

        wInventoryManagementMapper.update(wInventoryManagementUpdateDto);
        auditStatus = wInventoryManagementUpdateDto.getAuditStatus();

        if (auditStatus==2){
            List<WInventoryDetails> wInventoryDetails=wInventoryDetailsMapper.queryByInventoryNo(inventoryNo);
            for (int i=0;i<wInventoryDetails.size();i++){



                Integer receiptNo= wInventoryDetails.get(i).getReceiptNo();//????????????

                Integer number=wInventoryDetails.get(i).getWfacilityManagement().getNumber();//??????????????????

                Integer quantity=wInventoryDetails.get(i).getQuantity();

                System.out.println("????????????"+quantity);

                //???????????????????????????????????????????????????
                WAccountDetailsQueryDto wAccountDetailsQueryDto=new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);
                WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);

                //??????????????????
                Integer quantity1=wAccountDetails.getQuantity();
                System.out.println("?????????????????????--->>"+quantity1);
                String wfacilityManagementName = wAccountDetails.getWfacilityManagement().getName();

                if (quantity1 < quantity) {
                    try {
                        throw new Exception();
                    } finally {
                        return "???????????????" + wfacilityManagementName + "??????????????????";
                    }
                }

                WAccountDetailsUpdateDto wAccountDetailsUpdateDto=new WAccountDetailsUpdateDto();
                wAccountDetailsUpdateDto.setReceiptNo(receiptNo);
                wAccountDetailsUpdateDto.setWfacilityManagementId(number);
                wAccountDetailsUpdateDto.setQuantity(quantity1);

                System.out.println("???????????????----->"+quantity1);
                wAccountDetailsMapper.update(wAccountDetailsUpdateDto);
            }
        }
        return "????????????";
    }

    @Override
    public String delete(Integer inventoryNo) {
        Integer auditStatus = wInventoryManagementMapper.queryByInventoryNo(inventoryNo);
        if (auditStatus == 2){
            return "???????????????????????????????????????????????????";
        }
        wInventoryManagementMapper.delete(inventoryNo);
        wInventoryDetailsMapper.delete(inventoryNo);
        return "????????????";
    }


}
