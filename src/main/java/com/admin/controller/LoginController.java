package com.admin.controller;

import com.admin.constants.ReturnType;
import com.admin.model.User;
import com.admin.service.UserService;
import com.admin.utils.MD5Util;
import com.admin.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Api("用户登录注册")
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/regist")
    @ApiOperation("用户注册")
    @ResponseBody
    public Result regist(@RequestBody User user){
        User checkUser = userService.findByUsername(user.getUsername());
        if(checkUser != null){
            return ReturnType.DUMPLICATED_USERNAME;
        }
        user.setPassword(MD5Util.md5(user.getPassword()));
        user.setRoleId(1L);
        userService.insert(user);
        return ReturnType.SUCCESS;

    }
}
