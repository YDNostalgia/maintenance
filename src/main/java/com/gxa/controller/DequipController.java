package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DequipDto;
import com.gxa.entity.*;
import com.gxa.service.DequipService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(tags = "器材管理接口")
@RestController
public class DequipController {

    @Autowired
    private DequipService dequipService;


    @PostMapping("D")
    @ApiOperation("器材管理列表")
    public Result<List<Dequip>> selectList(@RequestBody(required = false) DequipDto dequipDto){
        System.out.println("查询条件----->" + dequipDto);
        System.out.println("当前页码----->" + dequipDto.getPage() + ",每页数据---->" + dequipDto.getLimit());

        //实现分页
        PageHelper.startPage(dequipDto.getPage(),dequipDto.getLimit());

        List<Dequip> dequips = this.dequipService.queryChooseList(dequipDto);
        System.out.println("查询结果----->" + dequips);

        //获取总记录数
        PageInfo<Dequip> pageInfo = new PageInfo<>(dequips);
        Long total = pageInfo.getTotal();
        System.out.println("total----->" + total);

        Result<List<Dequip>> r = Result.success(dequips, total);

        return r;
    }
    @GetMapping("/dequip/dtype")
    @ApiOperation("器材分类 下拉列表")
    public Result<List<Detype>> selectTypeList(){
        List<Detype> detypes = this.dequipService.queryType();
        System.out.println("查询结果----->" + detypes);

        //查询总记录数
        Integer size = detypes.size();
        Long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Detype>> r = Result.success(detypes, total);

        return r;
    }
    @GetMapping("/dequip/dsave")
    @ApiOperation("存放区域 下拉列表")
    public Result<List<Desave>> selectSaveList(){
        List<Desave> desaves = this.dequipService.querySave();
        System.out.println("查询结果----->" + desaves);

        Integer size = desaves.size();
        long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Desave>> r = Result.success(desaves, total);
        return r;
    }

    @GetMapping("/dequip/dcompany")
    @ApiOperation("单位 下拉列表")
    public Result<List<Decompany>> selectCompanyList(){
        List<Decompany> decompanies = this.dequipService.queryCompany();
        System.out.println("查询结果----->" + decompanies);

        Integer size = decompanies.size();
        long total = size.longValue();
        System.out.println("total-->" + total);

        Result<List<Decompany>> r = Result.success(decompanies, total);
        return r;
    }


    @PostMapping("/dequip/add")
    @ApiOperation("器材新增")
    public R addDequip(@RequestBody Dequip dequip){
        System.out.println("添加数据——>" + dequip);

        Dequip queryAdd = this.dequipService.addDequip(dequip);

        if(queryAdd != null){
            R r = R.ok("添加成功");
            return r;
        } else {
            R r = R.error(1,"添加失败,请重新添加");
            return r;
        }
    }


    @GetMapping("/dequip/perEdit")
    @ApiOperation("器材修改前的查询")
    public R queryById(String code){
        System.out.println(code);
        Dequip queryByCode = this.dequipService.queryByCode(code);

        R r = new R();
        r.put("data",queryByCode);
        return r;
    }
    @PostMapping("/dequip/edit")
    @ApiOperation("器材修改")
    public R updateDequip(@RequestBody Dequip dequip){
        System.out.println(dequip);

        this.dequipService.updateDequip(dequip);
        if(dequip != null){
            R r = R.ok("此数据修改成功");
            return r;
        }else {
            R r = R.error(1,"数据修改失败，请重新修改");
            return r;
        }

    }

    @GetMapping("/dequip/delete")
    @ApiOperation("器材删除")
    public R dequipDelete(String code){
        System.out.println(code);

        this.dequipService.deleteByCode(code);
        if(code != null){
            R r = R.ok("该数据删除成功！");
            return r;
        } else {
            R r = R.error(1, "该数据删除失败,请重新发起请求！");
            return r;
        }
    }
    @GetMapping("/dequip/deletes")
    @ApiOperation("批量删除")
    public R dequipDeletes(String code){
        //前端传回的字符串 转化为数组
        String[] split = code.split(",");
        if(split != null && split.length>0){
            if(dequipService.deleteManyCode(split) > 0){
                R r = R.ok("数据删除成功");
                return r;
            } else {
                R r = R.error(1,"数据删除失败");
                return r;
            }
        } else {
            R r = R.error(1,"数据删除失败");
            return r;
        }
    }
}
