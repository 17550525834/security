package com.zc.tarf530.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lxj.matisse.CaptureMode;
import com.lxj.matisse.Matisse;
import com.lxj.matisse.MimeType;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zc.tarf530.R;
import com.zc.tarf530.adapter.GridViewAddImgesAdpter;
import com.zc.tarf530.model.EventInfo;
import com.zc.tarf530.model.EventUser;
import com.zc.tarf530.model.ReportResponse;
import com.zc.tarf530.model.SubmitResponse;
import com.zc.tarf530.model.UploadResponse;
import com.zc.tarf530.util.Constant;
import com.zc.tarf530.util.DateUtilNew;
import com.zc.tarf530.util.GPSHelper;
//import com.zc.tarf530.util.GifSizeFilter;
//import com.zc.tarf530.util.Glide4Engine;
import com.zc.tarf530.util.Glide4Engine;
import com.zc.tarf530.util.HttpRequest;
import com.zc.tarf530.util.ShareData;
import com.zc.tarf530.view.MyGridView;
//import com.zhihu.matisse.Matisse;
//import com.zhihu.matisse.MimeType;
//import com.zhihu.matisse.engine.impl.PicassoEngine;
//import com.zhihu.matisse.filter.Filter;
//import com.zhihu.matisse.internal.entity.CaptureStrategy;
//import com.zhihu.matisse.listener.OnCheckedListener;
//import com.zhihu.matisse.listener.OnSelectedListener;


import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.util.TimeUtils;
import zuo.biao.library.base.BaseActivity;
import zuo.biao.library.interfaces.OnHttpResponseListener;
import zuo.biao.library.model.Dictionary;
import zuo.biao.library.ui.DatePickerWindow;
import zuo.biao.library.ui.ItemDialog;
import zuo.biao.library.ui.TimePickerWindow;
import zuo.biao.library.util.CommonUtil;
import zuo.biao.library.util.JSON;
import zuo.biao.library.util.TimeUtil;

public class EventInfoActivity extends BaseActivity implements View.OnClickListener, OnHttpResponseListener, ItemDialog.OnDialogItemClickListener {
    public static Intent createIntent(Context context, int id, boolean isReport) {
        return new Intent(context, EventInfoActivity.class).putExtra(INTENT_ID, id).putExtra(INTENT_TYPE, isReport);
    }

    private int mEventId, mReportType, mReportLevel;
    public static boolean mIsReport;
    private EventInfo mEventInfo;
    private EventUser mEventUser;
    private UploadResponse mImgResponse, mVideoResponse;
    private ReportResponse mReportRes;
    private SubmitResponse submitResponse;
    private Dictionary mDic1, mDic2;
    private TextView mType, mLevel, mLoc, mEventTime, mEventInvolve, mEventCasualties, mRemark, mAffiliation, mUsername, mReportTime, mEventName;
    private EditText mEditeventInvolve, mEditeventCasualties, mEditRemark, mEtEventName;
    private Location mLocation;
    private TextView mSubmit;

