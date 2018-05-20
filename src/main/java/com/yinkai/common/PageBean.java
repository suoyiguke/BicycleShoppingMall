package com.yinkai.common;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean implements Serializable {
    // @JSONField(serialize=false)
    private int currentPage;//当前页码
    //@JSONField(serialize=false)
    private int pageSize;//每页显示的记录数


    private int total;//总记录数
    private List rows;//当前页需要展示的数据集合


    //接受其他问号参数
    @JSONField(serialize=false)
    private List<Object> pram=new ArrayList<Object>();


    public int getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //绑定问号参数
        this.setCanshu();

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public List<Object> getPram() {
        return pram;
    }

    public void setPram(List<Object> pram) {
        this.pram = pram;
    }

    public PageBean() {};

    public void setCanshu(){

        this.getPram().add((currentPage - 1) * pageSize);
        this.getPram().add(pageSize);
    }

}