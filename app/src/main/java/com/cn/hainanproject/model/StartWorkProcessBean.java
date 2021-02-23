package com.cn.hainanproject.model;

import java.io.Serializable;

public class StartWorkProcessBean implements Serializable {

    /**
     * CONTRACTNUM : 3008
     * msg : 流程启动成功！
     * nextStatus : 草稿
     */

    private String CONTRACTNUM;
    private  String CONTRACTID;
    private String msg;
    private String nextStatus;
    private String tag;
    private  String RFQNUM;
    private String RFQID;
    String WONUM;
    String VENDORSAPPLYID;
    String STOCKNUM;
    int errorNo;
    String success;
    String UDPURCHBGID;
    String FIXPDNUM;
    String INVUSEID;
    public String getINVUSEID() {
        return INVUSEID;
    }

    public void setINVUSEID(String INVUSEID) {
        this.INVUSEID = INVUSEID;
    }



    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    String errorMsg;
    public String getSTOCKNUM() {
        return STOCKNUM;
    }

    public void setSTOCKNUM(String STOCKNUM) {
        this.STOCKNUM = STOCKNUM;
    }



    public String getVENDORSAPPLYID() {
        return VENDORSAPPLYID;
    }

    public void setVENDORSAPPLYID(String VENDORSAPPLYID) {
        this.VENDORSAPPLYID = VENDORSAPPLYID;
    }



    public String getWONUM() {
        return WONUM;
    }

    public void setWONUM(String WONUM) {
        this.WONUM = WONUM;
    }



    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    public String getRFQID() {
        return RFQID;
    }

    public void setRFQID(String RFQID) {
        this.RFQID = RFQID;
    }



    public String getRFQNUM() {
        return RFQNUM;
    }

    public void setRFQNUM(String RFQNUM) {
        this.RFQNUM = RFQNUM;
    }




    public String getCONTRACTID() {
        return CONTRACTID;
    }

    public void setCONTRACTID(String CONTRACTID) {
        this.CONTRACTID = CONTRACTID;
    }


    public String getCONTRACTNUM() {
        return CONTRACTNUM;
    }

    public void setCONTRACTNUM(String CONTRACTNUM) {
        this.CONTRACTNUM = CONTRACTNUM;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
}