    private MyGridView gw, gwvideo;
    private List<String> datas, datasvideo, dataall;
    private StringBuffer imgs, videos;
    private GridViewAddImgesAdpter gridViewAddImgesAdpter;
    private GridViewAddImgesAdpter gridViewAddVideosAdpter;
    private final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private final int REQUEST_CODE_CHOOSEVIDEO = 23;//matis video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_eventinfo);
        initView();
        initData();
        initEvent();

    }

    @Override
    public void initView() {
        mType = findView(R.id.tv_eventtype, this);
        mLevel = findView(R.id.tv_eventlevel, this);
        mLoc = findView(R.id.tv_eventlocation, this);
        mEventTime = findView(R.id.tv_eventtime, this);
        mEventTime.setOnClickListener(this);
//        mEventTime.setText(DateUtilNew.formatDate(System.currentTimeMillis(), DateUtilNew.ymdhms));
        mEventInvolve = findView(R.id.tv_eventhumens, this);
        mEventCasualties = findView(R.id.tv_eventhurt, this);
        mRemark = findView(R.id.tv_eventinfo, this);
        mAffiliation = findView(R.id.tv_affiliation, this);
        mUsername = findView(R.id.tv_username);
        mReportTime = findView(R.id.tv_reporttime);
        mEditeventInvolve = findView(R.id.et_eventhumens);
        mEditeventCasualties = findView(R.id.et_eventhurt);
        mEditRemark = findView(R.id.et_eventinfo);
        mEtEventName = findView(R.id.et_eventname);
        mEventName = findView(R.id.tv_eventname);
        mSubmit = findView(R.id.btn_submit);
        mSubmit.setOnClickListener(this);
        findView(R.id.btn_save, this);
        findView(R.id.btn_cancel, this);

        gw = findViewById(R.id.gw_event);
        gwvideo = findViewById(R.id.gw_eventvideo);
        datas = new ArrayList<>();
        datasvideo = new ArrayList<>();
        dataall = new ArrayList<>();
        imgs = new StringBuffer();
        videos = new StringBuffer();
        gridViewAddImgesAdpter = new GridViewAddImgesAdpter(datas, this, 1);
        gridViewAddVideosAdpter = new GridViewAddImgesAdpter(datasvideo, this, 2);
        gw.setAdapter(gridViewAddImgesAdpter);
        gwvideo.setAdapter(gridViewAddVideosAdpter);


    }

    @Override
    public void initData() {
        mLocation = GPSHelper.getInstance(this).getLastKnowLocation();
        mEventId = getIntent().getIntExtra(INTENT_ID, 0);
        mIsReport = getIntent().getBooleanExtra(INTENT_TYPE, false);
        if (mIsReport) {
            HttpRequest.getEventUser(ShareData.getShareStringData("token"), -1, this);
            HttpRequest.getEventType(-2, this);
            HttpRequest.getEventLevel(-3, this);
//            HttpRequest.getDictionary(1, -2, this);
//            HttpRequest.getDictionary(2, -3, this);
        } else {
            HttpRequest.getEvent(mEventId, -4, this);
            mSubmit.setVisibility(View.VISIBLE);




        }


    }

    @Override
    public void initEvent() {
        if (mIsReport) {
            RxPermissions rxPermissions = new RxPermissions(context);
            rxPermissions.requestEach(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(permission -> {
                        if (permission.granted) {
//                            Toast.makeText(context, "get", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (permission.shouldShowRequestPermissionRationale) {
                            Toast.makeText(context, "请开启权限！", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    });
            mEventInvolve.setVisibility(View.GONE);
            mEventCasualties.setVisibility(View.GONE);
            mEventName.setVisibility(View.GONE);
            mRemark.setVisibility(View.GONE);
            //点击事件坚挺
            gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Matisse.from(EventInfoActivity.this)
                            .choose(MimeType.ofImage()) //显示所有文件类型，比如图片和视频，
                            .imageEngine(new Glide4Engine())
                            .capture(true, CaptureMode.Image)//是否显示拍摄按钮，默认不显示
                            .forResult(PHOTO_REQUEST_GALLERY); //请求码
                }
            });
            gwvideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Matisse.from(EventInfoActivity.this)
                            .choose(MimeType.ofVideo()) //显示所有文件类型，比如图片和视频，
                            .imageEngine(new Glide4Engine())
                            .capture(true, CaptureMode.Video)//是否显示拍摄按钮，默认不显示
                            .forResult(REQUEST_CODE_CHOOSEVIDEO); //请求码


                }
            });
        } else {
            findView(R.id.tv_typerightarrow).setVisibility(View.INVISIBLE);
            findView(R.id.tv_leveltrightarrow).setVisibility(View.INVISIBLE);
            findView(R.id.tv_eventtimerightarrow).setVisibility(View.INVISIBLE);
            findView(R.id.ll_btn_report).setVisibility(View.GONE);
            mEditeventInvolve.setVisibility(View.GONE);
            mEditeventCasualties.setVisibility(View.GONE);
            findView(R.id.et_eventinfo).setVisibility(View.GONE);
            findView(R.id.et_eventname).setVisibility(View.GONE);
            mEventName.setVisibility(View.VISIBLE);
            gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (datas == null || datas.size() == 0) return;
                    if (datas != null && datas.size() > i) {
                        String url = datas.get(i);//示例，实际填你的网络视频链接
                        toActivity(PhotoActivity.createIntent(context, url, 1));
                    }
                }
            });
            gwvideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (datas == null || datas.size() == 0) return;
                    if (datas != null && datas.size() > i) {
                        String url = datasvideo.get(i);//示例，实际填你的网络视频链接
                        toActivity(PhotoActivity.createIntent(context, url, 2));
                    }
                }
            });


        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
