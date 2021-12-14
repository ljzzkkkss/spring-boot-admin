package com.admin.controller;

import com.admin.constants.ReturnType;
import com.admin.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/testRole")
    @ApiOperation("测试权限")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result testRole(){
        return ReturnType.SUCCESS;

    }

}
