package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/3/17
 */
public class EqmManageListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETID":"66","ASSETNUM":"1070210018-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"67","ASSETNUM":"1070210019-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"68","ASSETNUM":"1070210020-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"69","ASSETNUM":"1070210021-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"70","ASSETNUM":"1070210022-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"71","ASSETNUM":"1070210023-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"72","ASSETNUM":"1070210024-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"73","ASSETNUM":"1070210025-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"74","ASSETNUM":"1070210026-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"75","ASSETNUM":"1070210027-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"}],"showcount":10,"totalpage":50,"totalresult":491}
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
         * resultlist : [{"ASSETID":"66","ASSETNUM":"1070210018-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"67","ASSETNUM":"1070210019-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"68","ASSETNUM":"1070210020-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"69","ASSETNUM":"1070210021-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"70","ASSETNUM":"1070210022-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"71","ASSETNUM":"1070210023-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"72","ASSETNUM":"1070210024-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"73","ASSETNUM":"1070210025-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"74","ASSETNUM":"1070210026-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"},{"ASSETID":"75","ASSETNUM":"1070210027-1","DESCRIPTION":"流动机械-牵引车","STATUS":"正常使用","UDASSETTYPE":"港内拖车","UDSPECIAL":"Y"}]
         * showcount : 10
         * totalpage : 50
         * totalresult : 491
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
             * ASSETID : 66
             * ASSETNUM : 1070210018-1
             * DESCRIPTION : 流动机械-牵引车
             * STATUS : 正常使用
             * UDASSETTYPE : 港内拖车
             * UDSPECIAL : Y
             */

            private String ASSETID;
            private String ASSETNUM;
            private String DESCRIPTION;
            private String STATUS;
            private String UDASSETTYPE;
            private String UDSPECIAL;

            public String getASSETID() {
                return ASSETID;
            }

            public void setASSETID(String ASSETID) {
                this.ASSETID = ASSETID;
            }

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getUDASSETTYPE() {
                return UDASSETTYPE;
            }

            public void setUDASSETTYPE(String UDASSETTYPE) {
                this.UDASSETTYPE = UDASSETTYPE;
            }

            public String getUDSPECIAL() {
                return UDSPECIAL;
            }

            public void setUDSPECIAL(String UDSPECIAL) {
                this.UDSPECIAL = UDSPECIAL;
            }
        }
    }
}