//                finish();
                submit();
                break;
            case R.id.btn_save:
                report();
                break;
            case R.id.tv_eventtype:
                if (mIsReport) {
                    new ItemDialog(context, mDic1.getRes(), "选择事件类型", 1, this).show();
                }
                break;
            case R.id.tv_eventlevel:
                if (mIsReport) {
                    new ItemDialog(context, mDic2.getRes(), "选择事件级别", 2, this).show();
                }
                break;
            case R.id.tv_eventlocation:
                break;
            case R.id.tv_eventtime:
                if (mIsReport)
                    toActivity(DatePickerWindow.createIntent(context, new int[]{1971, 0, 1}
                            , TimeUtil.getDateDetail(System.currentTimeMillis())), REQUEST_TO_DATE_PICKER, false);
                break;
            case R.id.btn_submit:
                submit();
                break;

            default:
                break;
        }

    }

    @Override
    public void onHttpResponse(int requestCode, String resultJson, Exception e) {
        switch (requestCode) {
            case -1:
                mEventUser = new EventUser();
                EventUser.ResBean resBean = new EventUser.ResBean();
                resBean.setDirectOrgId("370911001001");
                resBean.setDirectOrgName("xuedongjigou");
                resBean.setUserName("xuedong");
                mEventUser.setRes(resBean);
//                mEventUser = JSON.parseObject(resultJson, EventUser.class);
//                mAffiliation.setText(mEventUser.getRes().getDirectOrgName());
//                mUsername.setText(mEventUser.getRes().getUserName());
//                mReportTime.setText(DateUtilNew.formatDate(System.currentTimeMillis(), DateUtilNew.ymdhms));

                break;
            case -2:
                mDic1 = JSON.parseObject(resultJson, Dictionary.class);
//                for (int i=0;i<mDic1.getRes().size();i++){
//                    types[i] = mDic1.getRes().get(i).getDictionaryName();
//                }
                break;
            case -3:
                mDic2 = JSON.parseObject(resultJson, Dictionary.class);
//                for (int i=0;i<mDic2.getRes().size();i++){
//                    levels[i] = mDic2.getRes().get(i).getDictionaryName();
//                }
                break;
            case -4:
                mEventInfo = JSON.parseObject(resultJson, EventInfo.class);
                if (mEventInfo == null || mEventInfo.getRes() == null) {
                    Toast.makeText(context, "数据查询失败，请重试", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }
                mType.setText(mEventInfo.getRes().getEventTypeName());
                mLevel.setText(mEventInfo.getRes().getEventLevelName());
                mEventTime.setText(mEventInfo.getRes().getEventOccur());
                mEventInvolve.setText(mEventInfo.getRes().getEventInvolve() + "人");
                mEventCasualties.setText(mEventInfo.getRes().getEventCasualties() + "人");
                mRemark.setText(mEventInfo.getRes().getEventDescription());
                mAffiliation.setText(mEventInfo.getRes().getEventRegionName());
                mUsername.setText(mEventInfo.getRes().getEventUserName());
                mReportTime.setText(mEventInfo.getRes().getEventReport());
                mLoc.setText(mEventInfo.getRes().getEventLat() + mEventInfo.getRes().getEventLng() + "");
                mEventName.setText(mEventInfo.getRes().getEventName());
                showImages(mEventInfo);
                showVideos(mEventInfo);

                break;
            case -5://upload img
                if (resultJson == null) {
                    Toast.makeText(context, "文件上传失败，请检查网络！", Toast.LENGTH_SHORT).show();
                    return;
                }
                mImgResponse = JSON.parseObject(resultJson, UploadResponse.class);
                if (mImgResponse != null && mImgResponse.getRes() != null && mImgResponse.getRes().size() > 0) {
                    for (int i = 0; i < mImgResponse.getRes().size(); i++) {
                        if (mImgResponse.getRes().get(i).getDocumentType() == 1)
                            imgs.append(mImgResponse.getRes().get(i).getDocumentId() + ",");
                        else
                            videos.append(mImgResponse.getRes().get(i).getDocumentId() + ",");
                    }
                }
                dismissProgressDialog();
                if (imgs.toString().equals("") && videos.toString().equals("")) {
                    Toast.makeText(context, "资源解析失败，请重试！", Toast.LENGTH_SHORT).show();
                } else {
//                    HttpRequest.report(mReportType, "石家庄", Integer.parseInt(mEditeventCasualties.getText().toString()),
//                            mEditRemark.getText().toString(), Integer.parseInt(mEditeventInvolve.getText().toString()),
//                            mLocation != null ? mLocation.getLatitude() : 11.11, mLocation != null ? mLocation.getLongitude() : 11.11,
//                            mReportLevel, mEtEventName.getText().toString(), mEventTime.getText().toString(),
//                            mReportTime.getText().toString(), imgs.toString(), ShareData.getShareIntData("id"), videos.toString(), mEventUser.getRes().getDirectOrgId() + "", mEventUser.getRes().getDirectOrgName(), mEventUser.getRes().getUserName(), -7, this);
                    HttpRequest.report(mReportType, "石家庄", Integer.parseInt(mEditeventCasualties.getText().toString()),
                            mEditRemark.getText().toString(), Integer.parseInt(mEditeventInvolve.getText().toString()),
                            mLocation != null ? mLocation.getLatitude() : 11.11, mLocation != null ? mLocation.getLongitude() : 11.11,
                            mReportLevel, mEtEventName.getText().toString(), mEventTime.getText().toString(),
                            mReportTime.getText().toString(), imgs.toString(), ShareData.getShareStringData("id"), videos.toString(), mEventUser.getRes().getDirectOrgId() + "", mEventUser.getRes().getDirectOrgName(), mEventUser.getRes().getUserName(), -7, this);
                }


                break;
            case -6://uploadvideo
                break;
            case -7://report
                dismissProgressDialog();
                mReportRes = JSON.parseObject(resultJson, ReportResponse.class);
                if (mReportRes != null && mReportRes.getCode() == 0) {
                    Toast.makeText(context, mReportRes.getMsg(), Toast.LENGTH_SHORT).show();
                    findView(R.id.btn_save).setEnabled(false);
                    mEventId = mReportRes.getRes();
                    ShareData.setShareIntData("index",0);
//                    finish();
                } else {
                    Toast.makeText(context, "上报失败，请重试", Toast.LENGTH_SHORT).show();
                }
                Log.e("report", "上报结果" + resultJson);
                break;
            case -8:
                dismissProgressDialog();
                submitResponse = JSON.parseObject(resultJson, SubmitResponse.class);
                if (submitResponse != null && submitResponse.getCode() == 0) {
                    ShareData.setShareIntData("index",1);
                    Toast.makeText(context, submitResponse.getMsg(), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(context, "提交事件失败，请重试", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }


    }

    @Override
    public void onDialogItemClick(int requestCode, int position, String item) {
        if (position < 0) {
            position = 0;
        }
        switch (requestCode) {
            case 1:
                mType.setText(mDic1.getRes().get(position).getDictionaryName());
                mReportType = Integer.parseInt(mDic1.getRes().get(position).getDictionaryCode());
                break;
            case 2:
                mLevel.setText(mDic2.getRes().get(position).getDictionaryName());
                mReportLevel = Integer.parseInt(mDic2.getRes().get(position).getDictionaryCode());
                break;
            default:
                break;
        }
    }
    private static final int REQUEST_TO_DATE_PICKER = 33;
    private static final int REQUEST_TO_TIME_PICKER = 34;
    private int[] selectedDate = new int[]{1971, 0, 1};
    private int[] selectedTime = new int[]{12, 0, 0};

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case REQUEST_TO_DATE_PICKER:
                if (data != null) {
                    ArrayList<Integer> list = data.getIntegerArrayListExtra(DatePickerWindow.RESULT_DATE_DETAIL_LIST);
                    if (list != null && list.size() >= 3) {
                        selectedDate = new int[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            selectedDate[i] = list.get(i);
                        }
                        showShortToast("选择的日期为" + selectedDate[0] + "-" + (selectedDate[1] + 1) + "-" + selectedDate[2]);
                        toActivity(TimePickerWindow.createIntent(context), REQUEST_TO_TIME_PICKER, false);
                    }
                }
                break;
            case REQUEST_TO_TIME_PICKER:
                if (data != null) {
                    ArrayList<Integer> list = data.getIntegerArrayListExtra(TimePickerWindow.RESULT_TIME_DETAIL_LIST);
                    if (list != null && list.size() >= 2) {

                        selectedTime = new int[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            selectedTime[i] = list.get(i);
                        }
                        String minute = "" + selectedTime[1];
                        if (minute.length() < 2) {
                            minute = "0" + minute;
                        }
                        showShortToast("选择的时间为" + selectedTime[0] + ":" + minute);
                        mEventTime.setText(selectedDate[0] + "-" + (selectedDate[1] + 1) + "-" + selectedDate[2] + " " + (selectedTime[0] < 10 ? "0" + selectedTime[0] : selectedTime[0]) + ":" + minute + ":00");
                    }
                }
                break;
            case PHOTO_REQUEST_GALLERY:
                // 从相册返回的数据
                if (data != null) {
                    List<String> datas = new ArrayList<>();
                    if (Matisse.obtainSelectPathResult(data) == null) {
                        datas.add(Matisse.obtainCaptureImageResult(data));
                    } else
                        datas = Matisse.obtainSelectPathResult(data);
                    for (String path : datas) {
                        photoPath(path);
                    }
                }
                break;
            case REQUEST_CODE_CHOOSEVIDEO:
                if (data != null) {
                    List<String> datas = new ArrayList<>();
                    Matisse.obtainSelectPathResult(data);
                    if (Matisse.obtainSelectPathResult(data) == null) {
                        datas.add(Matisse.obtainCaptureVideoResult(data));
                    } else
                        datas = Matisse.obtainSelectPathResult(data);
                    for (String path : datas) {
                        videoPath(path);
                    }
                }

                break;
        }
    }


    public void photoPath(String path) {
        datas.add(path);
        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    public void videoPath(String path) {
        datasvideo.add(path);
        gridViewAddVideosAdpter.notifyDataSetChanged();
    }

    public void showImages(EventInfo eventInfo) {
        if (eventInfo != null && eventInfo.getRes() != null && eventInfo.getRes().getImg() != null && eventInfo.getRes().getImg().size() > 0) {
            List<EventInfo.ResBean.ImgBean> list = eventInfo.getRes().getImg();
            for (EventInfo.ResBean.ImgBean bean : list) {
                datas.add(HttpRequest.URL_BASE + "/acs-event/annex/data/" + bean.getDocumentId());
            }
            gridViewAddImgesAdpter.notifyDataSetChanged(datas);
        }
    }

    public void showVideos(EventInfo eventInfo) {
        if (eventInfo != null && eventInfo.getRes() != null && eventInfo.getRes().getVideo() != null && eventInfo.getRes().getVideo().size() > 0) {
            List<EventInfo.ResBean.VideoBean> list = eventInfo.getRes().getVideo();
            for (EventInfo.ResBean.VideoBean bean : list) {
                datasvideo.add(HttpRequest.URL_BASE + "/acs-event/annex/data/" + bean.getDocumentId());
            }
            gridViewAddVideosAdpter.notifyDataSetChanged(datasvideo);
        }
    }

    public void report() {
        if (dataall != null)
            dataall.clear();
        if (TextUtils.equals(mType.getText().toString(), "点击选择")) {
            Toast.makeText(context, "请选择事件类型后重试", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.equals(mLevel.getText().toString(), "点击选择")) {
            Toast.makeText(context, "请选择事件级别后重试", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.equals(mEventTime.getText().toString(), "点击选择")) {
            Toast.makeText(context, "请选择事件时间后重试", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.equals(mEditeventInvolve.getText().toString(), "")) {
            Toast.makeText(context, "请输入涉及人数", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.equals(mEditeventCasualties.getText().toString(), "")) {
            Toast.makeText(context, "请输入伤亡人数", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEditRemark.getText().toString().equals("")) {
            Toast.makeText(context, "请输入事件说明", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEtEventName.getText().toString().equals("")) {
            Toast.makeText(context, "请输入事件名称", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("请稍候...");
        if (gridViewAddImgesAdpter.getData() != null) {
            showProgressDialog("请稍候...", "资源上传中....");
            dataall.addAll(gridViewAddImgesAdpter.getData());
        }
        if (gridViewAddVideosAdpter.getData() != null) {
            dataall.addAll(gridViewAddVideosAdpter.getData());

        }

        if (dataall != null && dataall.size() > 0) {
            try {
                HttpRequest.upload(ShareData.getShareStringData("id"), dataall, -5, this);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            HttpRequest.report(mReportType, "石家庄", Integer.parseInt(mEditeventCasualties.getText().toString()),
                    mEditRemark.getText().toString(), Integer.parseInt(mEditeventInvolve.getText().toString()),
                    mLocation != null ? mLocation.getLatitude() : 11.11, mLocation != null ? mLocation.getLongitude() : 11.11,
                    mReportLevel, mEtEventName.getText().toString(), mEventTime.getText().toString(),
                    mReportTime.getText().toString(), null, ShareData.getShareStringData("id"), null,
                    mEventUser.getRes().getDirectOrgId() + "", mEventUser.getRes().getDirectOrgName(), mEventUser.getRes().getUserName(), -7, this);
        }


    }
    private void submit(){
        if(mEventId<=0){
            Toast.makeText(context, "暂未上传事件成功，请重试", Toast.LENGTH_SHORT).show();
            return;
        }
        showProgressDialog("请稍候...");
        HttpRequest.submit(mEventId,-8,this);
    }
}
