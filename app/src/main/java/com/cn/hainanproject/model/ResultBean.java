package com.cn.hainanproject.model;

import java.io.Serializable;

public class ResultBean implements Serializable {

    /**
     * baseCaltype : gregorian
     * baseCurrency : CNY
     * caltype : gregorian
     * connectionKey : {"inetAddress":"192.168.1.180","loginUserName":"MAXADMIN","preview":false,"secondID":0,"uID":{}}
     * defaultLang :
     * defaultLocaleStr :
     * defaultTZStr :
     * displayName : 系统管理员
     * iCULocale : {"baseName":"zh_CN","country":"CN","displayCountry":"中国","displayLanguage":"中文","displayName":"中文 (中国, 日历=公历)","displayScript":"","displayVariant":"","fallback":{"baseName":"zh","country":"","displayCountry":"","displayLanguage":"中文","displayName":"中文 (日历=公历)","displayScript":"","displayVariant":"","fallback":{"baseName":"","country":"","displayCountry":"","displayLanguage":"","displayName":"日历=公历","displayScript":"","displayVariant":"","iSO3Country":"","iSO3Language":"","keywords":{},"language":"","name":"@calendar=gregorian","script":"","variant":""},"iSO3Country":"","iSO3Language":"zho","keywords":{},"language":"zh","name":"zh@calendar=gregorian","script":"","variant":""},"iSO3Country":"CHN","iSO3Language":"zho","keywords":{},"language":"zh","name":"zh_CN@calendar=gregorian","script":"","variant":""}
     * inactiveSites : true
     * insertSite : 1000
     * interactive : false
     * langCode : ZH
     * localSession : false
     * locale : zh_CN
     * loginID : MAXADMIN
     * loginUserName : MAXADMIN
     * maxSessionID : 0
     * personId : MAXADMIN
     * preview : false
     * schemaOwner : bltct
     * screenReader : false
     * serverGuid : f85c9cda-90fb-4dca-ac1c-07dfb8027810
     * startApp :
     * timeZone : Asia/Shanghai
     * userLoginDetails : {"baseCalendar":"gregorian","baseCurrency":"CNY","baseLang":"ZH","defaultLang":"","defaultLocaleStr":"","defaultOrg":"10","defaultSite":"1000","defaultStoreroom":"","defaultTZStr":"","displayName":"系统管理员","inactiveSites":true,"insertOrg":"10","insertSite":"1000","loginUserName":"MAXADMIN","maxSessionID":0,"personId":"MAXADMIN","queryWithSite":false,"schemaOwner":"bltct","screenReader":false,"userName":"MAXADMIN"}
     * userName : MAXADMIN
     */

    private String baseCaltype;
    private String baseCurrency;
    private String caltype;
    private ConnectionKeyBean connectionKey;
    private String defaultLang;
    private String defaultLocaleStr;
    private String defaultTZStr;
    private String displayName;
    private ICULocaleBean iCULocale;
    private boolean inactiveSites;
    private String insertSite;
    private boolean interactive;
    private String langCode;
    private boolean localSession;
    private String locale;

    public UserLoginDetailsBean getUserLoginDetails() {
        return userLoginDetails;
    }

    public void setUserLoginDetails(UserLoginDetailsBean userLoginDetails) {
        this.userLoginDetails = userLoginDetails;
    }

    private String loginID;
    private String loginUserName;
    private int maxSessionID;
    private String personId;
    private boolean preview;
    private String schemaOwner;
    private boolean screenReader;
    private String serverGuid;
    private String startApp;
    private String timeZone;
    private UserLoginDetailsBean userLoginDetails;
    private String userName;
    /**
     * baseName : zh_CN
     * country : CN
     * displayCountry : 中国
     * displayLanguage : 中文
     * displayScript :
     * displayVariant :
     * fallback : {"baseName":"zh","country":"","displayCountry":"","displayLanguage":"中文","displayName":"中文 (日历=公历)","displayScript":"","displayVariant":"","fallback":{"baseName":"","country":"","displayCountry":"","displayLanguage":"","displayName":"日历=公历","displayScript":"","displayVariant":"","iSO3Country":"","iSO3Language":"","keywords":{},"language":"","name":"@calendar=gregorian","script":"","variant":""},"iSO3Country":"","iSO3Language":"zho","keywords":{},"language":"zh","name":"zh@calendar=gregorian","script":"","variant":""}
     * iSO3Country : CHN
     * iSO3Language : zho
     * keywords : {}
     * language : zh
     * name : zh_CN@calendar=gregorian
     * script :
     * variant :
     */

