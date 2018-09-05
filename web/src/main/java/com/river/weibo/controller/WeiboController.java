package com.river.weibo.controller;

import com.river.weibo.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeiboController {

    @GetMapping("/weibo")
    public String weibo() {
        return "weibo/weibo";
    }


    @GetMapping("/getList")
    @ResponseBody
    public ResponseVO getList(Integer page) {
        return new ResponseVO().buildSuccessResponse();
    }
}
