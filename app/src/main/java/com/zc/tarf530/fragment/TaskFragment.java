package com.zc.tarf530.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.zc.tarf530.R;
import com.zc.tarf530.app.RFApplication;
import com.zc.tarf530.util.HttpRequest;
import com.zc.tarf530.util.ShareData;

import androidx.annotation.Nullable;
import zuo.biao.library.base.BaseFragment;
import zuo.biao.library.interfaces.OnHttpResponseListener;
import zuo.biao.library.ui.WebViewActivity;
import zuo.biao.library.util.Log;
import zuo.biao.library.util.StringUtil;

import static com.zc.tarf530.util.HttpRequest.URL_TASK_BASE;

public class TaskFragment extends BaseFragment {
    private WebView mWebview;
    private WebSettings mWebSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fg_webview);
        initView();
        initData();
        initEvent();
        return view;

    }

    @Override
    public void initView() {
        findView(R.id.iv_call).setOnClickListener(view1 -> RFApplication.callApk());
        mWebview = findView(R.id.wvWebView);
        mWebSettings = mWebview.getSettings();
        mWebSettings.setAppCacheMaxSize(10 * 1024 * 1024); // 10MB
        mWebSettings.setAppCachePath(getActivity().getCacheDir().getAbsolutePath());
        mWebSettings.setAllowFileAccess(true);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebSettings.setDomStorageEnabled(true);

        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.e("taskwebviewoverride",view.getUrl());

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.e("taskwebviewstart",url);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.e("taskwebviewfinish",url);
                if(!url.contains("auth/task") && !url.contains("/404")){
                    toActivity(WebViewActivity.createIntent(context,"",url));
                    view.goBack();
                }
            }
        });
        mWebview.loadUrl( URL_TASK_BASE +"/taskApp/dist/index.html#/auth/task?id="+ShareData.getShareStringData("id"));
        HttpRequest.locationReport(ShareData.getShareStringData("id"), 0 + "", 11.11111, 11.111111, -100, new OnHttpResponseListener() {
            @Override
            public void onHttpResponse(int requestCode, String resultJson, Exception e) {
                android.util.Log.e("GPSHELPER",resultJson+"");
//                Toast.makeText(mContext,resultJson,Toast.LENGTH_SHORT).show();
            }
        });
//        mWebview.loadUrl( "http://10.10.3.11/task/#/auth/task");//

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    /**
     * 创建一个Fragment实例
     *
     * @return
     */
    public static TaskFragment createInstance() {
        return new TaskFragment();
    }
}
