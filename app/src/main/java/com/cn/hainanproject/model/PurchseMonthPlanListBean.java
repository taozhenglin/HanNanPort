package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/2/20
 */
public class PurchseMonthPlanListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CHANGEDATE":"2021-01-15 15:26:15","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"螺丝","ISSUEDATE":"2021-01-06 10:15:6","ORGID":"COSCO","PRID":283,"PRNUM":"1205","REQUESTEDBY":"CHENLIANG","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待相关部门负责人审核","STATUSDESC":"待相关部门负责人审核","TOTALCOST":"20.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 11:0:46","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"办公用品采购","ISSUEDATE":"2020-12-30 10:51:0","ORGID":"COSCO","PRID":248,"PRNUM":"1171","REQUESTEDBY":"LIUYONGXIU","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"关闭","STATUSDESC":"已关闭","TOTALCOST":"100.00","VENDOR":""},{"CHANGEDATE":"2021-01-08 9:5:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"工作需要","ISSUEDATE":"2021-01-08 9:5:32","ORGID":"COSCO","PRID":293,"PRNUM":"1215","REQUESTEDBY":"CHENXINPING","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"等待核准","STATUSDESC":"等待核准","TOTALCOST":"0.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 11:39:43","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"损坏","ISSUEDATE":"2021-01-12 9:26:13","ORGID":"COSCO","PRID":330,"PRNUM":"1250","REQUESTEDBY":"WUDUOYING","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待采购室审核","STATUSDESC":"待采购室审核","TOTALCOST":"120.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 11:40:6","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"备库","ISSUEDATE":"2021-01-12 10:48:30","ORGID":"COSCO","PRID":333,"PRNUM":"1253","REQUESTEDBY":"LIBIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待采购室审核","STATUSDESC":"待采购室审核","TOTALCOST":"600.00","VENDOR":""},{"CHANGEDATE":"2021-01-20 10:59:51","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"购买消防器材","ISSUEDATE":"2021-01-20 10:57:6","ORGID":"COSCO","PRID":410,"PRNUM":"1315","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"驳回","STATUSDESC":"驳回","TOTALCOST":"40.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 9:11:10","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"备库","ISSUEDATE":"2021-01-21 9:10:28","ORGID":"COSCO","PRID":417,"PRNUM":"1322","REQUESTEDBY":"ZHOUXIAOBO","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"计划建立","STATUSDESC":"计划建立","TOTALCOST":"0.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 10:28:46","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"购置一台电脑","ISSUEDATE":"2021-01-21 10:24:52","ORGID":"COSCO","PRID":419,"PRNUM":"1324","REQUESTEDBY":"LINLIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDESC":"已核准","TOTALCOST":"2,000.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 15:50:3","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"办公室需要中性笔","ISSUEDATE":"2020-12-30 15:33:15","ORGID":"COSCO","PRID":249,"PRNUM":"1172","REQUESTEDBY":"FUCHUANLIANG","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"关闭","STATUSDESC":"已关闭","TOTALCOST":"10,000.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 14:35:12","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"配件损坏，需要更换","ISSUEDATE":"2020-12-30 10:38:5","ORGID":"COSCO","PRID":247,"PRNUM":"1170","REQUESTEDBY":"CAOZHENJIE","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDESC":"已核准","TOTALCOST":"263.00","VENDOR":""}],"showcount":10,"totalpage":7,"totalresult":64}
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
         * resultlist : [{"CHANGEDATE":"2021-01-15 15:26:15","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"螺丝","ISSUEDATE":"2021-01-06 10:15:6","ORGID":"COSCO","PRID":283,"PRNUM":"1205","REQUESTEDBY":"CHENLIANG","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待相关部门负责人审核","STATUSDESC":"待相关部门负责人审核","TOTALCOST":"20.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 11:0:46","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"办公用品采购","ISSUEDATE":"2020-12-30 10:51:0","ORGID":"COSCO","PRID":248,"PRNUM":"1171","REQUESTEDBY":"LIUYONGXIU","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"关闭","STATUSDESC":"已关闭","TOTALCOST":"100.00","VENDOR":""},{"CHANGEDATE":"2021-01-08 9:5:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"工作需要","ISSUEDATE":"2021-01-08 9:5:32","ORGID":"COSCO","PRID":293,"PRNUM":"1215","REQUESTEDBY":"CHENXINPING","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"等待核准","STATUSDESC":"等待核准","TOTALCOST":"0.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 11:39:43","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"损坏","ISSUEDATE":"2021-01-12 9:26:13","ORGID":"COSCO","PRID":330,"PRNUM":"1250","REQUESTEDBY":"WUDUOYING","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待采购室审核","STATUSDESC":"待采购室审核","TOTALCOST":"120.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 11:40:6","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"备库","ISSUEDATE":"2021-01-12 10:48:30","ORGID":"COSCO","PRID":333,"PRNUM":"1253","REQUESTEDBY":"LIBIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"待采购室审核","STATUSDESC":"待采购室审核","TOTALCOST":"600.00","VENDOR":""},{"CHANGEDATE":"2021-01-20 10:59:51","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"购买消防器材","ISSUEDATE":"2021-01-20 10:57:6","ORGID":"COSCO","PRID":410,"PRNUM":"1315","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"驳回","STATUSDESC":"驳回","TOTALCOST":"40.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 9:11:10","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"备库","ISSUEDATE":"2021-01-21 9:10:28","ORGID":"COSCO","PRID":417,"PRNUM":"1322","REQUESTEDBY":"ZHOUXIAOBO","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"计划建立","STATUSDESC":"计划建立","TOTALCOST":"0.00","VENDOR":""},{"CHANGEDATE":"2021-01-21 10:28:46","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"购置一台电脑","ISSUEDATE":"2021-01-21 10:24:52","ORGID":"COSCO","PRID":419,"PRNUM":"1324","REQUESTEDBY":"LINLIN","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDESC":"已核准","TOTALCOST":"2,000.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 15:50:3","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"办公室需要中性笔","ISSUEDATE":"2020-12-30 15:33:15","ORGID":"COSCO","PRID":249,"PRNUM":"1172","REQUESTEDBY":"FUCHUANLIANG","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"关闭","STATUSDESC":"已关闭","TOTALCOST":"10,000.00","VENDOR":""},{"CHANGEDATE":"2020-12-30 14:35:12","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"配件损坏，需要更换","ISSUEDATE":"2020-12-30 10:38:5","ORGID":"COSCO","PRID":247,"PRNUM":"1170","REQUESTEDBY":"CAOZHENJIE","REQUIREDDATE":"","SITEID":"COSCOJZ","STATUS":"已核准","STATUSDESC":"已核准","TOTALCOST":"263.00","VENDOR":""}]
         * showcount : 10
         * totalpage : 7
         * totalresult : 64
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
             * CHANGEDATE : 2021-01-15 15:26:15
             * CONTRACTREFNUM :
             * CONTRACTREFREV :
             * DESCRIPTION : 螺丝
             * ISSUEDATE : 2021-01-06 10:15:6
             * ORGID : COSCO
             * PRID : 283
             * PRNUM : 1205
             * REQUESTEDBY : CHENLIANG
             * REQUIREDDATE :
             * SITEID : COSCOJZ
             * STATUS : 待相关部门负责人审核
             * STATUSDESC : 待相关部门负责人审核
             * TOTALCOST : 20.00
             * VENDOR :
             */

            private String CHANGEDATE;
            private String CONTRACTREFNUM;
            private String CONTRACTREFREV;
            private String DESCRIPTION;
            private String ISSUEDATE;
            private String ORGID;
            private int PRID;
            private String PRNUM;
            private String REQUESTEDBY;
            private String REQUIREDDATE;
            private String SITEID;
            private String STATUS;
            private String STATUSDESC;
            private String TOTALCOST;
            private String VENDOR;

            public String getCHANGEDATE() {
                return CHANGEDATE;
            }

            public void setCHANGEDATE(String CHANGEDATE) {
                this.CHANGEDATE = CHANGEDATE;
            }

            public String getCONTRACTREFNUM() {
                return CONTRACTREFNUM;
            }

            public void setCONTRACTREFNUM(String CONTRACTREFNUM) {
                this.CONTRACTREFNUM = CONTRACTREFNUM;
            }

            public String getCONTRACTREFREV() {
                return CONTRACTREFREV;
            }

            public void setCONTRACTREFREV(String CONTRACTREFREV) {
                this.CONTRACTREFREV = CONTRACTREFREV;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getISSUEDATE() {
                return ISSUEDATE;
            }

            public void setISSUEDATE(String ISSUEDATE) {
                this.ISSUEDATE = ISSUEDATE;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public int getPRID() {
                return PRID;
            }

            public void setPRID(int PRID) {
                this.PRID = PRID;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getREQUESTEDBY() {
                return REQUESTEDBY;
            }

            public void setREQUESTEDBY(String REQUESTEDBY) {
                this.REQUESTEDBY = REQUESTEDBY;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
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

            public String getSTATUSDESC() {
                return STATUSDESC;
            }

            public void setSTATUSDESC(String STATUSDESC) {
                this.STATUSDESC = STATUSDESC;
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
        }
    }
}
