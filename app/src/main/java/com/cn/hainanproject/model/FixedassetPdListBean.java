package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/2/20
 */
public class FixedassetPdListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ENDDATE":"2021-01-31 9:38:53","FIXPDNUM":"1024","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"已批准","PDZTDATE":"2021-01-19 9:38:25","STARTDATE":"2021-01-22 9:38:53"},{"ENDDATE":"2021-01-22 16:19:17","FIXPDNUM":"1046","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"待部长审核","PDZTDATE":"2021-01-20 16:19:19","STARTDATE":"2021-01-20 16:19:55"},{"ENDDATE":"2021-01-28 10:33:6","FIXPDNUM":"1049","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"待分管领导审核","PDZTDATE":"2021-01-21 10:33:6","STARTDATE":"2021-01-21 10:33:17"}],"showcount":10,"totalpage":1,"totalresult":3}
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
         * resultlist : [{"ENDDATE":"2021-01-31 9:38:53","FIXPDNUM":"1024","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"已批准","PDZTDATE":"2021-01-19 9:38:25","STARTDATE":"2021-01-22 9:38:53"},{"ENDDATE":"2021-01-22 16:19:17","FIXPDNUM":"1046","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"待部长审核","PDZTDATE":"2021-01-20 16:19:19","STARTDATE":"2021-01-20 16:19:55"},{"ENDDATE":"2021-01-28 10:33:6","FIXPDNUM":"1049","MEMO":"","PDUSER":"LINLIN","PDUSERDESC":"林琳","PDZT":"待分管领导审核","PDZTDATE":"2021-01-21 10:33:6","STARTDATE":"2021-01-21 10:33:17"}]
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

        public static class ResultlistBean {
            /**
             * ENDDATE : 2021-01-31 9:38:53
             * FIXPDNUM : 1024
             * MEMO :
             * PDUSER : LINLIN
             * PDUSERDESC : 林琳
             * PDZT : 已批准
             * PDZTDATE : 2021-01-19 9:38:25
             * STARTDATE : 2021-01-22 9:38:53
             */

            private String ENDDATE;
            private String FIXPDNUM;
            private String MEMO;
            private String PDUSER;
            private String PDUSERDESC;
            private String PDZT;
            private String PDZTDATE;
            private String STARTDATE;

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
            }

            public String getFIXPDNUM() {
                return FIXPDNUM;
            }

            public void setFIXPDNUM(String FIXPDNUM) {
                this.FIXPDNUM = FIXPDNUM;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getPDUSER() {
                return PDUSER;
            }

            public void setPDUSER(String PDUSER) {
                this.PDUSER = PDUSER;
            }

            public String getPDUSERDESC() {
                return PDUSERDESC;
            }

            public void setPDUSERDESC(String PDUSERDESC) {
                this.PDUSERDESC = PDUSERDESC;
            }

            public String getPDZT() {
                return PDZT;
            }

            public void setPDZT(String PDZT) {
                this.PDZT = PDZT;
            }

            public String getPDZTDATE() {
                return PDZTDATE;
            }

            public void setPDZTDATE(String PDZTDATE) {
                this.PDZTDATE = PDZTDATE;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }
        }
    }
}
