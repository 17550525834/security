package com.zc.tarf530.app;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.zc.tarf530.util.Constant;
import com.zc.tarf530.util.CrashHandler;
import com.zc.tarf530.util.GPSHelper;
import com.zc.tarf530.util.ShareData;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import zuo.biao.library.base.BaseApplication;

public class RFApplication extends BaseApplication {
    private static final String TAG = "RFApplication";

    private static RFApplication context;
    public static RFApplication getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        BaseApplication.init(this);
        ShareData.init(this);
//        CrashHandler.getInstance().init(this);




    }

    public static void callApk(){
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage("cn.showclear.siptalk");
            context.startActivity(intent);
        }catch (Exception e){
            Toast.makeText(context, "未安装相应的APP", Toast.LENGTH_SHORT).show();
        }
    }

}
