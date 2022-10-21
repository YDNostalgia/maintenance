package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.*;
import com.gxa.mapper.*;
import com.gxa.service.WPickingManagementService;
import com.gxa.service.WReturnManagementService;
import com.gxa.utils.DocNoGenerationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WReturnManagementServiceImpl implements WReturnManagementService {

    @Autowired
    private WReturnManagementMapper wReturnManagementMapper;
    @Autowired
    private WReturnDetailsMapper wReturnDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;

    @Autowired
    private DocNoGenerationUtil docNoGenerationUtil;

    @Override
    public Integer addNo() {
        Integer returnNo = docNoGenerationUtil.generateDocNo(3);
        return returnNo;
    }

    @Override

    public PageInfo<WReturnManagement> queryByCondition(WReturnManagementQueryDto wReturnManagementQueryDto){

        PageHelper.startPage(wReturnManagementQueryDto.getPage(),wReturnManagementQueryDto.getLimit());

        List<WReturnManagement> wReturnManagements = wReturnManagementMapper.queryByCondition(wReturnManagementQueryDto);

        PageInfo<WReturnManagement> pageInfo = new PageInfo<>(wReturnManagements);

        return pageInfo;
    }

    @Override
    public void add(WReturnManagementAddDto wReturnManagementAddDto) {
        Integer returnNo = wReturnManagementAddDto.getReturnNo();
        List<WReturnDetailsAddDto> wReturnDetailsAddDtos = wReturnManagementAddDto.getWReturnDetailsAddDtos();
        for (WReturnDetailsAddDto wReturnDetailsAddDto:wReturnDetailsAddDtos) {
            wReturnDetailsAddDto.setReturnNo(returnNo);
        }
        wReturnManagementAddDto.setWReturnDetailsAddDtos(null);
        wReturnManagementMapper.add(wReturnManagementAddDto);
        wReturnDetailsMapper.add(wReturnDetailsAddDtos);
    }

    @Override
    public String update(WReturnManagementUpdateDto wReturnManagementUpdateDto) {

        Integer returnNo = wReturnManagementUpdateDto.getReturnNo();
        Integer auditStatus = wReturnManagementMapper.queryByReturnNo(returnNo);

        if (auditStatus == 2){
            return "审核失败：退料单已审核通过，不能重复审核";
        }

        wReturnManagementMapper.update(wReturnManagementUpdateDto);
        auditStatus = wReturnManagementUpdateDto.getAuditStatus();

        if (auditStatus == 2){
            List<WReturnDetails> wReturnDetails = wReturnDetailsMapper.queryByReturnNo(returnNo);
            for (int i=0; i < wReturnDetails.size();i++){

//                获取入库单号
                Integer receiptNo = wReturnDetails.get(i).getReceiptNo();

//                获取装备编号
                Integer number = wReturnDetails.get(i).getWfacilityManagement().getNumber();

//                获取领料数量
                Integer quantity = wReturnDetails.get(i).getQuantity();

//                通过入库单号和装备编号查询库存信息
                WAccountDetailsQueryDto wAccountDetailsQueryDto = new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);
                WAccountDetails wAccountDetails = wAccountDetailsMapper.queryByCondition(wAccountDetailsQueryDto);

//                获取库存数量
                Integer quantity1 = wAccountDetails.getQuantity();


//                更新库存数量
                quantity1 += quantity;

                WAccountDetailsUpdateDto wAccountDetailsUpdateDto = new WAccountDetailsUpdateDto();
                wAccountDetailsUpdateDto.setReceiptNo(receiptNo);
                wAccountDetailsUpdateDto.setWfacilityManagementId(number);
                wAccountDetailsUpdateDto.setQuantity(quantity1);

                wAccountDetailsMapper.update(wAccountDetailsUpdateDto);
            }
        }
        return "审核成功";
    }

    @Override
    public String delete(Integer returnNo) {
        Integer auditStatus = wReturnManagementMapper.queryByReturnNo(returnNo);
        if (auditStatus == 2){
            return "删除失败：审核通过单据，不允许删除";
        }
        wReturnManagementMapper.delete(returnNo);
        wReturnDetailsMapper.delete(returnNo);
        return "删除成功";
    }

}
