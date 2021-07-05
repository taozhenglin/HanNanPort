package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/6/25
 */
public class AssertCheckLine {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":1,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":2,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":4,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":3,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"}],"showcount":10,"totalpage":1,"totalresult":4}
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
         * resultlist : [{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":1,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":2,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":4,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"},{"ASSETNUM":"11-00100702A01","BW":"A","LINENUM":3,"OLDASSETDES":"JA01","OLDASSETNUM":"JA01","ORGID":"COSCO","SITEID":"COSCOJZ"}]
         * showcount : 10
         * totalpage : 1
         * totalresult : 4
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
             * ASSETNUM : 11-00100702A01
             * BW : A
             * LINENUM : 1
             * OLDASSETDES : JA01
             * OLDASSETNUM : JA01
             * ORGID : COSCO
             * SITEID : COSCOJZ
             */

            private String ASSETNUM;
            private String BW;
            private int LINENUM;
            private String OLDASSETDES;
            private String OLDASSETNUM;
            private String ORGID;
            private String SITEID;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            String DESCRIPTION;

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getBW() {
                return BW;
            }

            public void setBW(String BW) {
                this.BW = BW;
            }

            public int getLINENUM() {
                return LINENUM;
            }

            public void setLINENUM(int LINENUM) {
                this.LINENUM = LINENUM;
            }

            public String getOLDASSETDES() {
                return OLDASSETDES;
            }

            public void setOLDASSETDES(String OLDASSETDES) {
                this.OLDASSETDES = OLDASSETDES;
            }

            public String getOLDASSETNUM() {
                return OLDASSETNUM;
            }

            public void setOLDASSETNUM(String OLDASSETNUM) {
                this.OLDASSETNUM = OLDASSETNUM;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }
        }
    }
}
