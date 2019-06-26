package com.admin.controller;

import com.admin.constants.ReturnType;
import com.admin.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN')")
public class RoleController {

    @GetMapping("/testRole")
    @ApiOperation("测试权限")
    @ResponseBody
    public Result testRole(){
        return ReturnType.SUCCESS;

    }

}
