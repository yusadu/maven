package edu.nf.entity;

import java.util.List;

public class PageBean {
    //请求的页数
    private Integer pageNum;
    //请求的页数的记录数量
    private Integer pageSize;
    //请求的总页数
    private Integer pageCount;
    //当前页数据
    private List<?> data;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {

        this.pageCount = pageCount;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
