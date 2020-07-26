package com.yanle.mybatis.plus.demo1.system.config.exception;

import com.yanle.mybatis.plus.demo1.common.base.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class InterfaceExceptionHandler {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResponse handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public ApiResponse handleNullPointerException(NullPointerException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessInterfaceException.class)
    public ApiResponse handleBusinessInterfacePointerException(BusinessInterfaceException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.fail(e.getMessage());
    }
}
