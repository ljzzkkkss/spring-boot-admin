package com.admin.constants;

import com.admin.utils.Result;

public class ReturnType {
    public static final Result SUCCESS = new Result("0000","访问成功！");
    public static final Result ERROR = new Result("0100","系统错误！");
    public static final Result DUMPLICATED_USERNAME = new Result("0101","用户名已存在！");
    public static final Result USER_ERROR = new Result("0102","用户名或密码错误！");
    public static final Result NO_SESSION = new Result("0103","session失效！");
    public static final Result NEED_LOGIN = new Result("0104","需要登录！");
    public static final Result NO_PERMISSION = new Result("0105","无权限！");
}