    private String baseName;
    private String country;
    private String displayCountry;
    private String displayLanguage;
    private String displayScript;
    private String displayVariant;
    private FallbackBeanX fallback;
    private String iSO3Country;
    private String iSO3Language;
    //    private KeywordsBeanXX keywords;
    private String language;
    private String name;
    private String script;
    private String variant;

    public static class ConnectionKeyBean {
        /**
         * inetAddress : 192.168.1.180
         * loginUserName : MAXADMIN
         * preview : false
         * secondID : 0
         * uID : {}
         */

        private String inetAddress;
        private String loginUserName;
        private boolean preview;
        private int secondID;
        private UIDBean uID;

        public String getInetAddress() {
            return inetAddress;
        }

        public void setInetAddress(String inetAddress) {
            this.inetAddress = inetAddress;
        }

        public String getLoginUserName() {
            return loginUserName;
        }

        public void setLoginUserName(String loginUserName) {
            this.loginUserName = loginUserName;
        }

        public boolean isPreview() {
            return preview;
        }

        public void setPreview(boolean preview) {
            this.preview = preview;
        }

        public int getSecondID() {
            return secondID;
        }

        public void setSecondID(int secondID) {
            this.secondID = secondID;
        }

        public UIDBean getUID() {
            return uID;
        }

        public void setUID(UIDBean uID) {
            this.uID = uID;
        }

        public static class UIDBean {
        }
    }

    public class UserLoginDetailsBean implements Serializable {

        /**
         * baseCalendar : gregorian
         * baseCurrency : CNY
         * baseLang : ZH
         * defaultLang :
         * defaultLocaleStr :
         * defaultOrg : 10
         * defaultSite : 1000
         * defaultStoreroom :
         * defaultTZStr :
         * displayName : 系统管理员
         * inactiveSites : true
         * insertOrg : 10
         * insertSite : 1000
         * loginUserName : MAXADMIN
         * maxSessionID : 0
         * personId : MAXADMIN
         * queryWithSite : false
         * schemaOwner : bltct
         * screenReader : false
         * userName : MAXADMIN
         */

        public String baseCalendar;
        public String baseCurrency;
        public String baseLang;
        public String defaultLang;
        public String defaultLocaleStr;
        public String defaultOrg;
        public String defaultSite;
        public String defaultStoreroom;
        public String defaultTZStr;
        public String displayName;
        public boolean inactiveSites;
        private String insertOrg;
        private String insertSite;
        private String loginUserName;
        private int maxSessionID;
        public String personId;
        public boolean queryWithSite;
        public String schemaOwner;
        public boolean screenReader;
        public String userName;

        public String getBaseCalendar() {
            return baseCalendar;
        }

        public void setBaseCalendar(String baseCalendar) {
            this.baseCalendar = baseCalendar;
        }

        public String getBaseCurrency() {
            return baseCurrency;
        }

        public void setBaseCurrency(String baseCurrency) {
            this.baseCurrency = baseCurrency;
        }

        public String getBaseLang() {
            return baseLang;
        }

        public void setBaseLang(String baseLang) {
            this.baseLang = baseLang;
        }

        public String getDefaultLang() {
            return defaultLang;
        }

        public void setDefaultLang(String defaultLang) {
            this.defaultLang = defaultLang;
        }

        public String getDefaultLocaleStr() {
            return defaultLocaleStr;
        }

        public void setDefaultLocaleStr(String defaultLocaleStr) {
            this.defaultLocaleStr = defaultLocaleStr;
        }

        public String getDefaultOrg() {
            return defaultOrg;
        }

