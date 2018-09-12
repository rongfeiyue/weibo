package com.river.weibo.dao.impl;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.Weibo;
import com.river.weibo.dao.WeiboDao;
import com.river.weibo.dao.mapper.WeiboMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WeiboDaoImpl implements WeiboDao {

    @Resource
    private WeiboMapper weiboMapper;

    @Override
    public List<Weibo> getList(PageInfoVO page) {
        return weiboMapper.list(page);
    }

    @Override
    public Integer getListTotal() {
        return weiboMapper.count();
    }

    @Override
    public Integer updateByPrimaryKeySelective(Weibo weibo) {
        return weiboMapper.updateByPrimaryKeySelective(weibo);
    }

    @Override
    public Weibo selectByPrimaryKey(Integer id) {
        return weiboMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Weibo weibo) {
        weiboMapper.insertSelective(weibo);
    }
}
