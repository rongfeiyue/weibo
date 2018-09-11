package com.river.weibo.controller;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.ResponseVO;
import com.river.weibo.common.vo.Weibo;
import com.river.weibo.service.WeiboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/weibo")
public class WeiboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeiboController.class);

    @Autowired
    private WeiboService weiboService;

    @GetMapping("/index")
    public String weibo() {
        return "weibo/weibo";
    }

    @GetMapping("/getList")
    @ResponseBody
    public ResponseVO getList(PageInfoVO page) {
        return new ResponseVO().buildSuccessResponse(weiboService.getList(page));
    }
}
