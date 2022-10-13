package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.entity.Role;
import com.gxa.entity.User;
import com.gxa.service.RoleService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "角色管理")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("角色列表")
    @GetMapping("/role/list")
    @ResponseBody
    public Result<List<Role>> list(UserDto userDto, Integer page, Integer limit){

        PageHelper.startPage(page,limit);
        List<Role> roles = this.roleService.queryAll(userDto);
        System.out.println("hgghhh----------"+roles.get(0));
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        long total = (int) pageInfo.getTotal();
        Result<List<Role>> r=Result.success(roles,total);
//        r.setTotal(total);
        System.out.println(total);
        return r;
    }

    /**
     * 用户添加
     */
    @ApiOperation("角色添加")
    @GetMapping("/role/add")
    @ResponseBody
    public R add(@RequestBody Role role){
        return null;
    }

    /**
     * 用户修改
     */
    @ApiOperation("角色修改")
    @GetMapping("/role/update")
    @ResponseBody
    public R update(@RequestBody Role role){
        return null;
    }

    /**
     * 用户删除
     */
    @ApiOperation("角色删除")
    @GetMapping("/role/delete")
    @ResponseBody
    public R delete(@RequestBody List<Role> roles){
        return null;
    }

}
