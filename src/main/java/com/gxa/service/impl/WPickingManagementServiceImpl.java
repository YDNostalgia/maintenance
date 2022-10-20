package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.Statute;
import com.gxa.entity.WAccountDetails;
import com.gxa.entity.WPickingDetails;
import com.gxa.entity.WPickingManagement;
import com.gxa.mapper.WAccountDetailsMapper;
import com.gxa.mapper.WPickingDetailsMapper;
import com.gxa.mapper.WPickingManagementMapper;
import com.gxa.service.WPickingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WPickingManagementServiceImpl implements WPickingManagementService {

    @Autowired
    private WPickingManagementMapper wPickingManagementMapper;
    @Autowired
    private WPickingDetailsMapper wPickingDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;

    @Override
    /**
     * 查询所有法规
     */
    public PageInfo<WPickingManagement> queryByCondition(WPickingManagementQueryDto wPickingManagementQueryDto){

        PageHelper.startPage(wPickingManagementQueryDto.getPage(),wPickingManagementQueryDto.getLimit());

        List<WPickingManagement> wPickingManagements = wPickingManagementMapper.queryByCondition(wPickingManagementQueryDto);

        PageInfo<WPickingManagement> pageInfo = new PageInfo<>(wPickingManagements);

        return pageInfo;
    }

    @Override
    public void add(WPickingManagementAddDto wPickingManagementAddDto) {
        Integer pickingNo = wPickingManagementAddDto.getPickingNo();
        List<WPickingDetailsAddDto> wPickingDetailsAddDtos = wPickingManagementAddDto.getWPickingDetailsAddDtos();
        for (WPickingDetailsAddDto wPickingDetailsAddDto:wPickingDetailsAddDtos) {
            wPickingDetailsAddDto.setPickingNo(pickingNo);
        }
        wPickingManagementAddDto.setWPickingDetailsAddDtos(null);
        wPickingManagementMapper.add(wPickingManagementAddDto);
        wPickingDetailsMapper.add(wPickingDetailsAddDtos);
    }

    @Override
    public void update(WPickingManagementUpdateDto wPickingManagementUpdateDto) {
        wPickingManagementMapper.update(wPickingManagementUpdateDto);
        Integer auditStatus = wPickingManagementUpdateDto.getAuditStatus();

        if (auditStatus == 2){
            Integer pickingNo = wPickingManagementUpdateDto.getPickingNo();
            List<WPickingDetails> wPickingDetails = wPickingDetailsMapper.queryByPickingNo(pickingNo);
            for (int i=0; i < wPickingDetails.size();i++){

                System.out.println(wPickingDetails.get(i));
//                获取入库单号
                Integer receiptNo = wPickingDetails.get(i).getReceiptNo();

//                获取装备编号
                Integer number = wPickingDetails.get(i).getWfacilityManagement().getNumber();

//                获取领料数量
                Integer quantity = wPickingDetails.get(i).getQuantity();
                System.out.println("领料数量：" + quantity);

//                通过入库单号和装备编号查询库存信息
                WAccountDetailsQueryDto wAccountDetailsQueryDto = new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);
                WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);

//                获取库存数量
                Integer quantity1 = wAccountDetails.getQuantity();
                System.out.println("库存数量：" + quantity1);

//                更新库存数量
                quantity1 -= quantity;

                WAccountDetailsUpdateDto wAccountDetailsUpdateDto = new WAccountDetailsUpdateDto();
                wAccountDetailsUpdateDto.setReceiptNo(receiptNo);
                wAccountDetailsUpdateDto.setWfacilityManagementId(number);
                wAccountDetailsUpdateDto.setQuantity(quantity1);

                System.out.println("查询条件：" + wAccountDetailsUpdateDto);

                wAccountDetailsMapper.update(wAccountDetailsUpdateDto);
            }
        }
    }

}
