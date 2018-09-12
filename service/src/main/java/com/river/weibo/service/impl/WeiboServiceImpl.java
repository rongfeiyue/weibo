package com.river.weibo.service.impl;

import com.river.weibo.common.enums.OperateEnum;
import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.ResponseVO;
import com.river.weibo.common.vo.Weibo;
import com.river.weibo.dao.WeiboDao;
import com.river.weibo.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    private WeiboDao weiboDao;

    @Override
    public ResponseVO<List<Weibo>> queryForList(PageInfoVO page) {
        ResponseVO responseVO = new ResponseVO().buildSuccessResponse(weiboDao.getList(page));
        responseVO.setTotal(weiboDao.getListTotal());
        return responseVO;
    }

    @Override
    public Integer operate(OperateEnum operate, Integer id) {
        Weibo weibo = weiboDao.selectByPrimaryKey(id);
        switch (operate) {
            case TOP:
                weibo.setAcc(weibo.getAcc() + 1);
                break;
            case DOWN:
                weibo.setRef(weibo.getRef() + 1);
                break;
            case DELETE:
                weibo.setDeleted((byte) 1);
                break;
            default:
                break;
        }
        return weiboDao.updateByPrimaryKeySelective(weibo);
    }

    @Override
    public void add(String content) {
        weiboDao.add(new Weibo(content));
    }
}
