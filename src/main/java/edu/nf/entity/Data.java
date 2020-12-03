package edu.nf.entity;

import java.util.List;

public class Data {
    private Integer pageCount;
    private List<City> list;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }
}

