package com.zc.tarf530.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;
import com.zc.tarf530.R;

import zuo.biao.library.base.BaseActivity;

public class PhotoActivity extends BaseActivity {
    private PhotoView photoView;
    private VideoView videoview;
    private int type;

    public static Intent createIntent(Context context, String url, int type) {
        return new Intent(context, PhotoActivity.class).putExtra(INTENT_ID, url).putExtra(INTENT_TYPE, type);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_photoinfo);
        initData();
        initView();
        initEvent();

    }

    @Override
    public void initView() {
        photoView = findView(R.id.photoinfo);
        videoview = findView(R.id.videoinfo);
        if (type == 1) {
            photoView.setVisibility(View.VISIBLE);
            videoview.setVisibility(View.GONE);
            Picasso.with(this)
                    .load(getIntent().getStringExtra(INTENT_ID))
                    .into(photoView);

        } else if(type==2){
            ((TextView)findView(R.id.tv_viewtitle)).setText("视频");
            photoView.setVisibility(View.GONE);
            videoview.setVisibility(View.VISIBLE);
            //设置视频控制器
            videoview.setMediaController(new MediaController(this));

            //播放完成回调
            videoview.setOnCompletionListener(new MyPlayerOnCompletionListener());

            //设置视频路径
            //videoView.setVideoURI(uri);
            videoview.setVideoPath(getIntent().getStringExtra(INTENT_ID));

            //开始播放视频
            videoview.start();
        }
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(context, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void initData() {
        type = getIntent().getIntExtra(INTENT_TYPE, -1);
    }

    @Override
    public void initEvent() {

    }
}
