package com.gxa.controller;

import com.gxa.dto.DwarehouseDto;
import com.gxa.entity.Dwarehouse;
import com.gxa.service.DwarehouseService;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "入库管理")
@RestController
public class DwarehouseController {

    @Autowired
    private DwarehouseService dwarehouseService;

    @GetMapping("/dwarehouse/list")
    @ApiOperation("入库管理列表")
    public R selectDarehouses(@RequestBody(required = false)DwarehouseDto dwarehouseDto, @Param("page") Integer page,@Param("limit") Integer limit){
        System.out.println("查询条件" + dwarehouseDto);
        System.out.println("当前页码：" + page +",每页记录数：" + limit);

        List<Dwarehouse> dwarehouses = this.dwarehouseService.queryDwarehouse();
        System.out.println(dwarehouses);

        R r = new R();
        r.put("count",dwarehouses.size());
        r.put("data",dwarehouses);

        return r;
    }
}
