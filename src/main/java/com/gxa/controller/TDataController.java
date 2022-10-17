package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.TDataDto;
import com.gxa.dto.TDataEditDto;
import com.gxa.entity.TData;
import com.gxa.entity.TDataToAdd;
import com.gxa.service.TDataService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //等同于@Controller（表面这个类是一个控制器类）+@ResponseBody（方法的返回值以指定格式写入http response body中）
@Api("资料")
public class TDataController {

    @Autowired
    private TDataService tDataService;

    @ApiOperation("查询资料")
    @GetMapping("/data/list")
    public Result<List<TData>> queryAllTData( Integer page, Integer limit, TDataDto tDataDto){
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
    public R delete(TData tData){
        R r;
        this.tDataService.deleteByDataId(tData.getDataId());
        r = R.ok("删除成功");
        return r;
    }


    @ApiOperation("添加资料")
    @PostMapping("/data/add")
    public Result add(TDataToAdd tDataToAdd){
        if (tDataToAdd != null){
            this.tDataService.add(tDataToAdd);
            return Result.success();
        }else {
            return Result.failed();
        }
    }



}
