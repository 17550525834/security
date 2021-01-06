package com.zc.tarf530.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cjt2325.cameralibrary.util.LogUtil;
import com.zc.tarf530.R;
import com.zc.tarf530.model.LoginRawResponse;
import com.zc.tarf530.model.LoginResponse;
import com.zc.tarf530.util.HttpRequest;
import com.zc.tarf530.util.ShareData;

import zuo.biao.library.interfaces.OnHttpResponseListener;
import zuo.biao.library.model.Dictionary;
import zuo.biao.library.util.JSON;

public class LoginActivity extends Activity implements OnHttpResponseListener {
    EditText editTextUser, editPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
//        ShareData.setShareStringData("token",0+"");
//        ShareData.setShareIntData("id",452);
//        startActivity(MainTabActivity.createIntent(this).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//        finish();
        editTextUser = findViewById(R.id.et_username);
        editPwd = findViewById(R.id.et_pwd);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextUser.getText().toString().trim()) || TextUtils.isEmpty(editPwd.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请正确输入用户名或密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpRequest.loginRaw(editTextUser.getText().toString().trim(), editPwd.getText().toString().trim(), -1, LoginActivity.this);
//                HttpRequest.login(editTextUser.getText().toString().trim(),editPwd.getText().toString().trim(),-1,LoginActivity.this);

            }
        });

    }

    @Override
    public void onHttpResponse(int requestCode, String resultJson, Exception e) {
        if (requestCode == -1) {
            LogUtil.e(resultJson);
//            LoginResponse loginResponse =  JSON.parseObject(resultJson, LoginResponse.class);
//            if(loginResponse!=null && loginResponse.getAuthCode()!=null && loginResponse.getId()>0){
//                ShareData.setShareStringData("token",loginResponse.getAuthCode());
//                ShareData.setShareIntData("id",loginResponse.getId());
//                startActivity(MainTabActivity.createIntent(this).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//                finish();
//
//            }else {
//                Toast.makeText(this,"登录失败！",Toast.LENGTH_LONG);
//            }
            LoginRawResponse rawResponse = JSON.parseObject(resultJson, LoginRawResponse.class);
            if (rawResponse != null) {
                ShareData.setShareStringData("token",rawResponse.getData().getToken());
//                ShareData.setShareIntData("id",123);
                ShareData.setShareStringData("id",rawResponse.getData().getUser_id());
                ShareData.setShareStringData("regionId",rawResponse.getData().getRegion_id());
                ShareData.setShareStringData("name",rawResponse.getData().getName());


                startActivity(MainTabActivity.createIntent(this).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            } else {
                Toast.makeText(this, "登录失败！"+rawResponse!=null?rawResponse.getMessage():"", Toast.LENGTH_LONG);

            }
        }

    }
}
