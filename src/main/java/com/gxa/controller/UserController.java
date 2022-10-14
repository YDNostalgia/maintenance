package com.gxa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxa.dto.UserDto;
import com.gxa.dto.UserRoleDto;
import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.utils.R;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    @ApiOperation("用户登录")
    @ResponseBody
    /**
     * 用户登录
     */
    public String login(@RequestBody User user, HttpSession session){
        System.out.println(user);

//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());

        try{
            User user1 = this.userService.login(user.getUserName(),user.getPwd());
            if (user1!=null){
                System.out.println("成功");
            }
//            subject.login(token);
            //登录成功

            return "redirect:/main.html";
        }catch (Exception e){
            e.printStackTrace();
            //登录失败
            return "redirect:/index.html";
        }
    }

    /**
     * 用户退出
     */

    @ApiOperation("用户退出")
    @GetMapping("/user/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/index.html";

    }


    /**
     * 用户列表
     */
    @ApiOperation("用户列表")
    @GetMapping("/user")
    @ResponseBody
    public Result<List<User>> list(UserDto userDto, Integer page, Integer limit){

        PageInfo pageInfo = this.userService.queryAll(userDto,page,limit);

        Result<List<User>> r=Result.success(pageInfo.getList(),pageInfo.getTotal());
        return r;
    }

    /**
     * 用户添加
     */
    @ApiOperation("用户添加")
    @PostMapping("/user")
    @ResponseBody
    public Result<User> add(@RequestBody User user){
        System.out.println("***********" + user);
        this.userService.add(user);
        Integer roleId =this.userService.queryRoleId(user.getRoleName());
        System.out.println(user.getId());
        this.userService.addUserRoleId(user.getId(), roleId);
        Result<User> r=Result.success();
        return r;
    }

    /**
     * 用户修改
     */
    @ApiOperation("用户修改")
    @PutMapping("/user")
    @ResponseBody
    public Result<User> update(@RequestBody User user){
        System.out.println("***********" + user);
        this.userService.update(user);
        Result<User> r=Result.success();
        return r;
    }

    /**
     * 用户删除
     */
    @ApiOperation("用户删除")
    @DeleteMapping("/user")
    @ResponseBody
    public Result<User> delete(@RequestParam("id") Integer id){
        this.userService.delete(id);
        Result<User> r=Result.success();
        return r;
    }




}
