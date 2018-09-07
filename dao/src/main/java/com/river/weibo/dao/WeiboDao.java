package com.river.weibo.dao;

import com.river.weibo.common.vo.PageInfoVO;
import com.river.weibo.common.vo.WeiboDTO;

import java.util.List;

public interface WeiboDao {

    List<WeiboDTO> getList(PageInfoVO page);
}
