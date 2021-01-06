package com.zc.tarf530.model;

import java.util.List;

public class Event{
    /**
     * code : 0
     * msg :
     * res : {"list":[{"eventDescription":"","eventDispose":"","eventId":0,"eventLat":0,"eventLevel":0,"eventLevelName":"","eventLng":0,"eventName":"","eventOccur":"","eventStats":0,"eventStatsName":"","eventType":0,"eventTypeName":"","eventUser":0,"eventUserName":""}],"page":{"pageNum":0,"pageSize":0,"pages":0,"total":0}}
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
         * list : [{"eventDescription":"","eventDispose":"","eventId":0,"eventLat":0,"eventLevel":0,"eventLevelName":"","eventLng":0,"eventName":"","eventOccur":"","eventStats":0,"eventStatsName":"","eventType":0,"eventTypeName":"","eventUser":0,"eventUserName":""}]
         * page : {"pageNum":0,"pageSize":0,"pages":0,"total":0}
         */

        private PageBean page;
        private List<ListBean> list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PageBean {
            /**
             * pageNum : 0
             * pageSize : 0
             * pages : 0
             * total : 0
             */

            private int pageNum;
            private int pageSize;
            private int pages;
            private int total;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class ListBean {
            /**
             * eventDescription :
             * eventDispose :
             * eventId : 0
             * eventLat : 0
             * eventLevel : 0
             * eventLevelName :
             * eventLng : 0
             * eventName :
             * eventOccur :
             * eventStats : 0
             * eventStatsName :
             * eventType : 0
             * eventTypeName :
             * eventUser : 0
             * eventUserName :
             */

            private String eventDescription;
            private String eventDispose;
            private int eventId;
            private int eventLat;
            private int eventLevel;
            private String eventLevelName;
            private int eventLng;
            private String eventName;
            private String eventOccur;
            private int eventStats;
            private String eventStatsName;
            private int eventType;
            private String eventTypeName;
            private int eventUser;
            private String eventUserName;

            public String getEventDescription() {
                return eventDescription;
            }

            public void setEventDescription(String eventDescription) {
                this.eventDescription = eventDescription;
            }

            public String getEventDispose() {
                return eventDispose;
            }

            public void setEventDispose(String eventDispose) {
                this.eventDispose = eventDispose;
            }

            public int getEventId() {
                return eventId;
            }

            public void setEventId(int eventId) {
                this.eventId = eventId;
            }

            public int getEventLat() {
                return eventLat;
            }

            public void setEventLat(int eventLat) {
                this.eventLat = eventLat;
            }

            public int getEventLevel() {
                return eventLevel;
            }

            public void setEventLevel(int eventLevel) {
                this.eventLevel = eventLevel;
            }

            public String getEventLevelName() {
                return eventLevelName;
            }

            public void setEventLevelName(String eventLevelName) {
                this.eventLevelName = eventLevelName;
            }

            public int getEventLng() {
                return eventLng;
            }

            public void setEventLng(int eventLng) {
                this.eventLng = eventLng;
            }

            public String getEventName() {
                return eventName;
            }

            public void setEventName(String eventName) {
                this.eventName = eventName;
            }

            public String getEventOccur() {
                return eventOccur;
            }

            public void setEventOccur(String eventOccur) {
                this.eventOccur = eventOccur;
            }

            public int getEventStats() {
                return eventStats;
            }

            public void setEventStats(int eventStats) {
                this.eventStats = eventStats;
            }

            public String getEventStatsName() {
                return eventStatsName;
            }

            public void setEventStatsName(String eventStatsName) {
                this.eventStatsName = eventStatsName;
            }

            public int getEventType() {
                return eventType;
            }

            public void setEventType(int eventType) {
                this.eventType = eventType;
            }

            public String getEventTypeName() {
                return eventTypeName;
            }

            public void setEventTypeName(String eventTypeName) {
                this.eventTypeName = eventTypeName;
            }

            public int getEventUser() {
                return eventUser;
            }

            public void setEventUser(int eventUser) {
                this.eventUser = eventUser;
            }

            public String getEventUserName() {
                return eventUserName;
            }

            public void setEventUserName(String eventUserName) {
                this.eventUserName = eventUserName;
            }
        }
    }


//
//    /**
//     * code : 0
//     * msg : success
//     * res : {"list":[{"eventId":1,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0},{"eventId":4,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0},{"eventId":5,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0}],"page":{"count":3,"end":10,"pageCount":1,"pageIndex":1,"pageSize":10,"start":0}}
//     */
//
//    private int code;
//    private String msg;
//    private ResBean res;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public ResBean getRes() {
//        return res;
//    }
//
//    public void setRes(ResBean res) {
//        this.res = res;
//    }
//
//    public static class ResBean {
//        /**
//         * list : [{"eventId":1,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0},{"eventId":4,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0},{"eventId":5,"eventName":"撞车","eventReport":"2019-01-02","eventStats":0}]
//         * page : {"count":3,"end":10,"pageCount":1,"pageIndex":1,"pageSize":10,"start":0}
//         */
//
//        private PageBean page;
//        private List<ListBean> list;
//
//        public PageBean getPage() {
//            return page;
//        }
//
//        public void setPage(PageBean page) {
//            this.page = page;
//        }
//
//        public List<ListBean> getList() {
//            return list;
//        }
//
//        public void setList(List<ListBean> list) {
//            this.list = list;
//        }
//
//        public static class PageBean {
//            /**
//             * count : 3
//             * end : 10
//             * pageCount : 1
//             * pageIndex : 1
//             * pageSize : 10
//             * start : 0
//             */
//
//            private int count;
//            private int end;
//            private int pageCount;
//            private int pageIndex;
//            private int pageSize;
//            private int start;
//
//            public int getCount() {
//                return count;
//            }
//
//            public void setCount(int count) {
//                this.count = count;
//            }
//
//            public int getEnd() {
//                return end;
//            }
//
//            public void setEnd(int end) {
//                this.end = end;
//            }
//
//            public int getPageCount() {
//                return pageCount;
//            }
//
//            public void setPageCount(int pageCount) {
//                this.pageCount = pageCount;
//            }
//
//            public int getPageIndex() {
//                return pageIndex;
//            }
//
//            public void setPageIndex(int pageIndex) {
//                this.pageIndex = pageIndex;
//            }
//
//            public int getPageSize() {
//                return pageSize;
//            }
//
//            public void setPageSize(int pageSize) {
//                this.pageSize = pageSize;
//            }
//
//            public int getStart() {
//                return start;
//            }
//
//            public void setStart(int start) {
//                this.start = start;
//            }
//        }
//
//        public static class ListBean {
//            /**
//             * eventId : 1
//             * eventName : 撞车
//             * eventReport : 2019-01-02
//             * eventStats : 0
//             */
//
//            private int eventId;
//            private int eventLevel;
//            private String eventLevelName;
//            private String eventName;
//            private String eventReport;
//            private String eventTypeName;
//            private int eventStats;
//
//            public int getEventId() {
//                return eventId;
//            }
//
//            public void setEventId(int eventId) {
//                this.eventId = eventId;
//            }
//
//            public String getEventName() {
//                return eventName;
//            }
//
//            public void setEventName(String eventName) {
//                this.eventName = eventName;
//            }
//
//            public String getEventReport() {
//                return eventReport;
//            }
//
//            public void setEventReport(String eventReport) {
//                this.eventReport = eventReport;
//            }
//
//            public int getEventStats() {
//                return eventStats;
//            }
//
//            public void setEventStats(int eventStats) {
//                this.eventStats = eventStats;
//            }
//
//            public String getEventLevelName() {
//                return eventLevelName;
//            }
//
//            public void setEventLevelName(String eventLevelName) {
//                this.eventLevelName = eventLevelName;
//            }
//
//            public String getEventTypeName() {
//                return eventTypeName;
//            }
//
//            public void setEventTypeName(String eventTypeName) {
//                this.eventTypeName = eventTypeName;
//            }
//
//            public int getEventLevel() {
//                return eventLevel;
//            }
//
//            public void setEventLevel(int eventLevel) {
//                this.eventLevel = eventLevel;
//            }
//        }
//    }
}
