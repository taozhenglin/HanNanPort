package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/2/19
 */
public class StockCheckListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CREATEBY":"SUWENHUAN","CREATEDATE":"2021-01-05 10:34:7","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1333"},{"CREATEBY":"SUWENHUAN","CREATEDATE":"2021-01-05 9:50:57","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1330"},{"CREATEBY":"MAXADMIN","CREATEDATE":"2021-01-05 10:6:45","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1332"}],"showcount":10,"totalpage":1,"totalresult":3}
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
         * resultlist : [{"CREATEBY":"SUWENHUAN","CREATEDATE":"2021-01-05 10:34:7","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1333"},{"CREATEBY":"SUWENHUAN","CREATEDATE":"2021-01-05 9:50:57","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1330"},{"CREATEBY":"MAXADMIN","CREATEDATE":"2021-01-05 10:6:45","DESCRIPTION":"","LOCATION":"A03","STOCKNUM":"1332"}]
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

        public static class ResultlistBean implements Serializable {
            /**
             * CREATEBY : SUWENHUAN
             * CREATEDATE : 2021-01-05 10:34:7
             * DESCRIPTION :
             * LOCATION : A03
             * STOCKNUM : 1333
             */

            private String CREATEBY;
            private String CREATEDATE;
            private String DESCRIPTION;
            private String LOCATION;
            private String STOCKNUM;

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

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }

            public String getSTOCKNUM() {
                return STOCKNUM;
            }

            public void setSTOCKNUM(String STOCKNUM) {
                this.STOCKNUM = STOCKNUM;
            }
        }
    }
}
