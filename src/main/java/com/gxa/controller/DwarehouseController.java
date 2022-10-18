package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.*;
import com.gxa.service.DwarehouseService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "入库管理接口")
@RestController
public class DwarehouseController {

    @Autowired
    private DwarehouseService dwarehouseService;

    @PostMapping("/dwarehouse/list")
    @ApiOperation("入库管理列表")
    public Result<List<Dwarehouse>> selectDwarehouses(@RequestBody(required = false)DwarehouseDto dwarehouseDto,@Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + dwarehouseDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        PageHelper.startPage(page,limit);

        List<Dwarehouse> dwarehouses = this.dwarehouseService.queryDwarehouse(dwarehouseDto);
        System.out.println("查询结果----->" + dwarehouses);

        PageInfo<Dwarehouse> pageInfo = new PageInfo<>(dwarehouses);
        long total = pageInfo.getTotal();
        System.out.println("total---->" + total);

        Result<List<Dwarehouse>> r = Result.success(dwarehouses, total);
        return r;
    }

//    @GetMapping("/dwarehouse/perAdd")
//    @ApiOperation("入库新增页")//添加前的查询
//    public R toAddPage(){
//        R r = new R();
//        return r;
//    }
    @PostMapping("/dwarehouse/add")
    @ApiOperation("入库新增")
    public R dequipAdd(@RequestBody DwarehouseToAdd dwarehouseToAdd){
        System.out.println("添加数据"+dwarehouseToAdd);

        this.dwarehouseService.addDequip(dwarehouseToAdd);
//        if (dwarehouseToAdd1!=null){
            R r=R.ok("入库添加成功！");
            return r;
//        }else {
//            R r=R.error("入库添加失败！");
//            return r;
//        }
    }


    @PostMapping("/dwarehouse/perEdit")
    @ApiOperation("入库修改页")
    public R toEditPage(@RequestBody Dwarehouse dwarehouse){
        System.out.println("入库修改查询");

        R r = new R();
        return r;
    }
    @PutMapping("/dwarehouse/edit")
    @ApiOperation("入库修改")
    public R dequipEdit(@RequestBody Dwarehouse dwarehouse){
        System.out.println(dwarehouse);
        this.dwarehouseService.updateDwarehouse(dwarehouse);

        if (dwarehouse!=null){
            R r=R.ok("入库修改成功！");
            return r;
        }else {
            R r=R.error("入库修改失败！");
            return r;
        }
    }

    @DeleteMapping("/dwarehouse/delete")
    @ApiOperation("入库删除")
    public R dequipDelete(Integer id){
        System.out.println(id);
        this.dwarehouseService.deleteDwarehouse(id);
        if (id!=null){
            R r=R.ok("入库删除失败！");
            return r;
        }else {
            R r=R.error("入库删除失败！");
            return r;
        }
    }
    @DeleteMapping("/dwarehouse/deletes")
    @ApiOperation("入库删除(大量删除)")
    public R dequipDeletes(Integer id){

        System.out.println(id);
        this.dwarehouseService.deleteDwarehouse(id);
        if (id!=null){
            R r=R.ok("入库删除失败！");
            return r;
        }else {
            R r=R.error("入库删除失败！");
            return r;
        }
    }
}
