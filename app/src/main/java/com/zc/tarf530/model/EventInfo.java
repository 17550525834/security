package com.zc.tarf530.model;

import java.util.List;

public class EventInfo {
    /**
     * code : 0
     * msg : 查询成功
     * res : {"eventId":7,"eventName":"sadasd","eventType":1,"eventLevel":1,"eventTypeName":"治安","eventLevelName":"特大","eventRegionId":"3709","eventRegionName":"泰安市","eventLng":117.042374,"eventLat":36.200094,"eventAddr":"132","eventOccur":"2020-06-03 08:36:09","eventDispose":null,"eventInvolve":0,"eventCasualties":0,"eventDescription":"aaa","eventReport":"2020-06-09 16:46:16","eventUser":1,"eventUserName":"xxx","eventStats":0,"eventStatsName":"待确认","img":[{"documentId":"7794383bd6f1740e3b0195483338b2d8","documentType":1},{"documentId":"6cd62a1caaa49e3acedde6567e7ce76a","documentType":1}],"video":[]}
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
         * eventId : 7
         * eventName : sadasd
         * eventType : 1
         * eventLevel : 1
         * eventTypeName : 治安
         * eventLevelName : 特大
         * eventRegionId : 3709
         * eventRegionName : 泰安市
         * eventLng : 117.042374
         * eventLat : 36.200094
         * eventAddr : 132
         * eventOccur : 2020-06-03 08:36:09
         * eventDispose : null
         * eventInvolve : 0
         * eventCasualties : 0
         * eventDescription : aaa
         * eventReport : 2020-06-09 16:46:16
         * eventUser : 1
         * eventUserName : xxx
         * eventStats : 0
         * eventStatsName : 待确认
         * img : [{"documentId":"7794383bd6f1740e3b0195483338b2d8","documentType":1},{"documentId":"6cd62a1caaa49e3acedde6567e7ce76a","documentType":1}]
         * video : []
         */

        private int eventId;
        private String eventName;
        private int eventType;
        private int eventLevel;
        private String eventTypeName;
        private String eventLevelName;
        private String eventRegionId;
        private String eventRegionName;
        private double eventLng;
        private double eventLat;
        private String eventAddr;
        private String eventOccur;
        private Object eventDispose;
        private int eventInvolve;
        private int eventCasualties;
        private String eventDescription;
        private String eventReport;
        private int eventUser;
        private String eventUserName;
        private int eventStats;
        private String eventStatsName;
        private List<ImgBean> img;
        private List<VideoBean> video;

        public int getEventId() {
            return eventId;
        }

