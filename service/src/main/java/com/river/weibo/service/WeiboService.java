package com.river.weibo.service;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.Weibo;

import java.util.List;

public interface WeiboService {

    /**
     * 查询列表
     * @param page
     * @return
     */
    List<Weibo> getList(PageInfoVO page);
}
