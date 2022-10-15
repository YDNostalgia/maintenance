package com.gxa.controller;

import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.service.RoleService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "角色管理")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("角色列表")
    @GetMapping("/role")
    @ResponseBody
    public Result<List<Role>> list(Role role, Integer page, Integer limit){
        PageInfo pageInfo= this.roleService.queryAll(role,page,limit);
        Result<List<Role>> r=Result.success(pageInfo.getList(),pageInfo.getTotal());

        return r;
    }

    /**
     * 用户添加
     */
    @ApiOperation("角色添加")
    @PostMapping("/role")
    @ResponseBody
    public Result<Role> add(@RequestBody Role role){
        System.out.println("***********" + role);
        this.roleService.add(role);
        Result<Role> r=Result.success();
        return r;
    }

    /**
     * 用户修改
     */
    @ApiOperation("角色修改")
    @PutMapping("/role")
    @ResponseBody
    public Result<Role> update(@RequestBody Role role){
        System.out.println("***********" + role);
        this.roleService.update(role);
        Result<Role> r=Result.success();
        return r;
    }

    /**
     * 用户删除
     */
    @ApiOperation("角色删除")
    @DeleteMapping("/role")
    @ResponseBody
    public Result<Role> delete(@RequestParam("id") Integer id){
        this.roleService.delete(id);
        Result<Role> r=Result.success();
        return r;
    }

}
