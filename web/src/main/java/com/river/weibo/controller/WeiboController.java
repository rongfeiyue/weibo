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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeiboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeiboController.class);

    @Autowired
    private WeiboService weiboService;

    @GetMapping("/weibo")
    public String weibo() {
        return "weibo/weibo";
    }


    @GetMapping("/getList")
    @ResponseBody
    public ResponseVO getList(PageInfoVO page) {
        LOGGER.debug("debug msg");
        LOGGER.info("info msg");
        LOGGER.error("error msg");
        return new ResponseVO().buildSuccessResponse(weiboService.getList(page));
    }
}
