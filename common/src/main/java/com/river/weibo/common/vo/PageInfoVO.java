package com.river.weibo.common.vo;

public class PageInfoVO {

    private Integer page;
    private Integer rows;

    private Integer startRows;
    private Integer endRows;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getStartRows() {
        return this.rows*(this.page-1);
    }

    public Integer getEndRows() {
        return this.rows*this.page;
    }
}