package com.zzq.common.custom;

import com.zzq.common.api.ApiCode;
import com.zzq.common.api.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by zhaozongqi on 2019/12/8
 * 统一处理
 */
@RestControllerAdvice
public class SysExceptionHandler {
    
    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiResult businessException(BusinessException e) {
        return ApiResult.fail(e.getApiCode());
    }
}
