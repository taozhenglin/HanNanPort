package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/3/16
 */
public class WxServerXbjListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"JM1门机整机防腐","ENTERBY":"SHIHUIZHEN","ENTERBYDESC":"施惠珍","RFQID":200,"RFQNUM":"1109","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"询价建立"},{"DESCRIPTION":"维修","ENTERBY":"WANGJIALING","ENTERBYDESC":"王佳祾","RFQID":195,"RFQNUM":"1104","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"关闭"},{"DESCRIPTION":"JM1门机整机防腐","ENTERBY":"SHIHUIZHEN","ENTERBYDESC":"施惠珍","RFQID":201,"RFQNUM":"1110","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"询价建立"}],"showcount":10,"totalpage":1,"totalresult":3}
     * username : null
     */

    private String errcode;
    private String errmsg;
    private Object loginid;
    private Object personid;
    private ResultBean result;
    private Object username;

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

    public Object getLoginid() {
        return loginid;
    }

    public void setLoginid(Object loginid) {
        this.loginid = loginid;
    }

    public Object getPersonid() {
        return personid;
    }

    public void setPersonid(Object personid) {
        this.personid = personid;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public static class ResultBean {
        /**
         * curpage : 1
         * resultlist : [{"DESCRIPTION":"JM1门机整机防腐","ENTERBY":"SHIHUIZHEN","ENTERBYDESC":"施惠珍","RFQID":200,"RFQNUM":"1109","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"询价建立"},{"DESCRIPTION":"维修","ENTERBY":"WANGJIALING","ENTERBYDESC":"王佳祾","RFQID":195,"RFQNUM":"1104","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"关闭"},{"DESCRIPTION":"JM1门机整机防腐","ENTERBY":"SHIHUIZHEN","ENTERBYDESC":"施惠珍","RFQID":201,"RFQNUM":"1110","RFQTYPE":"","SITEID":"COSCOJZ","STATUS":"询价建立"}]
         * showcount : 10
         * totalpage : 1
         * totalresult : 3
         */

        private int curpage;
        private int showcount;
        private int totalpage;
        private int totalresult;
        private List<ResultlistBean> resultlist;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getShowcount() {
            return showcount;
        }

        public void setShowcount(int showcount) {
            this.showcount = showcount;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getTotalresult() {
            return totalresult;
        }

        public void setTotalresult(int totalresult) {
            this.totalresult = totalresult;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean {
            /**
             * DESCRIPTION : JM1门机整机防腐
             * ENTERBY : SHIHUIZHEN
             * ENTERBYDESC : 施惠珍
             * RFQID : 200
             * RFQNUM : 1109
             * RFQTYPE :
             * SITEID : COSCOJZ
             * STATUS : 询价建立
             */

            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERBYDESC;
            private int RFQID;
            private String RFQNUM;
            private String RFQTYPE;
            private String SITEID;
            private String STATUS;

            public String getUDIVNUM() {
                return UDIVNUM;
            }

            public void setUDIVNUM(String UDIVNUM) {
                this.UDIVNUM = UDIVNUM;
            }

            public String getUDWONUM() {
                return UDWONUM;
            }

            public void setUDWONUM(String UDWONUM) {
                this.UDWONUM = UDWONUM;
            }

            String UDIVNUM;

            public String getUDPONUM() {
                return UDPONUM;
            }

            public void setUDPONUM(String UDPONUM) {
                this.UDPONUM = UDPONUM;
            }

            String UDPONUM;
String UDWONUM;

            public String getCLOSEONDATE() {
                return CLOSEONDATE;
            }

            public void setCLOSEONDATE(String CLOSEONDATE) {
                this.CLOSEONDATE = CLOSEONDATE;
            }

            String CLOSEONDATE;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getENTERBY() {
                return ENTERBY;
            }

            public void setENTERBY(String ENTERBY) {
                this.ENTERBY = ENTERBY;
            }

            public String getENTERBYDESC() {
                return ENTERBYDESC;
            }

            public void setENTERBYDESC(String ENTERBYDESC) {
                this.ENTERBYDESC = ENTERBYDESC;
            }

            public int getRFQID() {
                return RFQID;
            }

            public void setRFQID(int RFQID) {
                this.RFQID = RFQID;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
            }

            public String getRFQTYPE() {
                return RFQTYPE;
            }

            public void setRFQTYPE(String RFQTYPE) {
                this.RFQTYPE = RFQTYPE;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }
        }
    }
}
