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

import com.zc.tarf530.R;
import com.zc.tarf530.app.RFApplication;

import androidx.annotation.Nullable;
import zuo.biao.library.base.BaseFragment;

import static com.zc.tarf530.util.HttpRequest.URL_BASE;

public class MapFragment extends BaseFragment {
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
                mWebview.loadUrl(view.getUrl());
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        mWebview.loadUrl("http://10.100.128.98/taskApp/dist/index.html#/auth/peripheralQuery");
//        mWebview.loadUrl( "http://10.10.3.11/task/#/auth/peripheralQuery");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
    /**创建一个Fragment实例
     * @return
     */
    public static MapFragment createInstance() {
        return new MapFragment();
    }
}
