package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

public class StockMoveListBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CREATEBY":"MAXADMIN","CREATEDATE":"2021-02-20 15:40:37","DESCRIPTION":"1","FROMSTORELOC":"A08","INVUSEID":487,"INVUSENUM":"100236","SITEID":"COSCOJZ","STATUS":"申请建立"},{"CREATEBY":"LIPINGLONG","CREATEDATE":"2021-01-20 16:28:42","DESCRIPTION":"更换需要","FROMSTORELOC":"A11","INVUSEID":462,"INVUSENUM":"100232","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUXIAOBO","CREATEDATE":"2021-01-20 15:8:38","DESCRIPTION":"生产需要","FROMSTORELOC":"A08","INVUSEID":460,"INVUSENUM":"100230","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"LIBIN","CREATEDATE":"2021-01-19 10:19:17","DESCRIPTION":"海口技术部 普通 李斌 107067 1070211034-1 107067","FROMSTORELOC":"A03","INVUSEID":451,"INVUSENUM":"100221","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-18 11:53:45","DESCRIPTION":"海口技术部 普通 周昭家 106841 1070210060-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":447,"INVUSENUM":"100217","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 17:18:2","DESCRIPTION":"海口技术部 普通 吴多颖 106170 1070201011-1 电线断","FROMSTORELOC":"A03","INVUSEID":439,"INVUSENUM":"100216","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 17:6:2","DESCRIPTION":"海口技术部 普通 吴多颖 106169 1070212005-1 变速箱故障","FROMSTORELOC":"A03","INVUSEID":438,"INVUSENUM":"100215","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 15:55:5","DESCRIPTION":"海口技术部 普通 吴多颖 106163 1070212006-1 发动机SPN报警，代码158，电池电位低","FROMSTORELOC":"A03","INVUSEID":437,"INVUSENUM":"100214","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-15 10:3:43","DESCRIPTION":"海口技术部 普通 周昭家 106168 1070210042-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":435,"INVUSENUM":"100212","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-15 9:58:55","DESCRIPTION":"海口技术部 普通 周昭家 106168 1070210042-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":434,"INVUSENUM":"100211","SITEID":"COSCOJZ","STATUS":"完成"}],"showcount":10,"totalpage":6,"totalresult":59}
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
         * resultlist : [{"CREATEBY":"MAXADMIN","CREATEDATE":"2021-02-20 15:40:37","DESCRIPTION":"1","FROMSTORELOC":"A08","INVUSEID":487,"INVUSENUM":"100236","SITEID":"COSCOJZ","STATUS":"申请建立"},{"CREATEBY":"LIPINGLONG","CREATEDATE":"2021-01-20 16:28:42","DESCRIPTION":"更换需要","FROMSTORELOC":"A11","INVUSEID":462,"INVUSENUM":"100232","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUXIAOBO","CREATEDATE":"2021-01-20 15:8:38","DESCRIPTION":"生产需要","FROMSTORELOC":"A08","INVUSEID":460,"INVUSENUM":"100230","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"LIBIN","CREATEDATE":"2021-01-19 10:19:17","DESCRIPTION":"海口技术部 普通 李斌 107067 1070211034-1 107067","FROMSTORELOC":"A03","INVUSEID":451,"INVUSENUM":"100221","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-18 11:53:45","DESCRIPTION":"海口技术部 普通 周昭家 106841 1070210060-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":447,"INVUSENUM":"100217","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 17:18:2","DESCRIPTION":"海口技术部 普通 吴多颖 106170 1070201011-1 电线断","FROMSTORELOC":"A03","INVUSEID":439,"INVUSENUM":"100216","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 17:6:2","DESCRIPTION":"海口技术部 普通 吴多颖 106169 1070212005-1 变速箱故障","FROMSTORELOC":"A03","INVUSEID":438,"INVUSENUM":"100215","SITEID":"COSCOJZ","STATUS":"待仓库管理员审核"},{"CREATEBY":"WUDUOYING","CREATEDATE":"2021-01-15 15:55:5","DESCRIPTION":"海口技术部 普通 吴多颖 106163 1070212006-1 发动机SPN报警，代码158，电池电位低","FROMSTORELOC":"A03","INVUSEID":437,"INVUSENUM":"100214","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-15 10:3:43","DESCRIPTION":"海口技术部 普通 周昭家 106168 1070210042-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":435,"INVUSENUM":"100212","SITEID":"COSCOJZ","STATUS":"完成"},{"CREATEBY":"ZHOUZHAOJIA","CREATEDATE":"2021-01-15 9:58:55","DESCRIPTION":"海口技术部 普通 周昭家 106168 1070210042-1 换轮胎","FROMSTORELOC":"A02","INVUSEID":434,"INVUSENUM":"100211","SITEID":"COSCOJZ","STATUS":"完成"}]
         * showcount : 10
         * totalpage : 6
         * totalresult : 59
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
             * CREATEBY : MAXADMIN
             * CREATEDATE : 2021-02-20 15:40:37
             * DESCRIPTION : 1
             * FROMSTORELOC : A08
             * INVUSEID : 487
             * INVUSENUM : 100236
             * SITEID : COSCOJZ
             * STATUS : 申请建立
             */

            private String CREATEBY;
            private String CREATEDATE;
            private String DESCRIPTION;
            private String FROMSTORELOC;
            private int INVUSEID;
            private String INVUSENUM;
            private String SITEID;
            private String STATUS;

            public String getCREATEBY() {
                return CREATEBY;
            }

            public void setCREATEBY(String CREATEBY) {
                this.CREATEBY = CREATEBY;
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
