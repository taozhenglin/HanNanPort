package com.cn.hainanproject.model;

import java.util.List;

/**
 * Created by tzl
 * on 2021/6/24
 */
public class AssertCheckDetail {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"11-00100702A01","DESCRIPTION":"装卸机械设备-岸桥","ORGID":"COSCO","SITEID":"COSCOJZ","UDASSETTYPE":"岸桥","UDLEVEL":"固机设备","UDOLDASSETNUM":"JA01"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ASSETNUM":"11-00100702A01","DESCRIPTION":"装卸机械设备-岸桥","ORGID":"COSCO","SITEID":"COSCOJZ","UDASSETTYPE":"岸桥","UDLEVEL":"固机设备","UDOLDASSETNUM":"JA01"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 1
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
             * DESCRIPTION : 装卸机械设备-岸桥
             * ORGID : COSCO
             * SITEID : COSCOJZ
             * UDASSETTYPE : 岸桥
             * UDLEVEL : 固机设备
             * UDOLDASSETNUM : JA01
             */

            private String ASSETNUM;
            private String DESCRIPTION;
            private String ORGID;
            private String SITEID;
            private String UDASSETTYPE;
            private String UDLEVEL;
            private String UDOLDASSETNUM;

            public String getUDWD() {
                return UDWD;
            }

            public void setUDWD(String UDWD) {
                this.UDWD = UDWD;
            }

            public String getUDJD() {
                return UDJD;
            }

            public void setUDJD(String UDJD) {
                this.UDJD = UDJD;
            }

            String UDWD;
            String UDJD;

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

            public String getUDASSETTYPE() {
                return UDASSETTYPE;
            }

            public void setUDASSETTYPE(String UDASSETTYPE) {
                this.UDASSETTYPE = UDASSETTYPE;
            }

            public String getUDLEVEL() {
                return UDLEVEL;
            }

            public void setUDLEVEL(String UDLEVEL) {
                this.UDLEVEL = UDLEVEL;
            }

            public String getUDOLDASSETNUM() {
                return UDOLDASSETNUM;
            }

            public void setUDOLDASSETNUM(String UDOLDASSETNUM) {
                this.UDOLDASSETNUM = UDOLDASSETNUM;
            }
        }
    }
}
