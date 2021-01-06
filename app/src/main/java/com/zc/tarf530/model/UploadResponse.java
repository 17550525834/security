package com.zc.tarf530.model;

import java.util.List;

public class UploadResponse {

    /**
     * code : 0
     * msg :
     * res : [{"documentId":0,"documentType":0,"url":""}]
     */

    private int code;
    private String msg;
    private List<ResBean> res;

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

    public List<ResBean> getRes() {
        return res;
    }

    public void setRes(List<ResBean> res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * documentId : 0
         * documentType : 0
         * url :
         */

        private String documentId;
        private int documentType;
//        private String url;

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public int getDocumentType() {
            return documentType;
        }

        public void setDocumentType(int documentType) {
            this.documentType = documentType;
        }

//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
    }
}
