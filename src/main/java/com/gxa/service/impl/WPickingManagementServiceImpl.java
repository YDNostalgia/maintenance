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
import com.gxa.utils.DocNoGenerationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WPickingManagementServiceImpl implements WPickingManagementService {

    @Autowired
    private WPickingManagementMapper wPickingManagementMapper;
    @Autowired
    private WPickingDetailsMapper wPickingDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;

    @Autowired
    private DocNoGenerationUtil docNoGenerationUtil;
    @Override
    public Integer addNo() {
        Integer pickingNo = docNoGenerationUtil.generateDocNo(2);
        return pickingNo;
    }

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
    public String update(WPickingManagementUpdateDto wPickingManagementUpdateDto) {

        Integer pickingNo = wPickingManagementUpdateDto.getPickingNo();
        Integer auditStatus = wPickingManagementMapper.queryByPickingNo(pickingNo);

        if (auditStatus == 2){
            return "审核失败：领料单已审核通过，不能重复审核";
        }

        wPickingManagementMapper.update(wPickingManagementUpdateDto);
        auditStatus = wPickingManagementUpdateDto.getAuditStatus();

        if (auditStatus == 2){
            List<WPickingDetails> wPickingDetails = wPickingDetailsMapper.queryByPickingNo(pickingNo);
            for (int i=0; i < wPickingDetails.size();i++){

//                获取入库单号
                Integer receiptNo = wPickingDetails.get(i).getReceiptNo();

//                获取装备编号
                Integer number = wPickingDetails.get(i).getWfacilityManagement().getNumber();

//                获取领料数量
                Integer quantity = wPickingDetails.get(i).getQuantity();

//                通过入库单号和装备编号查询库存信息
                WAccountDetailsQueryDto wAccountDetailsQueryDto = new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);
                WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);

//                获取库存数量
                Integer quantity1 = wAccountDetails.getQuantity();

                String wfacilityManagementName = wAccountDetails.getWfacilityManagement().getName();

                if (quantity1 < quantity){
                    try {
                        throw new Exception();
                    }finally {
                        return "审核失败：" + wfacilityManagementName + "库存数量不足";
                    }

                }

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
        return "审核成功";
    }

    @Override
    public String delete(Integer pickingNo) {
        Integer auditStatus = wPickingManagementMapper.queryByPickingNo(pickingNo);
        if (auditStatus == 2){
            return "删除失败：审核通过单据，不允许删除";
        }
        wPickingManagementMapper.delete(pickingNo);
        wPickingDetailsMapper.delete(pickingNo);
        return "删除成功";
    }

}
