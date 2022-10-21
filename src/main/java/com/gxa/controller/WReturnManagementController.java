package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.*;
import com.gxa.entity.WReturnManagement;
import com.gxa.service.WReturnManagementService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门退料")
public class WReturnManagementController {

    @Autowired
    private WReturnManagementService wReturnManagementService;

    @ApiOperation("生成退料料单号")
    @GetMapping("/WReturnManagement/addNo")
    public Result addNo(){

        Result r = Result.failed();
        try {
            Integer returnNo = wReturnManagementService.addNo();
            r = Result.success(returnNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("查询部门退料单")
    @PostMapping("/WReturnManagement/list")
    public Result<List<WReturnManagement>> list(@RequestBody WReturnManagementQueryDto wReturnManagementQueryDto){

        Result<List<WReturnManagement>> r = Result.failed();
        PageInfo<WReturnManagement> pageInfo = wReturnManagementService.queryByCondition(wReturnManagementQueryDto);
        List<WReturnManagement> wReturnManagements = pageInfo.getList();
        long total = pageInfo.getTotal();

        if (wReturnManagements != null){
            r = Result.success(wReturnManagements,total);
            return r;
        }
        return r;
    }

    @ApiOperation("添加部门退料单")
    @PostMapping("/WReturnManagement/add")
    public Result add(@RequestBody WReturnManagementAddDto wReturnManagementAddDto){

        Result r = Result.failed();
        try {
            wReturnManagementService.add(wReturnManagementAddDto);
            r = Result.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("审核部门退料单")
    @PutMapping("/WReturnManagement/update")
    public Result  update(@RequestBody WReturnManagementUpdateDto wReturnManagementUpdateDto){

        Result r = Result.failed();
        try {
            String msg = wReturnManagementService.update(wReturnManagementUpdateDto);
            if ( msg.equals("审核成功")){
                r = Result.success();
                r.setMsg(msg);
            }else {
                r = Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation("删除部门退料单")
    @DeleteMapping("/WReturnManagement/delete")
    public Result  delete(@Param("returnNo") Integer returnNo){

        Result r = Result.failed();
        try {
            String msg = wReturnManagementService.delete(returnNo);
            if ( msg.equals("删除成功")){
                r = Result.success();
                r.setMsg(msg);
            }else {
                r = Result.failed(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

}
