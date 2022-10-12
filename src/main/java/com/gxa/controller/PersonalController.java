package com.gxa.controller;

import com.gxa.dto.PersonalQueryDto;
import com.gxa.entity.Personal;
import com.gxa.service.PersonalService;
import com.gxa.utils.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "人员信息")
@RestController
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "人员信息列表")
    @GetMapping(value = "/personal/list")
    public TableResult personalList(@RequestBody(required = false) PersonalQueryDto personalQueryDto, @Param("page") Integer page, @Param("limit") Integer limit){
        System.out.println("查询条件" + personalQueryDto);
        System.out.println("当前页码-->" + page + ",每页记录数-->" + limit);
        List<Personal> personals = this.personalService.queryAllPersonal();
        System.out.println(personals);
        TableResult tableResult = new TableResult(0,"suc",personals.size(),personals);

        return tableResult;
    }

}
