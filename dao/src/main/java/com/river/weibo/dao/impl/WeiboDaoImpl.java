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

    public List<Weibo> getList(PageInfoVO page) {
        return weiboMapper.list(page);
    }
}
