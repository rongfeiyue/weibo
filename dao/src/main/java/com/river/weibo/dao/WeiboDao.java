package com.river.weibo.dao;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.Weibo;

import java.util.List;

public interface WeiboDao {

    List<Weibo> getList(PageInfoVO page);

    Integer getListTotal();

    Integer updateByPrimaryKeySelective(Weibo weibo);

    Weibo selectByPrimaryKey(Integer id);

    void add(Weibo weibo);
}
