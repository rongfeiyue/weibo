package com.river.weibo.controller;

import com.alibaba.fastjson.JSON;
import com.river.weibo.common.enums.OperateEnum;
import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.ResponseVO;
import com.river.weibo.common.vo.Weibo;
import com.river.weibo.service.WeiboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/weibo")
public class WeiboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeiboController.class);

    @Autowired
    private WeiboService weiboService;

    @RequestMapping("/index")
    public String weibo(HttpServletRequest request) {
        request.setAttribute("version", System.currentTimeMillis());
        return "weibo/weibo";
    }

    @GetMapping("/getList")
    @ResponseBody
    public ResponseVO getList(PageInfoVO page) {
        LOGGER.info("请求参数：{}", JSON.toJSONString(page));
        return weiboService.queryForList(page);
    }

    @PostMapping("/operate/{opt}/{id}")
    @ResponseBody
    public ResponseVO operate(@PathVariable("opt") String opt, @PathVariable("id") Integer id) {
        LOGGER.info("请求参数：opt:{},id:{}", opt, id);
        return new ResponseVO().buildSuccessResponse(weiboService.operate(OperateEnum.getByCode(opt), id));
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseVO add(@RequestParam("content") String content) {
        LOGGER.info("请求参数：content:{}", content);
        weiboService.add(content);
        return new ResponseVO().buildSuccessResponse();
    }
}
