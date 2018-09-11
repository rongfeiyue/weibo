package com.river.weibo.config;

import com.river.weibo.common.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseVO handler(Exception e) {
        return new ResponseVO().buildFailureResponse(e.getMessage());
    }
}
