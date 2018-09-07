package com.river.weibo.service.impl;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.WeiboDTO;
import com.river.weibo.dao.WeiboDao;
import com.river.weibo.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    private WeiboDao weiboDao;

    public List<WeiboDTO> getList(PageInfoVO page) {
        return weiboDao.getList(page);
    }
}