        public void setEventId(int eventId) {
            this.eventId = eventId;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public int getEventType() {
            return eventType;
        }

        public void setEventType(int eventType) {
            this.eventType = eventType;
        }

        public int getEventLevel() {
            return eventLevel;
        }

        public void setEventLevel(int eventLevel) {
            this.eventLevel = eventLevel;
        }

        public String getEventTypeName() {
            return eventTypeName;
        }

        public void setEventTypeName(String eventTypeName) {
            this.eventTypeName = eventTypeName;
        }

        public String getEventLevelName() {
            return eventLevelName;
        }

        public void setEventLevelName(String eventLevelName) {
            this.eventLevelName = eventLevelName;
        }

        public String getEventRegionId() {
            return eventRegionId;
        }

        public void setEventRegionId(String eventRegionId) {
            this.eventRegionId = eventRegionId;
        }

        public String getEventRegionName() {
            return eventRegionName;
        }

        public void setEventRegionName(String eventRegionName) {
            this.eventRegionName = eventRegionName;
        }

        public double getEventLng() {
            return eventLng;
        }

        public void setEventLng(double eventLng) {
            this.eventLng = eventLng;
        }

        public double getEventLat() {
            return eventLat;
        }

        public void setEventLat(double eventLat) {
            this.eventLat = eventLat;
        }

        public String getEventAddr() {
            return eventAddr;
        }

        public void setEventAddr(String eventAddr) {
            this.eventAddr = eventAddr;
        }

        public String getEventOccur() {
            return eventOccur;
        }

        public void setEventOccur(String eventOccur) {
            this.eventOccur = eventOccur;
        }

        public Object getEventDispose() {
            return eventDispose;
        }

        public void setEventDispose(Object eventDispose) {
            this.eventDispose = eventDispose;
        }

        public int getEventInvolve() {
            return eventInvolve;
        }

        public void setEventInvolve(int eventInvolve) {
            this.eventInvolve = eventInvolve;
        }

        public int getEventCasualties() {
            return eventCasualties;
        }

        public void setEventCasualties(int eventCasualties) {
            this.eventCasualties = eventCasualties;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public String getEventReport() {
            return eventReport;
        }

        public void setEventReport(String eventReport) {
            this.eventReport = eventReport;
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

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public List<VideoBean> getVideo() {
            return video;
        }

        public void setVideo(List<VideoBean> video) {
            this.video = video;
        }

        public static class ImgBean {
            /**
             * documentId : 7794383bd6f1740e3b0195483338b2d8
             * documentType : 1
             */

            private String documentId;
            private int documentType;

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
        }
        public static class VideoBean {
            /**
             * documentId : 7794383bd6f1740e3b0195483338b2d8
             * documentType : 1
             */

            private String documentId;
            private int documentType;

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
        }
    }


//    /**
//     * code : 0
//     * msg : success
//     * res : {"dataStats":1,"eventAddr":"石家庄","eventCasualties":2,"eventDescription":"定点","eventId":19,"eventInvolve":55,"eventLat":11.11,"eventLevel":1,"eventLevelName":"特大","eventLng":11.11,"eventName":"大火","eventOccur":"","eventReport":"","eventStats":0,"eventType":1,"eventTypeName":"治安","eventUser":{"affiliation":"警局","name":"张三","userId":1},"img":[{"documentId":62,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/62"}],"video":[{"documentId":63,"documentType":2,"url":"http://doctor.nat100.top/asc-annex/annex/data/63"}]}
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
//         * dataStats : 1
//         * eventAddr : 石家庄
//         * eventCasualties : 2
//         * eventDescription : 定点
//         * eventId : 19
//         * eventInvolve : 55
//         * eventLat : 11.11
//         * eventLevel : 1
//         * eventLevelName : 特大
//         * eventLng : 11.11
//         * eventName : 大火
//         * eventOccur :
//         * eventReport :
//         * eventStats : 0
//         * eventType : 1
//         * eventTypeName : 治安
//         * eventUser : {"affiliation":"警局","name":"张三","userId":1}
//         * img : [{"documentId":62,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/62"}]
//         * video : [{"documentId":63,"documentType":2,"url":"http://doctor.nat100.top/asc-annex/annex/data/63"}]
//         */
//
//        private int dataStats;
//        private String eventAddr;
//        private int eventCasualties;
//        private String eventDescription;
//        private int eventId;
//        private int eventInvolve;
//        private double eventLat;
//        private int eventLevel;
//        private String eventLevelName;
//        private double eventLng;
//        private String eventName;
//        private String eventOccur;
//        private String eventReport;
//        private int eventStats;
//        private int eventType;
//        private String eventTypeName;
//        private EventUserBean eventUser;
//        private List<ImgBean> img;
//        private List<VideoBean> video;
//
//        public int getDataStats() {
//            return dataStats;
//        }
//
//        public void setDataStats(int dataStats) {
//            this.dataStats = dataStats;
//        }
//
//        public String getEventAddr() {
//            return eventAddr;
//        }
//
//        public void setEventAddr(String eventAddr) {
//            this.eventAddr = eventAddr;
//        }
//
//        public int getEventCasualties() {
//            return eventCasualties;
//        }
//
//        public void setEventCasualties(int eventCasualties) {
//            this.eventCasualties = eventCasualties;
//        }
//
//        public String getEventDescription() {
//            return eventDescription;
//        }
//
//        public void setEventDescription(String eventDescription) {
//            this.eventDescription = eventDescription;
//        }
//
//        public int getEventId() {
//            return eventId;
//        }
//
//        public void setEventId(int eventId) {
//            this.eventId = eventId;
//        }
//
//        public int getEventInvolve() {
//            return eventInvolve;
//        }
//
//        public void setEventInvolve(int eventInvolve) {
//            this.eventInvolve = eventInvolve;
//        }
//
//        public double getEventLat() {
//            return eventLat;
//        }
//
//        public void setEventLat(double eventLat) {
//            this.eventLat = eventLat;
//        }
//
//        public int getEventLevel() {
//            return eventLevel;
//        }
//
//        public void setEventLevel(int eventLevel) {
//            this.eventLevel = eventLevel;
//        }
//
//        public String getEventLevelName() {
//            return eventLevelName;
//        }
//
//        public void setEventLevelName(String eventLevelName) {
//            this.eventLevelName = eventLevelName;
//        }
//
//        public double getEventLng() {
//            return eventLng;
//        }
//
//        public void setEventLng(double eventLng) {
//            this.eventLng = eventLng;
//        }
//
//        public String getEventName() {
//            return eventName;
//        }
//
//        public void setEventName(String eventName) {
//            this.eventName = eventName;
//        }
//
//        public String getEventOccur() {
//            return eventOccur;
//        }
//
//        public void setEventOccur(String eventOccur) {
//            this.eventOccur = eventOccur;
//        }
//
//        public String getEventReport() {
//            return eventReport;
//        }
//
//        public void setEventReport(String eventReport) {
//            this.eventReport = eventReport;
//        }
//
//        public int getEventStats() {
//            return eventStats;
//        }
//
//        public void setEventStats(int eventStats) {
//            this.eventStats = eventStats;
//        }
//
//        public int getEventType() {
//            return eventType;
//        }
//
//        public void setEventType(int eventType) {
//            this.eventType = eventType;
//        }
//
//        public String getEventTypeName() {
//            return eventTypeName;
//        }
//
//        public void setEventTypeName(String eventTypeName) {
//            this.eventTypeName = eventTypeName;
//        }
//
//        public EventUserBean getEventUser() {
//            return eventUser;
//        }
//
//        public void setEventUser(EventUserBean eventUser) {
//            this.eventUser = eventUser;
//        }
//
//        public List<ImgBean> getImg() {
//            return img;
//        }
//
//        public void setImg(List<ImgBean> img) {
//            this.img = img;
//        }
//
//        public List<VideoBean> getVideo() {
//            return video;
//        }
//
//        public void setVideo(List<VideoBean> video) {
//            this.video = video;
//        }
//
//        public static class EventUserBean {
//            /**
//             * affiliation : 警局
//             * name : 张三
//             * userId : 1
//             */
//
//            private String affiliation;
//            private String name;
//            private int userId;
//
//            public String getAffiliation() {
//                return affiliation;
//            }
//
//            public void setAffiliation(String affiliation) {
//                this.affiliation = affiliation;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public int getUserId() {
//                return userId;
//            }
//
//            public void setUserId(int userId) {
//                this.userId = userId;
//            }
//        }
//
//        public static class ImgBean {
//            /**
//             * documentId : 62
//             * documentType : 1
//             * url : http://doctor.nat100.top/asc-annex/annex/data/62
//             */
//
//            private int documentId;
//            private int documentType;
//            private String url;
//
//            public int getDocumentId() {
//                return documentId;
//            }
//
//            public void setDocumentId(int documentId) {
//                this.documentId = documentId;
//            }
//
//            public int getDocumentType() {
//                return documentType;
//            }
//
//            public void setDocumentType(int documentType) {
//                this.documentType = documentType;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//        }
//
//        public static class VideoBean {
//            /**
//             * documentId : 63
//             * documentType : 2
//             * url : http://doctor.nat100.top/asc-annex/annex/data/63
//             */
//
//            private int documentId;
//            private int documentType;
//            private String url;
//
//            public int getDocumentId() {
//                return documentId;
//            }
//
//            public void setDocumentId(int documentId) {
//                this.documentId = documentId;
//            }
//
//            public int getDocumentType() {
//                return documentType;
//            }
//
//            public void setDocumentType(int documentType) {
//                this.documentType = documentType;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//        }
//    }

//    /**
//     * code : 0
//     * msg : success
//     * res : {"dataStats":1,"eventAddr":"海悦天地","eventCasualties":1,"eventDescription":"撞车，啥抠脚大汉看见爱上大恒科技","eventId":1,"eventInvolve":10,"eventLat":10.001,"eventLevel":"一般","eventLng":10.002,"eventName":"撞车","eventOccur":"20190102-19:11","eventReport":"20190102-19:11","eventStats":0,"eventType":"治安","eventUser":{"affiliation":"警局","name":"张三","userId":1},"img":[{"documentId":9,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/9"},{"documentId":10,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/10"}],"video":[{"documentId":11,"documentType":2,"url":"http://doctor.nat100.top/asc-annex/annex/data/11"}]}
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
//         * dataStats : 1
//         * eventAddr : 海悦天地
//         * eventCasualties : 1
//         * eventDescription : 撞车，啥抠脚大汉看见爱上大恒科技
//         * eventId : 1
//         * eventInvolve : 10
//         * eventLat : 10.001
//         * eventLevel : 一般
//         * eventLng : 10.002
//         * eventName : 撞车
//         * eventOccur : 20190102-19:11
//         * eventReport : 20190102-19:11
//         * eventStats : 0
//         * eventType : 治安
//         * eventUser : {"affiliation":"警局","name":"张三","userId":1}
//         * img : [{"documentId":9,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/9"},{"documentId":10,"documentType":1,"url":"http://doctor.nat100.top/asc-annex/annex/data/10"}]
//         * video : [{"documentId":11,"documentType":2,"url":"http://doctor.nat100.top/asc-annex/annex/data/11"}]
//         */
//
//        private int dataStats;
//        private String eventAddr;
//        private int eventCasualties;
//        private String eventDescription;
//        private int eventId;
//        private int eventInvolve;
//        private double eventLat;
//        private String eventLevelName;
//        private double eventLng;
//        private String eventName;
//        private String eventOccur;
//        private String eventReport;
//        private int eventStats;
//        private String eventTypeName;
//        private EventUserBean eventUser;
//        private List<ImgBean> img;
//        private List<VideoBean> video;
//
//        public int getDataStats() {
//            return dataStats;
//        }
//
//        public void setDataStats(int dataStats) {
//            this.dataStats = dataStats;
//        }
//
//        public String getEventAddr() {
//            return eventAddr;
//        }
//
//        public void setEventAddr(String eventAddr) {
//            this.eventAddr = eventAddr;
//        }
//
//        public int getEventCasualties() {
//            return eventCasualties;
//        }
//
//        public void setEventCasualties(int eventCasualties) {
//            this.eventCasualties = eventCasualties;
//        }
//
//        public String getEventDescription() {
//            return eventDescription;
//        }
//
//        public void setEventDescription(String eventDescription) {
//            this.eventDescription = eventDescription;
//        }
//
//        public int getEventId() {
//            return eventId;
//        }
//
//        public void setEventId(int eventId) {
//            this.eventId = eventId;
//        }
//
//        public int getEventInvolve() {
//            return eventInvolve;
//        }
//
//        public void setEventInvolve(int eventInvolve) {
//            this.eventInvolve = eventInvolve;
//        }
//
//        public double getEventLat() {
//            return eventLat;
//        }
//
//        public void setEventLat(double eventLat) {
//            this.eventLat = eventLat;
//        }
//
//        public String getEventLevel() {
//            return eventLevelName;
//        }
//
//        public void setEventLevel(String eventLevel) {
//            this.eventLevelName = eventLevel;
//        }
//
//        public double getEventLng() {
//            return eventLng;
//        }
//
//        public void setEventLng(double eventLng) {
//            this.eventLng = eventLng;
//        }
//
//        public String getEventName() {
//            return eventName;
//        }
//
//        public void setEventName(String eventName) {
//            this.eventName = eventName;
//        }
//
//        public String getEventOccur() {
//            return eventOccur;
//        }
//
//        public void setEventOccur(String eventOccur) {
//            this.eventOccur = eventOccur;
//        }
//
//        public String getEventReport() {
//            return eventReport;
//        }
//
//        public void setEventReport(String eventReport) {
//            this.eventReport = eventReport;
//        }
//
//        public int getEventStats() {
//            return eventStats;
//        }
//
//        public void setEventStats(int eventStats) {
//            this.eventStats = eventStats;
//        }
//
//        public String getEventType() {
//            return eventTypeName;
//        }
//
//        public void setEventType(String eventType) {
//            this.eventTypeName = eventType;
//        }
//
//        public EventUserBean getEventUser() {
//            return eventUser;
//        }
//
//        public void setEventUser(EventUserBean eventUser) {
//            this.eventUser = eventUser;
//        }
//
//        public List<ImgBean> getImg() {
//            return img;
//        }
//
//        public void setImg(List<ImgBean> img) {
//            this.img = img;
//        }
//
//        public List<VideoBean> getVideo() {
//            return video;
//        }
//
//        public void setVideo(List<VideoBean> video) {
//            this.video = video;
//        }
//
//        public static class EventUserBean {
//            /**
//             * affiliation : 警局
//             * name : 张三
//             * userId : 1
//             */
//
//            private String affiliation;
//            private String name;
//            private int userId;
//
//            public String getAffiliation() {
//                return affiliation;
//            }
//
//            public void setAffiliation(String affiliation) {
//                this.affiliation = affiliation;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public int getUserId() {
//                return userId;
//            }
//
//            public void setUserId(int userId) {
//                this.userId = userId;
//            }
//        }
//
//        public static class ImgBean {
//            /**
//             * documentId : 9
//             * documentType : 1
//             * url : http://doctor.nat100.top/asc-annex/annex/data/9
//             */
//
//            private int documentId;
//            private int documentType;
//            private String url;
//
//            public int getDocumentId() {
//                return documentId;
//            }
//
//            public void setDocumentId(int documentId) {
//                this.documentId = documentId;
//            }
//
//            public int getDocumentType() {
//                return documentType;
//            }
//
//            public void setDocumentType(int documentType) {
//                this.documentType = documentType;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//        }
//
//        public static class VideoBean {
//            /**
//             * documentId : 11
//             * documentType : 2
//             * url : http://doctor.nat100.top/asc-annex/annex/data/11
//             */
//
//            private int documentId;
//            private int documentType;
//            private String url;
//
//            public int getDocumentId() {
//                return documentId;
//            }
//
//            public void setDocumentId(int documentId) {
//                this.documentId = documentId;
//            }
//
//            public int getDocumentType() {
//                return documentType;
//            }
//
//            public void setDocumentType(int documentType) {
//                this.documentType = documentType;
//            }
//
//            public String getUrl() {
//                return url;
//            }
//
//            public void setUrl(String url) {
//                this.url = url;
//            }
//        }
//    }

}
