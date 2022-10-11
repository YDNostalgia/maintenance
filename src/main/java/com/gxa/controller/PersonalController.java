package com.gxa.controller;

import com.gxa.entity.Personal;
import com.gxa.service.PersonalService;
import com.gxa.utils.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "人员信息")
@RestController
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @ApiOperation(value = "人员信息列表")
    @GetMapping(value = "/personal/list")
    public TableResult personalList(){
        List<Personal> personals = this.personalService.queryAll();
        System.out.println(personals);
        TableResult tableResult = new TableResult(0,"suc",personals.size(),personals);

        return tableResult;
    }

}
