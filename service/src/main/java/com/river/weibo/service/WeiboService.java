package com.river.weibo.service;

import com.river.weibo.common.enums.OperateEnum;
import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.ResponseVO;
import com.river.weibo.common.vo.Weibo;

import java.util.List;

public interface WeiboService {

    /**
     * 查询列表
     * @param page
     * @return
     */
    ResponseVO<List<Weibo>> queryForList(PageInfoVO page);


    Integer operate(OperateEnum operate, Integer id);

    void add(String content);
}
