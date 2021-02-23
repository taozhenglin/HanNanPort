package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/2/8
 */
public class FixedassetYsListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"。。。","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1032","STATUS":"待管理部门部门长审核","STATUSDATE":"2021-01-19 10:44:36","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"验收一台缓冲器","FIXEDASSETRQNUM":"1320","FIXEDASSETYSNUM":"1036","STATUS":"已验收","STATUSDATE":"2021-01-20 16:24:35","YSDESCRIPTION":"购置一台缓冲器"},{"DESCRIPTION":"验收一台吊具","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1031","STATUS":"已验收","STATUSDATE":"2021-01-19 10:43:58","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"多功能吊具验收","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1033","STATUS":"已验收","STATUSDATE":"2021-01-19 16:59:36","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"验收电脑","FIXEDASSETRQNUM":"1324","FIXEDASSETYSNUM":"1039","STATUS":"待验收小组审核","STATUSDATE":"2021-01-21 10:28:56","YSDESCRIPTION":"购置一台电脑"}],"showcount":10,"totalpage":1,"totalresult":5}
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
         * resultlist : [{"DESCRIPTION":"。。。","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1032","STATUS":"待管理部门部门长审核","STATUSDATE":"2021-01-19 10:44:36","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"验收一台缓冲器","FIXEDASSETRQNUM":"1320","FIXEDASSETYSNUM":"1036","STATUS":"已验收","STATUSDATE":"2021-01-20 16:24:35","YSDESCRIPTION":"购置一台缓冲器"},{"DESCRIPTION":"验收一台吊具","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1031","STATUS":"已验收","STATUSDATE":"2021-01-19 10:43:58","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"多功能吊具验收","FIXEDASSETRQNUM":"1297","FIXEDASSETYSNUM":"1033","STATUS":"已验收","STATUSDATE":"2021-01-19 16:59:36","YSDESCRIPTION":"购置一台多功能吊具"},{"DESCRIPTION":"验收电脑","FIXEDASSETRQNUM":"1324","FIXEDASSETYSNUM":"1039","STATUS":"待验收小组审核","STATUSDATE":"2021-01-21 10:28:56","YSDESCRIPTION":"购置一台电脑"}]
         * showcount : 10
         * totalpage : 1
         * totalresult : 5
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
             * DESCRIPTION : 。。。
             * FIXEDASSETRQNUM : 1297
             * FIXEDASSETYSNUM : 1032
             * STATUS : 待管理部门部门长审核
             * STATUSDATE : 2021-01-19 10:44:36
             * YSDESCRIPTION : 购置一台多功能吊具
             */

            private String DESCRIPTION;
            private String FIXEDASSETRQNUM;
            private String FIXEDASSETYSNUM;
            private String STATUS;
            private String STATUSDATE;
            private String YSDESCRIPTION;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getFIXEDASSETRQNUM() {
                return FIXEDASSETRQNUM;
            }

            public void setFIXEDASSETRQNUM(String FIXEDASSETRQNUM) {
                this.FIXEDASSETRQNUM = FIXEDASSETRQNUM;
            }

            public String getFIXEDASSETYSNUM() {
                return FIXEDASSETYSNUM;
            }

            public void setFIXEDASSETYSNUM(String FIXEDASSETYSNUM) {
                this.FIXEDASSETYSNUM = FIXEDASSETYSNUM;
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

            public String getYSDESCRIPTION() {
                return YSDESCRIPTION;
            }

            public void setYSDESCRIPTION(String YSDESCRIPTION) {
                this.YSDESCRIPTION = YSDESCRIPTION;
            }
        }
    }
}
