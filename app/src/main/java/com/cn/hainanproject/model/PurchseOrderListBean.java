package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/2/7
 */
public class PurchseOrderListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"4G无线终端相关配件采购0","ORDERDATE":"2021-01-15 17:11:11","POID":351,"PONUM":"100073","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"27,000.00","VENDOR":"GYS466","VENDORDESC":"GYS466"},{"DESCRIPTION":"工作需要","ORDERDATE":"2020-12-30 9:56:14","POID":323,"PONUM":"100063","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"300.00","VENDOR":"GYS001","VENDORDESC":"GYS001"},{"DESCRIPTION":"更换轴承","ORDERDATE":"2021-01-12 15:54:47","POID":350,"PONUM":"100072","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"9,600.00","VENDOR":"GYS001","VENDORDESC":"GYS001"},{"DESCRIPTION":"100支中性笔","ORDERDATE":"2020-12-30 15:50:3","POID":325,"PONUM":"100065","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"120.00","VENDOR":"GYS004","VENDORDESC":"GYS004"},{"DESCRIPTION":"空调1.5P询价","ORDERDATE":"2020-12-29 16:56:12","POID":321,"PONUM":"100061","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"10,560.00","VENDOR":"GYS010","VENDORDESC":"GYS010"},{"DESCRIPTION":"工作需要","ORDERDATE":"2021-01-08 9:22:19","POID":348,"PONUM":"100070","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"2,640.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"12","ORDERDATE":"2021-01-11 15:1:23","POID":349,"PONUM":"100071","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"225.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"抽纸","ORDERDATE":"2020-12-30 11:0:46","POID":324,"PONUM":"100064","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"39.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"维修","ORDERDATE":"2020-12-29 17:10:23","POID":322,"PONUM":"100062","RECEIPTS":"完成","REQUIREDDATE":"2020-12-30 16:57:57","SHIPTOATTN":"王佳祾","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"20,000.00","VENDOR":"GYS049","VENDORDESC":"GYS049"},{"DESCRIPTION":"对断路器采购","ORDERDATE":"2020-12-29 16:13:40","POID":320,"PONUM":"100060","RECEIPTS":"完成","REQUIREDDATE":"2021-01-07 0:0:0","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"75,211.00","VENDOR":"GYS219","VENDORDESC":"GYS219"}],"showcount":20,"totalpage":1,"totalresult":10}
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
         * resultlist : [{"DESCRIPTION":"4G无线终端相关配件采购0","ORDERDATE":"2021-01-15 17:11:11","POID":351,"PONUM":"100073","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"27,000.00","VENDOR":"GYS466","VENDORDESC":"GYS466"},{"DESCRIPTION":"工作需要","ORDERDATE":"2020-12-30 9:56:14","POID":323,"PONUM":"100063","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"300.00","VENDOR":"GYS001","VENDORDESC":"GYS001"},{"DESCRIPTION":"更换轴承","ORDERDATE":"2021-01-12 15:54:47","POID":350,"PONUM":"100072","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"9,600.00","VENDOR":"GYS001","VENDORDESC":"GYS001"},{"DESCRIPTION":"100支中性笔","ORDERDATE":"2020-12-30 15:50:3","POID":325,"PONUM":"100065","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"120.00","VENDOR":"GYS004","VENDORDESC":"GYS004"},{"DESCRIPTION":"空调1.5P询价","ORDERDATE":"2020-12-29 16:56:12","POID":321,"PONUM":"100061","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"10,560.00","VENDOR":"GYS010","VENDORDESC":"GYS010"},{"DESCRIPTION":"工作需要","ORDERDATE":"2021-01-08 9:22:19","POID":348,"PONUM":"100070","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"2,640.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"12","ORDERDATE":"2021-01-11 15:1:23","POID":349,"PONUM":"100071","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"225.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"抽纸","ORDERDATE":"2020-12-30 11:0:46","POID":324,"PONUM":"100064","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"尹刚","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"39.00","VENDOR":"GYS002","VENDORDESC":"GYS002"},{"DESCRIPTION":"维修","ORDERDATE":"2020-12-29 17:10:23","POID":322,"PONUM":"100062","RECEIPTS":"完成","REQUIREDDATE":"2020-12-30 16:57:57","SHIPTOATTN":"王佳祾","SITEID":"COSCOJZ","STATUS":"已核准","TOTALCOST":"20,000.00","VENDOR":"GYS049","VENDORDESC":"GYS049"},{"DESCRIPTION":"对断路器采购","ORDERDATE":"2020-12-29 16:13:40","POID":320,"PONUM":"100060","RECEIPTS":"完成","REQUIREDDATE":"2021-01-07 0:0:0","SHIPTOATTN":"施惠珍","SITEID":"COSCOJZ","STATUS":"已接收","TOTALCOST":"75,211.00","VENDOR":"GYS219","VENDORDESC":"GYS219"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 10
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

        public static class ResultlistBean implements Serializable {
            /**
             * DESCRIPTION : 4G无线终端相关配件采购0
             * ORDERDATE : 2021-01-15 17:11:11
             * POID : 351
             * PONUM : 100073
             * RECEIPTS : 无
             * REQUIREDDATE :
             * SHIPTOATTN : 施惠珍
             * SITEID : COSCOJZ
             * STATUS : 已核准
             * TOTALCOST : 27,000.00
             * VENDOR : GYS466
             * VENDORDESC : GYS466
             */

            private String DESCRIPTION;
            private String ORDERDATE;
            private int POID;
            private String PONUM;
            private String RECEIPTS;
            private String REQUIREDDATE;
            private String SHIPTOATTN;
            private String SITEID;
            private String STATUS;
            private String TOTALCOST;
            private String VENDOR;
            private String VENDORDESC;

            public void setPRICELEVEL(String PRICELEVEL) {
                this.PRICELEVEL = PRICELEVEL;
            }

            String PRICELEVEL;

            public String getUDCREATEDATE() {
                return UDCREATEDATE;
            }

            public void setUDCREATEDATE(String UDCREATEDATE) {
                this.UDCREATEDATE = UDCREATEDATE;
            }

            String UDCREATEDATE;

            public void setDISPLAYNAME(String DISPLAYNAME) {
                this.DISPLAYNAME = DISPLAYNAME;
            }

            String DISPLAYNAME;

            public String getUDPAYMENTTERMS() {
                return UDPAYMENTTERMS;
            }

            public void setUDPAYMENTTERMS(String UDPAYMENTTERMS) {
                this.UDPAYMENTTERMS = UDPAYMENTTERMS;
            }

            String UDPAYMENTTERMS;


            public String getTRANSPORT() {
                return TRANSPORT;
            }

            public void setTRANSPORT(String TRANSPORT) {
                this.TRANSPORT = TRANSPORT;
            }

            String TRANSPORT;

            public String getUDTAX() {
                return UDTAX;
            }

            public void setUDTAX(String UDTAX) {
                this.UDTAX = UDTAX;
            }

            String UDTAX;

            public String getTOTALTAX1() {
                return TOTALTAX1;
            }

            public void setTOTALTAX1(String TOTALTAX1) {
                this.TOTALTAX1 = TOTALTAX1;
            }

            String TOTALTAX1;

            public String getPRETAXTOTAL() {
                return PRETAXTOTAL;
            }

            public void setPRETAXTOTAL(String PRETAXTOTAL) {
                this.PRETAXTOTAL = PRETAXTOTAL;
            }

            String PRETAXTOTAL;

            public String getUDHSZJ() {
                return UDHSZJ;
            }

            public void setUDHSZJ(String UDHSZJ) {
                this.UDHSZJ = UDHSZJ;
            }

            String UDHSZJ;


            public String getUDJHRQ() {
                return UDJHRQ;
            }

            public void setUDJHRQ(String UDJHRQ) {
                this.UDJHRQ = UDJHRQ;
            }

            String UDJHRQ;

            public String getCURRENCYCODE() {
                return CURRENCYCODE;
            }

            public void setCURRENCYCODE(String CURRENCYCODE) {
                this.CURRENCYCODE = CURRENCYCODE;
            }

            String CURRENCYCODE;

            public String getSTATUSDATE() {
                return STATUSDATE;
            }

            public void setSTATUSDATE(String STATUSDATE) {
                this.STATUSDATE = STATUSDATE;
            }

            String STATUSDATE;

            public void setUDMS(String UDMS) {
                this.UDMS = UDMS;
            }

            public String getUDMS() {
                return UDMS;
            }

            String UDMS;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
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


            public String getDISPLAYNAME() {
                return DISPLAYNAME;
            }

            public String getPRICELEVEL() {
                return PRICELEVEL;
            }
        }
    }
}
