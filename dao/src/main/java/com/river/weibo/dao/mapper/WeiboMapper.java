package com.river.weibo.dao.mapper;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.Weibo;

import java.util.List;

public interface WeiboMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKey(Weibo record);

    List<Weibo> list(PageInfoVO pageInfoVO);

    Integer count();
}