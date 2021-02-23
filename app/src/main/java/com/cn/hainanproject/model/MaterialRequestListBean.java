package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/2/19
 */
public class MaterialRequestListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"残油是否出现发白变质现象","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116042","WORKORDERID":16823},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"残留旧油是否可见金属光泽粉末","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116041","WORKORDERID":16822},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"润滑点可见新润滑脂溢出，溢出旧油清理干净","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116040","WORKORDERID":16821},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大车-平衡梁各铰点(以起升机构为准）","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116039","WORKORDERID":16820},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-沿线各托辊","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116038","WORKORDERID":16819},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-其它运动附件(以起升机构为准）","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116037","WORKORDERID":16818},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-大梁斜拉杆各铰点","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116036","WORKORDERID":16817},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-大梁铰点","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116035","WORKORDERID":16816},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-前后拖架车轮，导向轮，防跳轮","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116034","WORKORDERID":16815},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-挂仓保护装置","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116033","WORKORDERID":16814}],"showcount":10,"totalpage":1555,"totalresult":15547}
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
         * resultlist : [{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"残油是否出现发白变质现象","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116042","WORKORDERID":16823},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"残留旧油是否可见金属光泽粉末","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116041","WORKORDERID":16822},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"润滑点可见新润滑脂溢出，溢出旧油清理干净","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116040","WORKORDERID":16821},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大车-平衡梁各铰点(以起升机构为准）","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116039","WORKORDERID":16820},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-沿线各托辊","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116038","WORKORDERID":16819},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-其它运动附件(以起升机构为准）","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116037","WORKORDERID":16818},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-大梁斜拉杆各铰点","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116036","WORKORDERID":16817},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-大梁铰点","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116035","WORKORDERID":16816},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-前后拖架车轮，导向轮，防跳轮","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116034","WORKORDERID":16815},{"BZ":"管理员","CREWID":"","DEPARTMENT":"JS06","DESCRIPTION":"大梁-挂仓保护装置","ESTMATCOST":"0.00","PRIMARYPHONE":"","REPORTDATE":"2021-02-19 8:0:27","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"超级管理员","SITEID":"COSCOJZ","STATUS":"待维修室经理审核","WONUM":"116033","WORKORDERID":16814}]
         * showcount : 10
         * totalpage : 1555
         * totalresult : 15547
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
             * BZ : 管理员
             * CREWID :
             * DEPARTMENT : JS06
             * DESCRIPTION : 残油是否出现发白变质现象
             * ESTMATCOST : 0.00
             * PRIMARYPHONE :
             * REPORTDATE : 2021-02-19 8:0:27
             * REPORTEDBY : MAXADMIN
             * REPORTEDBYDESC : 超级管理员
             * SITEID : COSCOJZ
             * STATUS : 待维修室经理审核
             * WONUM : 116042
             * WORKORDERID : 16823
             */

            private String BZ;
            private String CREWID;
            private String DEPARTMENT;
            private String DESCRIPTION;
            private String ESTMATCOST;
            private String PRIMARYPHONE;
            private String REPORTDATE;
            private String REPORTEDBY;
            private String REPORTEDBYDESC;
            private String SITEID;
            private String STATUS;
            private String WONUM;
            private int WORKORDERID;

            public String getBZ() {
                return BZ;
            }

            public void setBZ(String BZ) {
                this.BZ = BZ;
            }

            public String getCREWID() {
                return CREWID;
            }

            public void setCREWID(String CREWID) {
                this.CREWID = CREWID;
            }

            public String getDEPARTMENT() {
                return DEPARTMENT;
            }

            public void setDEPARTMENT(String DEPARTMENT) {
                this.DEPARTMENT = DEPARTMENT;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getESTMATCOST() {
                return ESTMATCOST;
            }

            public void setESTMATCOST(String ESTMATCOST) {
                this.ESTMATCOST = ESTMATCOST;
            }

            public String getPRIMARYPHONE() {
                return PRIMARYPHONE;
            }

            public void setPRIMARYPHONE(String PRIMARYPHONE) {
                this.PRIMARYPHONE = PRIMARYPHONE;
            }

            public String getREPORTDATE() {
                return REPORTDATE;
            }

            public void setREPORTDATE(String REPORTDATE) {
                this.REPORTDATE = REPORTDATE;
            }

            public String getREPORTEDBY() {
                return REPORTEDBY;
            }

            public void setREPORTEDBY(String REPORTEDBY) {
                this.REPORTEDBY = REPORTEDBY;
            }

            public String getREPORTEDBYDESC() {
                return REPORTEDBYDESC;
            }

            public void setREPORTEDBYDESC(String REPORTEDBYDESC) {
                this.REPORTEDBYDESC = REPORTEDBYDESC;
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

            public String getWONUM() {
                return WONUM;
            }

            public void setWONUM(String WONUM) {
                this.WONUM = WONUM;
            }

            public int getWORKORDERID() {
                return WORKORDERID;
            }

            public void setWORKORDERID(int WORKORDERID) {
                this.WORKORDERID = WORKORDERID;
            }
        }
    }
}
