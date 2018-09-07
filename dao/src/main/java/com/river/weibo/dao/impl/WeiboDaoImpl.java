package com.river.weibo.dao.impl;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.WeiboDTO;
import com.river.weibo.dao.WeiboDao;
import com.river.weibo.dao.mapper.WeiboDTOMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WeiboDaoImpl implements WeiboDao {

    @Resource
    private WeiboDTOMapper weiboDTOMapper;

    public List<WeiboDTO> getList(PageInfoVO page) {
        return weiboDTOMapper.list(page);
    }
}
