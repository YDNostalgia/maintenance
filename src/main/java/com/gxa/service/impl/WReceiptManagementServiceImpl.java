package com.gxa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WReceiptDetails;
import com.gxa.entity.WReceiptManagement;
import com.gxa.mapper.*;
import com.gxa.service.WReceiptManagementService;
import com.gxa.utils.DocNoGenerationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WReceiptManagementServiceImpl implements WReceiptManagementService {

    @Autowired
    private WReceiptManagementMapper wReceiptManagementMapper;
    @Autowired
    private WReceiptManagementStatusMapper wReceiptManagementStatusMapper;
    @Autowired
    private WReceiptDetailsMapper wReceiptDetailsMapper;
    @Autowired
    private WAccountDetailsMapper wAccountDetailsMapper;
    @Autowired
    private DocNoGenerationUtil docNoGenerationUtil;

    @Override
    public List<WReceiptManagement> queryAll() {
        List<WReceiptManagement> wReceiptManagements = this.wReceiptManagementMapper.queryAll();
        return wReceiptManagements;
    }

    @Override
    public List<WReceiptManagementStatusDto> queryByStatus() {
        List<WReceiptManagementStatusDto> wReceiptManagementStatusDtos = this.wReceiptManagementStatusMapper.queryByStatus();
        return wReceiptManagementStatusDtos;
    }

    @Override
    public PageInfo<WReceiptManagement> queryChoiceAll(WReceiptManagementQueryDto wReceiptManagementQueryDto) {
        PageHelper.startPage(wReceiptManagementQueryDto.getPage(),wReceiptManagementQueryDto.getLimit());

        List<WReceiptManagement> wReceiptManagements = this.wReceiptManagementMapper.queryChoiceAll(wReceiptManagementQueryDto);

        PageInfo<WReceiptManagement> pageInfo = new PageInfo<>(wReceiptManagements);
        return pageInfo;
    }

    @Override
    public Integer addNo() {
        Integer receiptNo = this.docNoGenerationUtil.generateDocNo(1);
        return receiptNo;
    }

    @Override
    public List<WReceiptDetails> add(WReceiptManagementAddDto wReceiptManagementAddDto) {
        Integer receiptNo = wReceiptManagementAddDto.getReceiptNo();

        List<WReceiptDetailsAddDto> wReceiptDetailsAddDtos = wReceiptManagementAddDto.getWReceiptDetailsAddDtos();
        for(WReceiptDetailsAddDto wReceiptDetailsAddDto : wReceiptDetailsAddDtos){
            wReceiptDetailsAddDto.setReceiptNo(receiptNo);
        }

        wReceiptManagementAddDto.setWReceiptDetailsAddDtos(null);
        wReceiptManagementMapper.add(wReceiptManagementAddDto);
        wReceiptDetailsMapper.add(wReceiptDetailsAddDtos);

        List<WReceiptDetails> wReceiptDetails = wReceiptDetailsMapper.queryByReceiptNo(receiptNo);
        return wReceiptDetails;
    }

    @Override
    public String update(WReceiptManagementUpdateDto wReceiptManagementUpdateDto) {

        Integer receiptNo = wReceiptManagementUpdateDto.getReceiptNo();
        Integer auditStatus = wReceiptManagementMapper.queryByReceiptNo(receiptNo);

        if (auditStatus == 2){
            return "审核失败：入库单已审核通过，不能重复审核";
        }

        wReceiptManagementMapper.update(wReceiptManagementUpdateDto);
        auditStatus = wReceiptManagementUpdateDto.getAuditStatus();

        if(auditStatus == 2){
            List<WReceiptDetails> wReceiptDetails = wReceiptDetailsMapper.queryByReceiptNo(receiptNo);
            for(int i=0;i< wReceiptDetails.size();i++){
                System.out.println(wReceiptDetails.get(i));

                //获取器材编号
                Integer number = wReceiptDetails.get(i).getWfacilityManagement().getNumber();
                //获取数量
                Integer quantity = wReceiptDetails.get(i).getQuantity();
                //获取价格
                double unitPrice = wReceiptDetails.get(i).getUnitPrice();

                //通过入库单号 器材编号 查询库存信息
                WAccountDetailsQueryDto wAccountDetailsQueryDto = new WAccountDetailsQueryDto();
                wAccountDetailsQueryDto.setReceiptNo(receiptNo);
                wAccountDetailsQueryDto.setWfacilityManagementId(number);

                //添加到 库存
                WAccountDetailsAddDto wAccountDetailsAddDto = new WAccountDetailsAddDto();
                wAccountDetailsAddDto.setReceiptNo(receiptNo);
                wAccountDetailsAddDto.setWfacilityManagementId(number);
                wAccountDetailsAddDto.setQuantity(quantity);
                wAccountDetailsAddDto.setUnitPrice(unitPrice);


                List<WAccountDetailsAddDto> wAccountDetailsAddDtos = new ArrayList<>();
                wAccountDetailsAddDtos.add(wAccountDetailsAddDto);

                System.out.println("查询条件：" + wAccountDetailsAddDto);

                wAccountDetailsMapper.add(wAccountDetailsAddDtos);
            }
        }
        return "修改成功，添加明细成功";
    }

    @Override
    public String delete(Integer receiptNo) {

        Integer auditStatus = this.wReceiptManagementMapper.queryByReceiptNo(receiptNo);

        if (auditStatus == 2){
            return "删除失败：审核通过的入库单，不允许删除";
        }
        wReceiptManagementMapper.delete(receiptNo);
        wReceiptDetailsMapper.delete(receiptNo);
        return "删除成功";
    }
}
