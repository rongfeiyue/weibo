package com.river.weibo.service;

import com.river.weibo.common.vo.WeiboVO;

import java.util.List;

public interface WeiboService {

    /**
     * 查询列表
     * @param page
     * @return
     */
    List<WeiboVO> getList(Integer page);
}