        public void setDefaultOrg(String defaultOrg) {
            this.defaultOrg = defaultOrg;
        }

        public String getDefaultSite() {
            return defaultSite;
        }

        public void setDefaultSite(String defaultSite) {
            this.defaultSite = defaultSite;
        }

        public String getDefaultStoreroom() {
            return defaultStoreroom;
        }

        public void setDefaultStoreroom(String defaultStoreroom) {
            this.defaultStoreroom = defaultStoreroom;
        }

        public String getDefaultTZStr() {
            return defaultTZStr;
        }

        public void setDefaultTZStr(String defaultTZStr) {
            this.defaultTZStr = defaultTZStr;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public boolean isInactiveSites() {
            return inactiveSites;
        }

        public void setInactiveSites(boolean inactiveSites) {
            this.inactiveSites = inactiveSites;
        }

        public String getInsertOrg() {
            return insertOrg;
        }

        public void setInsertOrg(String insertOrg) {
            this.insertOrg = insertOrg;
        }

        public String getInsertSite() {
            return insertSite;
        }

        public void setInsertSite(String insertSite) {
            this.insertSite = insertSite;
        }

        public String getLoginUserName() {
            return loginUserName;
        }

        public void setLoginUserName(String loginUserName) {
            this.loginUserName = loginUserName;
        }

        public int getMaxSessionID() {
            return maxSessionID;
        }

        public void setMaxSessionID(int maxSessionID) {
            this.maxSessionID = maxSessionID;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public boolean isQueryWithSite() {
            return queryWithSite;
        }

        public void setQueryWithSite(boolean queryWithSite) {
            this.queryWithSite = queryWithSite;
        }

        public String getSchemaOwner() {
            return schemaOwner;
        }

        public void setSchemaOwner(String schemaOwner) {
            this.schemaOwner = schemaOwner;
        }

        public boolean isScreenReader() {
            return screenReader;
        }

        public void setScreenReader(boolean screenReader) {
            this.screenReader = screenReader;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    private class ICULocaleBean {

    }

    private class FallbackBeanX {

        /**
         * baseName :
         * country :
         * displayCountry :
         * displayLanguage :
         * displayName : 日历=公历
         * displayScript :
         * displayVariant :
         * iSO3Country :
         * iSO3Language :
         * keywords : {}
         * language :
         * name : @calendar=gregorian
         * script :
         * variant :
         */

        private String baseName;
        private String country;
        private String displayCountry;
        private String displayLanguage;
        private String displayName;
        private String displayScript;
        private String displayVariant;
        private String iSO3Country;
        private String iSO3Language;
        private KeywordsBean keywords;
        private String language;
        private String name;
        private String script;
        private String variant;

        public String getBaseName() {
            return baseName;
        }

        public void setBaseName(String baseName) {
            this.baseName = baseName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDisplayCountry() {
            return displayCountry;
        }

        public void setDisplayCountry(String displayCountry) {
            this.displayCountry = displayCountry;
        }

        public String getDisplayLanguage() {
            return displayLanguage;
        }

        public void setDisplayLanguage(String displayLanguage) {
            this.displayLanguage = displayLanguage;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayScript() {
            return displayScript;
        }

        public void setDisplayScript(String displayScript) {
            this.displayScript = displayScript;
        }

        public String getDisplayVariant() {
            return displayVariant;
        }

        public void setDisplayVariant(String displayVariant) {
            this.displayVariant = displayVariant;
        }

        public String getISO3Country() {
            return iSO3Country;
        }

        public void setISO3Country(String iSO3Country) {
            this.iSO3Country = iSO3Country;
        }

        public String getISO3Language() {
            return iSO3Language;
        }

        public void setISO3Language(String iSO3Language) {
            this.iSO3Language = iSO3Language;
        }

        public KeywordsBean getKeywords() {
            return keywords;
        }

        public void setKeywords(KeywordsBean keywords) {
            this.keywords = keywords;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }

        public String getVariant() {
            return variant;
        }

        public void setVariant(String variant) {
            this.variant = variant;
        }

        public class KeywordsBean {
        }
    }


}
