package com.cn.hainanproject.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/3/15
 */
public class FixedassetTzListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * loginid : null
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"影像设备","CFDD":"","COST":"99,931.47","CWBM":"F0113001845","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"海关监控区（集装箱）视音频监修复工程","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,599","FIXEDASSETCARDNUM":"1041","FIXENDDATE":"","MANAGEMENT":"","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"10,282.30","CWBM":"F0107021846","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（CBHU3079490）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,600","FIXEDASSETCARDNUM":"1042","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"20GP","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,698.73","CWBM":"F0107021901","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（CRJU1246278）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,601","FIXEDASSETCARDNUM":"1043","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,536.92","CWBM":"F0107021925","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（GESU6840733）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,602","FIXEDASSETCARDNUM":"1044","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,536.92","CWBM":"F0107021926","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（GESU6840950）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,603","FIXEDASSETCARDNUM":"1045","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""}],"showcount":5,"totalpage":219,"totalresult":1095}
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
         * resultlist : [{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"影像设备","CFDD":"","COST":"99,931.47","CWBM":"F0113001845","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"海关监控区（集装箱）视音频监修复工程","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,599","FIXEDASSETCARDNUM":"1041","FIXENDDATE":"","MANAGEMENT":"","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"10,282.30","CWBM":"F0107021846","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（CBHU3079490）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,600","FIXEDASSETCARDNUM":"1042","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"20GP","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,698.73","CWBM":"F0107021901","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（CRJU1246278）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,601","FIXEDASSETCARDNUM":"1043","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,536.92","CWBM":"F0107021925","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（GESU6840733）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,602","FIXEDASSETCARDNUM":"1044","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""},{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETTYPE":"集装箱","CFDD":"","COST":"16,536.92","CWBM":"F0107021926","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"JS08","DEPRECIATIONPERIOD":"0.00","DESCRIPTION":"集装箱（GESU6840950）","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"2020-12-28 17:35:36","FIXEDASSETCARDID":"1,603","FIXEDASSETCARDNUM":"1045","FIXENDDATE":"","MANAGEMENT":"JS08","OWNERSITE":"COSCOJZ","OWNERSITEDESC":"海口港集装箱码头有限公司","PRODUCTMODEL":"40HC","STATUS":"","UNITS":""}]
         * showcount : 5
         * totalpage : 219
         * totalresult : 1095
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
             * ADMINISTRATOR :
             * ADMINISTRATORDESC :
             * AMOUNT : 1.00
             * ASSETTYPE : 影像设备
             * CFDD :
             * COST : 99,931.47
             * CWBM : F0113001845
             * DATEOFPURCHASE :
             * DATEPLACEDINSERVICE :
             * DEPARTMENT : JS08
             * DEPRECIATIONPERIOD : 0.00
             * DESCRIPTION : 海关监控区（集装箱）视音频监修复工程
             * EMPLOYEENUMBER :
             * EMPLOYEENUMBERDESC :
             * FIXASSETDATE : 2020-12-28 17:35:36
             * FIXEDASSETCARDID : 1,599
             * FIXEDASSETCARDNUM : 1041
             * FIXENDDATE :
             * MANAGEMENT :
             * OWNERSITE : COSCOJZ
             * OWNERSITEDESC : 海口港集装箱码头有限公司
             * PRODUCTMODEL :
             * STATUS :
             * UNITS :
             */

            private String ADMINISTRATOR;
            private String ADMINISTRATORDESC;
            private String AMOUNT;
            private String ASSETTYPE;
            private String CFDD;
            private String COST;
            private String CWBM;
            private String DATEOFPURCHASE;
            private String DATEPLACEDINSERVICE;
            private String DEPARTMENT;
            private String DEPRECIATIONPERIOD;
            private String DESCRIPTION;
            private String EMPLOYEENUMBER;
            private String EMPLOYEENUMBERDESC;
            private String FIXASSETDATE;
            private String FIXEDASSETCARDID;
            private String FIXEDASSETCARDNUM;
            private String FIXENDDATE;
            private String MANAGEMENT;
            private String OWNERSITE;
            private String OWNERSITEDESC;
            private String PRODUCTMODEL;
            private String STATUS;
            private String UNITS;

            public String getADMINISTRATOR() {
                return ADMINISTRATOR;
            }

            public void setADMINISTRATOR(String ADMINISTRATOR) {
                this.ADMINISTRATOR = ADMINISTRATOR;
            }

            public String getADMINISTRATORDESC() {
                return ADMINISTRATORDESC;
            }

            public void setADMINISTRATORDESC(String ADMINISTRATORDESC) {
                this.ADMINISTRATORDESC = ADMINISTRATORDESC;
            }

            public String getAMOUNT() {
                return AMOUNT;
            }

            public void setAMOUNT(String AMOUNT) {
                this.AMOUNT = AMOUNT;
            }

            public String getASSETTYPE() {
                return ASSETTYPE;
            }

            public void setASSETTYPE(String ASSETTYPE) {
                this.ASSETTYPE = ASSETTYPE;
            }

            public String getCFDD() {
                return CFDD;
            }

            public void setCFDD(String CFDD) {
                this.CFDD = CFDD;
            }

            public String getCOST() {
                return COST;
            }

            public void setCOST(String COST) {
                this.COST = COST;
            }

            public String getCWBM() {
                return CWBM;
            }

            public void setCWBM(String CWBM) {
                this.CWBM = CWBM;
            }

            public String getDATEOFPURCHASE() {
                return DATEOFPURCHASE;
            }

            public void setDATEOFPURCHASE(String DATEOFPURCHASE) {
                this.DATEOFPURCHASE = DATEOFPURCHASE;
            }

            public String getDATEPLACEDINSERVICE() {
                return DATEPLACEDINSERVICE;
            }

            public void setDATEPLACEDINSERVICE(String DATEPLACEDINSERVICE) {
                this.DATEPLACEDINSERVICE = DATEPLACEDINSERVICE;
            }

            public String getDEPARTMENT() {
                return DEPARTMENT;
            }

            public void setDEPARTMENT(String DEPARTMENT) {
                this.DEPARTMENT = DEPARTMENT;
            }

            public String getDEPRECIATIONPERIOD() {
                return DEPRECIATIONPERIOD;
            }

            public void setDEPRECIATIONPERIOD(String DEPRECIATIONPERIOD) {
                this.DEPRECIATIONPERIOD = DEPRECIATIONPERIOD;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getEMPLOYEENUMBER() {
                return EMPLOYEENUMBER;
            }

            public void setEMPLOYEENUMBER(String EMPLOYEENUMBER) {
                this.EMPLOYEENUMBER = EMPLOYEENUMBER;
            }

            public String getEMPLOYEENUMBERDESC() {
                return EMPLOYEENUMBERDESC;
            }

            public void setEMPLOYEENUMBERDESC(String EMPLOYEENUMBERDESC) {
                this.EMPLOYEENUMBERDESC = EMPLOYEENUMBERDESC;
            }

            public String getFIXASSETDATE() {
                return FIXASSETDATE;
            }

            public void setFIXASSETDATE(String FIXASSETDATE) {
                this.FIXASSETDATE = FIXASSETDATE;
            }

            public String getFIXEDASSETCARDID() {
                return FIXEDASSETCARDID;
            }

            public void setFIXEDASSETCARDID(String FIXEDASSETCARDID) {
                this.FIXEDASSETCARDID = FIXEDASSETCARDID;
            }

            public String getFIXEDASSETCARDNUM() {
                return FIXEDASSETCARDNUM;
            }

            public void setFIXEDASSETCARDNUM(String FIXEDASSETCARDNUM) {
                this.FIXEDASSETCARDNUM = FIXEDASSETCARDNUM;
            }

            public String getFIXENDDATE() {
                return FIXENDDATE;
            }

            public void setFIXENDDATE(String FIXENDDATE) {
                this.FIXENDDATE = FIXENDDATE;
            }

            public String getMANAGEMENT() {
                return MANAGEMENT;
            }

            public void setMANAGEMENT(String MANAGEMENT) {
                this.MANAGEMENT = MANAGEMENT;
            }

            public String getOWNERSITE() {
                return OWNERSITE;
            }

            public void setOWNERSITE(String OWNERSITE) {
                this.OWNERSITE = OWNERSITE;
            }

            public String getOWNERSITEDESC() {
                return OWNERSITEDESC;
            }

            public void setOWNERSITEDESC(String OWNERSITEDESC) {
                this.OWNERSITEDESC = OWNERSITEDESC;
            }

            public String getPRODUCTMODEL() {
                return PRODUCTMODEL;
            }

            public void setPRODUCTMODEL(String PRODUCTMODEL) {
                this.PRODUCTMODEL = PRODUCTMODEL;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getUNITS() {
                return UNITS;
            }

            public void setUNITS(String UNITS) {
                this.UNITS = UNITS;
            }
        }
    }
}
