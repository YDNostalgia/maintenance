package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.TDataAddDropDownFrame;
import com.gxa.dto.TDataDropDownFrame;
import com.gxa.dto.TDataDto;
import com.gxa.entity.TData;
import com.gxa.entity.TDataToAdd;
import com.gxa.entity.TDataToUpdate;
import com.gxa.service.TDataService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //等同于@Controller（表面这个类是一个控制器类）+@ResponseBody（方法的返回值以指定格式写入http response body中）
@Api(tags = "资料管理接口")
public class TDataController {

    @Autowired
    private TDataService tDataService;

    @ApiOperation("查询资料")
    @PostMapping("/data/list")
    public Result<List<TData>> queryAllTData( Integer page, Integer limit,@RequestBody(required = false) TDataDto tDataDto){
        System.out.println("tDataDto-->" +tDataDto);
        System.out.println(page + "----" + limit);
        Result<List<TData>> r = new Result<>();
        try {
            PageInfo<TData> pageInfo = tDataService.queryTDatas(page, limit, tDataDto);
            System.out.println("查询出的数据："+ pageInfo.getList());
            r = Result.success(pageInfo.getList(),pageInfo. getTotal());
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        System.out.println(r);

        return r;
    }




    @ApiOperation("删除资料")
    @DeleteMapping("/data/delete")
    public R delete(@Param ("dataId")@ApiParam(value = "资料id",name = "dataId",required = true) Integer dataId){
        R r;
        this.tDataService.deleteByDataId(dataId);
        r = R.ok("删除成功");
        return r;
    }


    @ApiOperation("添加资料")
    @PostMapping("/data/add")
    public Result add(@RequestBody TDataToAdd tDataToAdd){
        if (tDataToAdd != null){
            this.tDataService.add(tDataToAdd);
            return Result.success();
        }else {
            return Result.failed();
        }
    }

    @ApiOperation("更新资料")
    @PutMapping("/data/update")
    public Result<List<TDataToUpdate>> update(@RequestBody TDataToUpdate tDataToUpdate){
        Result<List<TDataToUpdate>> r = Result.success();
        try {
            tDataService.update(tDataToUpdate);
        }catch (Exception e){
            e.printStackTrace();
            Result.failed();
        }
        return r;
    }

    @ApiOperation("资料管理的装备型号的下拉列表")
    @PostMapping("/data/selectEquipmentModel")
    public Result<List<String>> selectEquipmentModel(){
        Result<List<String>> r = Result.success();
        try {
            List<String> tDataDropDownFrameList = tDataService.selectEquipmentModel();
            System.out.println(tDataDropDownFrameList.get(1));
            r = Result.success(tDataDropDownFrameList);
            System.out.println(r);
        }catch (Exception e){
            e.printStackTrace();
            r.failed();
        }
        return r;
    }


    @ApiOperation("资料添加的资料类型的下拉列表")
    @PostMapping("/data/selectDataType")
    public Result<List<TDataAddDropDownFrame>> selectTDataType(){
        Result<List<TDataAddDropDownFrame>> r = Result.success();
        try {
            List<TDataAddDropDownFrame> tDataAddDropDownFrames = tDataService.selectTDataType();
            r = Result.success(tDataAddDropDownFrames);
            System.out.println(r);
        }catch (Exception e){
            e.printStackTrace();
            r.failed();
        }
        return r;
    }



}
