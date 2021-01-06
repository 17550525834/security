package com.zc.tarf530.model;

public class EventUser {


    /**
     * code : 0
     * msg :
     * res : {"directOrgId":0,"directOrgName":"","id":0,"userCode":"","userName":""}
     */

    private int code;
    private String msg;
    private ResBean res;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * directOrgId : 0
         * directOrgName :
         * id : 0
         * userCode :
         * userName :
         */

        private String directOrgId;
        private String directOrgName;
        private int id;
        private String userCode;
        private String userName;

        public String getDirectOrgId() {
            return directOrgId;
        }

        public void setDirectOrgId(String directOrgId) {
            this.directOrgId = directOrgId;
        }

        public String getDirectOrgName() {
            return directOrgName;
        }

        public void setDirectOrgName(String directOrgName) {
            this.directOrgName = directOrgName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
