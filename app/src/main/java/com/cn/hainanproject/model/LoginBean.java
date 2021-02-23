package com.cn.hainanproject.model;

import java.io.Serializable;

public class LoginBean implements Serializable {


    /**
     * errcode : USER-S-101
     * errmsg : 登录成功
     * loginid : maxadmin
     * personid : MAXADMIN
     */

    private String errcode;
    private String errmsg;
    private String loginid;
    private String personid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }
}
