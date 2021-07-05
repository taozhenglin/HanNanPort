package com.cn.hainanproject.model;

/**
 * Created by tzl
 * on 2021/6/21
 */
public class AssertDetailBean {

    /**
     * name : 打印机
     * no : 123456
     * location : A3仓库
     * createdby : tzl
     * createdtime : 2021 06 21 14:20
     */

    private String name;
    private String no;
    private String location;
    private String createdby;
    private String createdtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }
}
