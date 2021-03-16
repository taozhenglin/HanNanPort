package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/3/16
 */
public class WxServerPurChaseOrderListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CURRENCYCODE":"CNY","DESCRIPTION":"维修","DISPLAYNAME":"王佳祾","ORDERDATE":"2020-12-29 17:10:23","POID":322,"PONUM":"100062","PRETAXTOTAL":"17,699.12","PRICELEVEL":"","RECEIPTS":"完成","REQUIREDDATE":"2020-12-30 16:57:57","SHIPTOATTN":"王佳祾","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDATE":"2020-12-29 17:12:21","TOTALCOST":"20,000.00","TOTALTAX1":"2,300.88","TRANSPORT":"","UDCREATEBY":"WANGJIALING","UDCREATEDATE":"2020-12-29 17:10:23","UDHSZJ":"20,000.00","UDJHRQ":"2021-01-05","UDMS":"","UDPAYMENTTERMS":"","UDTAX":"","VENDOR":"GYS049","VENDORDESC":"广州近岸海洋规划研究院有限公司"}],"showcount":10,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"CURRENCYCODE":"CNY","DESCRIPTION":"维修","DISPLAYNAME":"王佳祾","ORDERDATE":"2020-12-29 17:10:23","POID":322,"PONUM":"100062","PRETAXTOTAL":"17,699.12","PRICELEVEL":"","RECEIPTS":"完成","REQUIREDDATE":"2020-12-30 16:57:57","SHIPTOATTN":"王佳祾","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDATE":"2020-12-29 17:12:21","TOTALCOST":"20,000.00","TOTALTAX1":"2,300.88","TRANSPORT":"","UDCREATEBY":"WANGJIALING","UDCREATEDATE":"2020-12-29 17:10:23","UDHSZJ":"20,000.00","UDJHRQ":"2021-01-05","UDMS":"","UDPAYMENTTERMS":"","UDTAX":"","VENDOR":"GYS049","VENDORDESC":"广州近岸海洋规划研究院有限公司"}]
         * showcount : 10
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

        public static class ResultlistBean {
            /**
             * CURRENCYCODE : CNY
             * DESCRIPTION : 维修
             * DISPLAYNAME : 王佳祾
             * ORDERDATE : 2020-12-29 17:10:23
             * POID : 322
             * PONUM : 100062
             * PRETAXTOTAL : 17,699.12
             * PRICELEVEL :
             * RECEIPTS : 完成
             * REQUIREDDATE : 2020-12-30 16:57:57
             * SHIPTOATTN : 王佳祾
             * SITEID : COSCOJZ
             * STATUS : 已核准
             * STATUSDATE : 2020-12-29 17:12:21
             * TOTALCOST : 20,000.00
             * TOTALTAX1 : 2,300.88
             * TRANSPORT :
             * UDCREATEBY : WANGJIALING
             * UDCREATEDATE : 2020-12-29 17:10:23
             * UDHSZJ : 20,000.00
             * UDJHRQ : 2021-01-05
             * UDMS :
             * UDPAYMENTTERMS :
             * UDTAX :
             * VENDOR : GYS049
             * VENDORDESC : 广州近岸海洋规划研究院有限公司
             */

            private String CURRENCYCODE;
            private String DESCRIPTION;
            private String DISPLAYNAME;
            private String ORDERDATE;
            private int POID;
            private String PONUM;
            private String PRETAXTOTAL;
            private String PRICELEVEL;
            private String RECEIPTS;
            private String REQUIREDDATE;
            private String SHIPTOATTN;
            private String SITEID;
            private String STATUS;
            private String STATUSDATE;
            private String TOTALCOST;
            private String TOTALTAX1;
            private String TRANSPORT;
            private String UDCREATEBY;
            private String UDCREATEDATE;
            private String UDHSZJ;
            private String UDJHRQ;
            private String UDMS;
            private String UDPAYMENTTERMS;
            private String UDTAX;
            private String VENDOR;
            private String VENDORDESC;

            public String getCURRENCYCODE() {
                return CURRENCYCODE;
            }

            public void setCURRENCYCODE(String CURRENCYCODE) {
                this.CURRENCYCODE = CURRENCYCODE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getDISPLAYNAME() {
                return DISPLAYNAME;
            }

            public void setDISPLAYNAME(String DISPLAYNAME) {
                this.DISPLAYNAME = DISPLAYNAME;
            }

            public String getORDERDATE() {
                return ORDERDATE;
            }

            public void setORDERDATE(String ORDERDATE) {
                this.ORDERDATE = ORDERDATE;
            }

            public int getPOID() {
                return POID;
            }

            public void setPOID(int POID) {
                this.POID = POID;
            }

            public String getPONUM() {
                return PONUM;
            }

            public void setPONUM(String PONUM) {
                this.PONUM = PONUM;
            }

            public String getPRETAXTOTAL() {
                return PRETAXTOTAL;
            }

            public void setPRETAXTOTAL(String PRETAXTOTAL) {
                this.PRETAXTOTAL = PRETAXTOTAL;
            }

            public String getPRICELEVEL() {
                return PRICELEVEL;
            }

            public void setPRICELEVEL(String PRICELEVEL) {
                this.PRICELEVEL = PRICELEVEL;
            }

            public String getRECEIPTS() {
                return RECEIPTS;
            }

            public void setRECEIPTS(String RECEIPTS) {
                this.RECEIPTS = RECEIPTS;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
            }

            public String getSHIPTOATTN() {
                return SHIPTOATTN;
            }

            public void setSHIPTOATTN(String SHIPTOATTN) {
                this.SHIPTOATTN = SHIPTOATTN;
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

            public String getSTATUSDATE() {
                return STATUSDATE;
            }

            public void setSTATUSDATE(String STATUSDATE) {
                this.STATUSDATE = STATUSDATE;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getTOTALTAX1() {
                return TOTALTAX1;
            }

            public void setTOTALTAX1(String TOTALTAX1) {
                this.TOTALTAX1 = TOTALTAX1;
            }

            public String getTRANSPORT() {
                return TRANSPORT;
            }

            public void setTRANSPORT(String TRANSPORT) {
                this.TRANSPORT = TRANSPORT;
            }

            public String getUDCREATEBY() {
                return UDCREATEBY;
            }

            public void setUDCREATEBY(String UDCREATEBY) {
                this.UDCREATEBY = UDCREATEBY;
            }

            public String getUDCREATEDATE() {
                return UDCREATEDATE;
            }

            public void setUDCREATEDATE(String UDCREATEDATE) {
                this.UDCREATEDATE = UDCREATEDATE;
            }

            public String getUDHSZJ() {
                return UDHSZJ;
            }

            public void setUDHSZJ(String UDHSZJ) {
                this.UDHSZJ = UDHSZJ;
            }

            public String getUDJHRQ() {
                return UDJHRQ;
            }

            public void setUDJHRQ(String UDJHRQ) {
                this.UDJHRQ = UDJHRQ;
            }

            public String getUDMS() {
                return UDMS;
            }

            public void setUDMS(String UDMS) {
                this.UDMS = UDMS;
            }

            public String getUDPAYMENTTERMS() {
                return UDPAYMENTTERMS;
            }

            public void setUDPAYMENTTERMS(String UDPAYMENTTERMS) {
                this.UDPAYMENTTERMS = UDPAYMENTTERMS;
            }

            public String getUDTAX() {
                return UDTAX;
            }

            public void setUDTAX(String UDTAX) {
                this.UDTAX = UDTAX;
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

