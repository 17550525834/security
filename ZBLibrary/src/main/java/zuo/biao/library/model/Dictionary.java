package zuo.biao.library.model;

import java.util.List;

public class Dictionary {

    /**
     * code : 0
     * msg : success
     * res : [{"dictionaryCode":"1","dictionaryName":"特别重大"},{"dictionaryCode":"2","dictionaryName":"重大"},{"dictionaryCode":"3","dictionaryName":"较大"},{"dictionaryCode":"4","dictionaryName":"一般"}]
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
         * dictionaryCode : 1
         * dictionaryName : 特别重大
         */

        private String dictionaryCode;
        private String dictionaryName;

        public String getDictionaryCode() {
            return dictionaryCode;
        }

        public void setDictionaryCode(String dictionaryCode) {
            this.dictionaryCode = dictionaryCode;
        }

        public String getDictionaryName() {
            return dictionaryName;
        }

        public void setDictionaryName(String dictionaryName) {
            this.dictionaryName = dictionaryName;
        }

        @Override
        public String toString() {
            return getDictionaryName();
        }
    }
}
