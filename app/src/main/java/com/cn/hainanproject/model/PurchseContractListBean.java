package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

public class PurchseContractListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CONTRACTID":142,"CONTRACTNUM":"1051","CREATEBY":"CHENXINPING","CREATEBYDESC":"陈心萍","CREATEDATE":"2020-12-31 10:38:38","DESCRIPTION":"船舶租赁合同","ENDDATE":"2021-12-31","HASINSURANCE":"N","ORGID":"COSCO","REVISIONNUM":"0","STARTDATE":"2020-12-31","STATUS":"已批准","TOTALBASECOST":"15,000,000.00","TOTALCOST":"15,000,000.00","VENDOR":"GYS273","VENDORDESC":"海南美成船务有限公司"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"CONTRACTID":142,"CONTRACTNUM":"1051","CREATEBY":"CHENXINPING","CREATEBYDESC":"陈心萍","CREATEDATE":"2020-12-31 10:38:38","DESCRIPTION":"船舶租赁合同","ENDDATE":"2021-12-31","HASINSURANCE":"N","ORGID":"COSCO","REVISIONNUM":"0","STARTDATE":"2020-12-31","STATUS":"已批准","TOTALBASECOST":"15,000,000.00","TOTALCOST":"15,000,000.00","VENDOR":"GYS273","VENDORDESC":"海南美成船务有限公司"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 1
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

        public static class ResultlistBean implements Serializable{
            /**
             * CONTRACTID : 142
             * CONTRACTNUM : 1051
             * CREATEBY : CHENXINPING
             * CREATEBYDESC : 陈心萍
             * CREATEDATE : 2020-12-31 10:38:38
             * DESCRIPTION : 船舶租赁合同
             * ENDDATE : 2021-12-31
             * HASINSURANCE : N
             * ORGID : COSCO
             * REVISIONNUM : 0
             * STARTDATE : 2020-12-31
             * STATUS : 已批准
             * TOTALBASECOST : 15,000,000.00
             * TOTALCOST : 15,000,000.00
             * VENDOR : GYS273
             * VENDORDESC : 海南美成船务有限公司
             */

            private int CONTRACTID;
            private String CONTRACTNUM;
            private String CREATEBY;
            private String CREATEBYDESC;
            private String CREATEDATE;
            private String DESCRIPTION;
            private String ENDDATE;
            private String HASINSURANCE;
            private String ORGID;
            private String REVISIONNUM;
            private String STARTDATE;
            private String STATUS;
            private String TOTALBASECOST;
            private String TOTALCOST;
            private String VENDOR;
            private String VENDORDESC;

            public String getPHONENUM() {
                return PHONENUM;
            }

            public void setPHONENUM(String PHONENUM) {
                this.PHONENUM = PHONENUM;
            }

            String PHONENUM;
            public String getCONTACT() {
                return CONTACT;
            }

            public void setCONTACT(String CONTACT) {
                this.CONTACT = CONTACT;
            }

            String CONTACT;

            public String getADDRESS1() {
                return ADDRESS1;
            }

            public void setADDRESS1(String ADDRESS1) {
                this.ADDRESS1 = ADDRESS1;
            }

            String ADDRESS1;

            public int getCONTRACTID() {
                return CONTRACTID;
            }

            public void setCONTRACTID(int CONTRACTID) {
                this.CONTRACTID = CONTRACTID;
            }

            public String getCONTRACTNUM() {
                return CONTRACTNUM;
            }

            public void setCONTRACTNUM(String CONTRACTNUM) {
                this.CONTRACTNUM = CONTRACTNUM;
            }

            public String getCREATEBY() {
                return CREATEBY;
            }

            public void setCREATEBY(String CREATEBY) {
                this.CREATEBY = CREATEBY;
            }

            public String getCREATEBYDESC() {
                return CREATEBYDESC;
            }

            public void setCREATEBYDESC(String CREATEBYDESC) {
                this.CREATEBYDESC = CREATEBYDESC;
            }

            public String getCREATEDATE() {
                return CREATEDATE;
            }

            public void setCREATEDATE(String CREATEDATE) {
                this.CREATEDATE = CREATEDATE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
            }

            public String getHASINSURANCE() {
                return HASINSURANCE;
            }

            public void setHASINSURANCE(String HASINSURANCE) {
                this.HASINSURANCE = HASINSURANCE;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public String getREVISIONNUM() {
                return REVISIONNUM;
            }

            public void setREVISIONNUM(String REVISIONNUM) {
                this.REVISIONNUM = REVISIONNUM;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTOTALBASECOST() {
                return TOTALBASECOST;
            }

            public void setTOTALBASECOST(String TOTALBASECOST) {
                this.TOTALBASECOST = TOTALBASECOST;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getVENDORDESC() {
                return VENDORDESC;
            }

            public void setVENDORDESC(String VENDORDESC) {
                this.VENDORDESC = VENDORDESC;
            }
        }
    }
}
