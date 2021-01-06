package com.zc.tarf530.model;

public class LoginRawResponse {
    /**
     * code : 000000
     * data : {"post_id":"","post":"","user_id":"YH1","org_id":"a114501","name":"ä¼¯æ¡\u0082è\u008a\u009d","tel":"13153252535","region":"4501","org_name":"å\u008d\u0097å®\u0081å¸\u0082äººé\u0098²æ\u008c\u0087æ\u008c¥é\u0083¨","date_exp":1606669522,"account":"use1","status":true,"token":"eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IllIMSIsInVzZXJuYW1lIjoiXHU0ZjJmXHU2ODQyXHU4MjlkIiwicm9sZSI6Ilx1NTM1N1x1NWI4MVx1NWUwMlx1NGViYVx1OTYzMlx1NjMwN1x1NjMyNVx1OTBlOCIsImV4cCI6MTYwNjY2OTUyMn0.0oDkxXJ75mOaTuXdpX09GQcJizfyLqNuYp_GVD0uR6A"}
     * message : æä½æå--ç»å½ä¿¡æ¯ï¼h-----j
     */

    private String code;
    private DataBean data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * post_id :
         * post :
         * user_id : YH1
         * org_id : a114501
         * name : ä¼¯æ¡è
         * tel : 13153252535
         * region : 4501
         * org_name : åå®å¸äººé²ææ¥é¨
         * date_exp : 1606669522
         * account : use1
         * status : true
         * token : eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IllIMSIsInVzZXJuYW1lIjoiXHU0ZjJmXHU2ODQyXHU4MjlkIiwicm9sZSI6Ilx1NTM1N1x1NWI4MVx1NWUwMlx1NGViYVx1OTYzMlx1NjMwN1x1NjMyNVx1OTBlOCIsImV4cCI6MTYwNjY2OTUyMn0.0oDkxXJ75mOaTuXdpX09GQcJizfyLqNuYp_GVD0uR6A
         */

        private String post_id;
        private String post;
        private String user_id;
        private String org_id;
        private String name;
        private String tel;
        private String region;
        private String region_id;
        private String org_name;
        private int date_exp;
        private String account;
        private boolean status;
        private String token;

        public String getRegion_id(){
            return region_id;
        }
        public void setRegion_id(String region_id){
            this.region_id=region_id;
        }

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getOrg_id() {
            return org_id;
        }

        public void setOrg_id(String org_id) {
            this.org_id = org_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getOrg_name() {
            return org_name;
        }

        public void setOrg_name(String org_name) {
            this.org_name = org_name;
        }

        public int getDate_exp() {
            return date_exp;
        }

        public void setDate_exp(int date_exp) {
            this.date_exp = date_exp;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

//    /**
//     * data : {"id":1,"domainType":1,"authCode":"5afcec02a761cc518dfcb73e86240bd7e4be43bd81e1a80e48e3a7a70c190db1bfa460d9e20e717acd9dedb6299d61e4b64cd0f87db1bdc3970d179941827df8","userCode":"test","domainId":1000000000001,"userName":"测试账号","language":"ZHC","kind":3,"loginCode":"test"}
//     * code : 0
//     * success : true
//     */
//
//    private DataBean data;
//    private int code;
//    private boolean success;
//    private String message;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public static class DataBean {
//        /**
//         * id : 1
//         * domainType : 1
//         * authCode : 5afcec02a761cc518dfcb73e86240bd7e4be43bd81e1a80e48e3a7a70c190db1bfa460d9e20e717acd9dedb6299d61e4b64cd0f87db1bdc3970d179941827df8
//         * userCode : test
//         * domainId : 1000000000001
//         * userName : 测试账号
//         * language : ZHC
//         * kind : 3
//         * loginCode : test
//         */
//
//        private int id;
//        private int domainType;
//        private String authCode;
//        private String userCode;
//        private long domainId;
//        private String userName;
//        private String language;
//        private int kind;
//        private String loginCode;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public int getDomainType() {
//            return domainType;
//        }
//
//        public void setDomainType(int domainType) {
//            this.domainType = domainType;
//        }
//
//        public String getAuthCode() {
//            return authCode;
//        }
//
//        public void setAuthCode(String authCode) {
//            this.authCode = authCode;
//        }
//
//        public String getUserCode() {
//            return userCode;
//        }
//
//        public void setUserCode(String userCode) {
//            this.userCode = userCode;
//        }
//
//        public long getDomainId() {
//            return domainId;
//        }
//
//        public void setDomainId(long domainId) {
//            this.domainId = domainId;
//        }
//
//        public String getUserName() {
//            return userName;
//        }
//
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//
//        public String getLanguage() {
//            return language;
//        }
//
//        public void setLanguage(String language) {
//            this.language = language;
//        }
//
//        public int getKind() {
//            return kind;
//        }
//
//        public void setKind(int kind) {
//            this.kind = kind;
//        }
//
//        public String getLoginCode() {
//            return loginCode;
//        }
//
//        public void setLoginCode(String loginCode) {
//            this.loginCode = loginCode;
//        }
//    }


}
