/*Copyright ©2015 TommyLemon(https://github.com/TommyLemon)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package com.zc.tarf530.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zuo.biao.library.interfaces.OnHttpResponseListener;
import zuo.biao.library.manager.HttpManager;

/**
 * HTTP请求工具类
 *
 * @author Lemon
 * @use 添加请求方法xxxMethod >> HttpRequest.xxxMethod(...)
 * @must 所有请求的url、请求方法(GET, POST等)、请求参数(key-value方式，必要key一定要加，没提供的key不要加，value要符合指定范围)
 * 都要符合后端给的接口文档
 */
public class HttpRequest {
    //	private static final String TAG = "HttpRequest";


    /**
     * 基础URL，这里服务器设置可切换
     */
//    public static final String URL_BASE = SettingUtil.getCurrentServerAddress();
//    public static final String URL_BASE = "http://10.10.3.11";
    public static final String URL_BASE = "http://10.100.128.98:9092";
    public static final String URL_TASK_BASE="http://10.100.128.98";
    public static final String PAGE_NUM = "pageNum";
    public static final String PAGE_SIZE = "pageSize";
    public static final String STATE = "eventStats";
    public static final String EVENT_USER = "eventUser";
    public static final String PWD = "pwd";
    public static final String USERCODE = "userCode";

    public static void login(final String userCode, final String pwd,
                             final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put(PWD, pwd);
        request.put(USERCODE, userCode);
        HttpManager.getInstance().post(request, URL_BASE + "/asc-mobile/user/login", requestCode, listener);
    }

    public static void loginRaw(final String userCode, final String pwd,
                                final int requestCode, final OnHttpResponseListener listener) {
        String json = "{\n" +
                " \"username\":\"" + userCode + "\",\n" +
                " \"password\":\"" + pwd + "\"\n" +
                " }";

//        HttpManager.getInstance().postRaw(json, "http://10.10.3.12/sso/do/rest2/api/sso/auth/login", requestCode, listener);
        HttpManager.getInstance().postRaw(json,"http://10.100.128.55:21602/api/v0.0/sys/user_login",requestCode,listener);

//        Map<String, Object> request = new HashMap<>();
//        request.put(PWD, pwd);
//        request.put(USERCODE, userCode);
//        HttpManager.getInstance().post(request, URL_BASE + "/asc-mobile/user/login", requestCode, listener);
    }

    public static void getEventList(final String userId, final int state,
                                    final int pageSize, final int pageIndex,
                                    final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put(PAGE_NUM, pageIndex);
        request.put(PAGE_SIZE, pageSize);
        request.put(STATE, state);
        request.put(EVENT_USER, userId);

        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/listMobile", requestCode, listener);
    }

    public static void upload(final String userId, List<String> files,
                              final int requestCode, final OnHttpResponseListener listener) throws IOException, JSONException {
        HttpManager.getInstance().postFiles(userId, URL_BASE + "/acs-event/annex/upload", files, requestCode,
                listener);

    }


    public static void report(final int eventType, final String eventAddr,
                              final int eventCasualties, final String eventDescription, int eventInvolve,
                              double eventLat, double eventLng, int eventLevel, String eventName,
                              String eventOccur, String eventReport, String img, String userId,
                              String video, String eventRegionId, String eventRegionName, String eventUserName,
                              final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("eventType", eventType);
        request.put("eventAddr", "南宁市园博园北门附近");
        request.put("eventCasualties", eventCasualties);
        request.put("eventDescription", eventDescription);
        request.put("eventInvolve", eventInvolve);
        request.put("eventLat", eventLat);
        request.put("eventLng", eventLng);
        request.put("eventLevel", eventLevel);
        request.put("eventName", eventName);
        request.put("eventOccur", eventOccur);
//        request.put("eventReport", eventReport);
        request.put("img", img);
        request.put("eventUser", ShareData.getShareStringData("id"));
        request.put("video", video);
        request.put("eventRegionId", "4501");
        request.put("eventRegionName", "南宁市");
//        request.put("eventUserName", ShareData.getShareStringData("name"));
        request.put("eventUserName", "颜开正");



        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/report", requestCode, listener);
    }

    public static void getEvent(final int id, final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
//        request.put("id", id);
        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/get/" + id, requestCode, listener);
    }

    public static void getDictionary(final int type, final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("type", type);
        HttpManager.getInstance().get(request, URL_BASE + "/asc-mobile/event/getDictionary", requestCode, listener);
    }

    public static void getEventLevel(final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/getEventLevel", requestCode, listener);
    }

    public static void getEventType(final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/getEventType", requestCode, listener);
    }

    public static void getEventUser(final String userId, final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("token", userId);
        HttpManager.getInstance().get(request, URL_BASE + "/asc-mobile/event/getEventUser", requestCode, listener);
    }

    public static void getimg(final int id, final int requestCode, final OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("id", id);
        HttpManager.getInstance().get(request, URL_BASE + "/asc-annex/annex/data/" + id, requestCode, listener);
    }

    public static void locationReport(String id, String type, double lat, double lng, int requestcode, OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("userId", id);
//        request.put("type", type);
        request.put("lat", lat);
        request.put("lng", lng);
//        HttpManager.getInstance().post(request, URL_BASE + "/acs-task/locus/reportLocus", requestcode, listener);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lat",lat);
            jsonObject.put("lng",lng);
            jsonObject.put("userId",id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpManager.getInstance().postRaw(jsonObject.toString(), URL_BASE + "/acs-task/locus/reportLocus", requestcode, listener);
    }

    public static void submit(int id, int requestcode, OnHttpResponseListener listener) {
        Map<String, Object> request = new HashMap<>();
        request.put("id", id);
        HttpManager.getInstance().post(request, URL_BASE + "/acs-event/event/submit", requestcode, listener);

    }

    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";


    //account>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


}