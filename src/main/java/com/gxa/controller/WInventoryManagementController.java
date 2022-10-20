package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.EquipmentManagementDto;
import com.gxa.dto.WInventoryAuditStatusDto;
import com.gxa.dto.WInventoryManagementDto;
import com.gxa.entity.EquipmentManagement;
import com.gxa.entity.EquipmentManagementAU;
import com.gxa.entity.WInventoryManagement;
import com.gxa.entity.WPickingDetails;
import com.gxa.service.WInventoryManageMentService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Api(tags = "库存盘点接口")
public class WInventoryManagementController {
    @Autowired
    private WInventoryManageMentService wInventoryManageMentService;


    @PostMapping("/wInventoryManagement/list")
    @ApiOperation("")
    public Result<List<WInventoryManagement>> listWInventory(@RequestBody(required = false) WInventoryManagementDto wInventoryManagementDto, Integer page, Integer limit){
        Result<List<WInventoryManagement>> r=Result.success();
        try {
            PageHelper.startPage(page,limit);
            List<WInventoryManagement> wInventoryManagements=this.wInventoryManageMentService.queryAll(wInventoryManagementDto);
            PageInfo<WInventoryManagement> pageInfo = new PageInfo<>(wInventoryManagements);
            long total = (int) pageInfo.getTotal();
            r=Result.success(wInventoryManagements,total);
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }

    @PostMapping("/wInventoryManagement/preselect")
    public R wInventoryManagementPreadd(){
        R r=new R();
        List<WInventoryAuditStatusDto> AuditStatus=this.wInventoryManageMentService.queryAuditStatus();
        List<WInventoryAuditStatusDto> Inventoryno=this.wInventoryManageMentService.queryInventoryNo();

        System.out.println(AuditStatus);
        System.out.println(Inventoryno);
        r.put("AuditStatus",AuditStatus);//状态集合
        r.put("Inventoryno",Inventoryno);//单号集合
        return r;
    }

    @PostMapping("/WInventoryDetails/add")
    @ApiOperation("装备添加")
    public Result<WPickingDetails> WInventoryAdd(@RequestBody WPickingDetails wPickingDetails){

        Result<WPickingDetails> r=Result.success();
        try {
//            this.wInventoryManageMentService.
            r=Result.success();
        }catch (Exception e){
            r.setCode("1");
            r.setMsg("error");
            e.printStackTrace();
        }
        return r;
    }
}
