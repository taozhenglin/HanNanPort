package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

public class PostData implements Serializable {
    int id;
    String data;
     List<String> stringList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    private String nextStatus;

    int count;

    public int getId() {
        return id;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    String tag;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



//    public List<String> getList() {
//        return stringList;
//    }
//
//    public void setList(List<String> list) {
//        this.stringList = list;
//    }

}
