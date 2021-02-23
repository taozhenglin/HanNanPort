package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

public class StockMoveListBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"IT材料","CREWID":"","DISPLAYNAME":"系统管理员","FROMSTORELOC":"YD","INVUSEID":421,"INVUSENUM":"1030","REPORTDATE":"2020-08-31 17:55:33","REPORTEDBY":"MAXADMIN","STATUS":"已输入"},{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"车辆用","CREWID":"","DISPLAYNAME":"冯洲豪","FROMSTORELOC":"GJ","INVUSEID":386,"INVUSENUM":"1028","REPORTDATE":"2020-08-29 14:40:36","REPORTEDBY":"FENGZHH","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"叉车","CREWID":"物资","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"GJ","INVUSEID":385,"INVUSENUM":"1027","REPORTDATE":"2020-08-29 14:01:23","REPORTEDBY":"JIAWF","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"车辆用","CREWID":"物资","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"BSJS","INVUSEID":384,"INVUSENUM":"1026","REPORTDATE":"2020-08-29 13:52:12","REPORTEDBY":"JIAWF","STATUS":"完成"},{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"堆高机（柴油）","CREWID":"","DISPLAYNAME":"系统管理员","FROMSTORELOC":"GJ","INVUSEID":382,"INVUSENUM":"1024","REPORTDATE":"2020-08-29 13:36:36","REPORTEDBY":"MAXADMIN","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"信息中心","A_USEFOR":"叉车","CREWID":"工程部经理室","DISPLAYNAME":"沈建强","FROMSTORELOC":"YN","INVUSEID":343,"INVUSENUM":"1021","REPORTDATE":"2020-08-28 14:05:43","REPORTEDBY":"SHENJQ","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"信息中心","A_USEFOR":"IT办公耗材","CREWID":"物资","DISPLAYNAME":"苏虹","FROMSTORELOC":"YD","INVUSEID":322,"INVUSENUM":"1020","REPORTDATE":"","REPORTEDBY":"SUHONG","STATUS":"完成"}],"showcount":20,"totalpage":1,"totalresult":7}
     */

    private String errcode;
    private String errmsg;
    private Object personid;
    private ResultBean result;

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

    public static class ResultBean {
        /**
         * curpage : 1
         * resultlist : [{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"IT材料","CREWID":"","DISPLAYNAME":"系统管理员","FROMSTORELOC":"YD","INVUSEID":421,"INVUSENUM":"1030","REPORTDATE":"2020-08-31 17:55:33","REPORTEDBY":"MAXADMIN","STATUS":"已输入"},{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"车辆用","CREWID":"","DISPLAYNAME":"冯洲豪","FROMSTORELOC":"GJ","INVUSEID":386,"INVUSENUM":"1028","REPORTDATE":"2020-08-29 14:40:36","REPORTEDBY":"FENGZHH","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"叉车","CREWID":"物资","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"GJ","INVUSEID":385,"INVUSENUM":"1027","REPORTDATE":"2020-08-29 14:01:23","REPORTEDBY":"JIAWF","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"车辆用","CREWID":"物资","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"BSJS","INVUSEID":384,"INVUSENUM":"1026","REPORTDATE":"2020-08-29 13:52:12","REPORTEDBY":"JIAWF","STATUS":"完成"},{"A_DEPT":"信息中心","A_TODEPT":"工程技术部","A_USEFOR":"堆高机（柴油）","CREWID":"","DISPLAYNAME":"系统管理员","FROMSTORELOC":"GJ","INVUSEID":382,"INVUSENUM":"1024","REPORTDATE":"2020-08-29 13:36:36","REPORTEDBY":"MAXADMIN","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"信息中心","A_USEFOR":"叉车","CREWID":"工程部经理室","DISPLAYNAME":"沈建强","FROMSTORELOC":"YN","INVUSEID":343,"INVUSENUM":"1021","REPORTDATE":"2020-08-28 14:05:43","REPORTEDBY":"SHENJQ","STATUS":"完成"},{"A_DEPT":"工程技术部","A_TODEPT":"信息中心","A_USEFOR":"IT办公耗材","CREWID":"物资","DISPLAYNAME":"苏虹","FROMSTORELOC":"YD","INVUSEID":322,"INVUSENUM":"1020","REPORTDATE":"","REPORTEDBY":"SUHONG","STATUS":"完成"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 7
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
             * A_DEPT : 信息中心
             * A_TODEPT : 工程技术部
             * A_USEFOR : IT材料
             * CREWID :
             * DISPLAYNAME : 系统管理员
             * FROMSTORELOC : YD
             * INVUSEID : 421
             * INVUSENUM : 1030
             * REPORTDATE : 2020-08-31 17:55:33
             * REPORTEDBY : MAXADMIN
             * STATUS : 已输入
             */

            private String A_DEPT;
            private String A_TODEPT;
            private String A_USEFOR;
            private String CREWID;
            private String DISPLAYNAME;
            private String FROMSTORELOC;
            private int INVUSEID;
            private String INVUSENUM;
            private String CREATEDATE;
            private String CREATEBY;
            private String STATUS;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            String DESCRIPTION;

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            String SITEID;

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_TODEPT() {
                return A_TODEPT;
            }

            public void setA_TODEPT(String A_TODEPT) {
                this.A_TODEPT = A_TODEPT;
            }

            public String getA_USEFOR() {
                return A_USEFOR;
            }

            public void setA_USEFOR(String A_USEFOR) {
                this.A_USEFOR = A_USEFOR;
            }

            public String getCREWID() {
                return CREWID;
            }

            public void setCREWID(String CREWID) {
                this.CREWID = CREWID;
            }

            public String getDISPLAYNAME() {
                return DISPLAYNAME;
            }

            public void setDISPLAYNAME(String DISPLAYNAME) {
                this.DISPLAYNAME = DISPLAYNAME;
            }

            public String getFROMSTORELOC() {
                return FROMSTORELOC;
            }

            public void setFROMSTORELOC(String FROMSTORELOC) {
                this.FROMSTORELOC = FROMSTORELOC;
            }

            public int getINVUSEID() {
                return INVUSEID;
            }

            public void setINVUSEID(int INVUSEID) {
                this.INVUSEID = INVUSEID;
            }

            public String getINVUSENUM() {
                return INVUSENUM;
            }

            public void setINVUSENUM(String INVUSENUM) {
                this.INVUSENUM = INVUSENUM;
            }

            public String getCREATEDATE() {
                return CREATEDATE;
            }

            public void setCREATEDATE(String CREATEDATE) {
                this.CREATEDATE = CREATEDATE;
            }

            public String getCREATEBY() {
                return CREATEBY;
            }

            public void setCREATEBY(String CREATEBY) {
                this.CREATEBY = CREATEBY;
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
