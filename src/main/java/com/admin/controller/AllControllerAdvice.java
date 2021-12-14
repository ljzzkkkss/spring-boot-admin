package com.admin.controller;

import com.admin.constants.ReturnType;
import com.admin.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AllControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(HttpServletRequest request, Exception e) {
        logger.error(request.getRequestURI() + " error occurs :", e);
        return ReturnType.ERROR;
    }

    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result methodErrorHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        logger.error(request.getRequestURI() + " error occurs :", e);
        return ReturnType.METHOD_ERROR;
    }

    //这里只能在这里捕获，因为errorHandler捕获了全部异常，导致这个异常没法被spring boot security捕获
    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public Result accessErrorHandler(HttpServletRequest request, AccessDeniedException e) {
        logger.error(request.getRequestURI() + " error occurs :", e);
        return ReturnType.NO_PERMISSION;
    }
}
