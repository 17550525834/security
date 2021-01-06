package com.zc.tarf530.view;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.tarf530.R;
import com.zc.tarf530.activity.EventInfoActivity;
import com.zc.tarf530.model.Event;

import zuo.biao.library.base.BaseView;


public class EventView extends BaseView<Event.ResBean.ListBean> implements View.OnClickListener {
    private static final String TAG = "EventView";
    public TextView tvEventTitle;
    public ImageView tvEventLevel;
    public TextView tvEventTime;
    public TextView tvEventType;
    public Button btnInfo;
    public LinearLayout ll_eventitem;
    public EventView(Activity context, ViewGroup parent) {
        super(context, R.layout.event_view, parent);
    }

    @Override
    public View createView() {
        tvEventTitle = findView(R.id.tvEventTitle, this);
        tvEventLevel = findView(R.id.ivEventLevel);
        tvEventTime = findView(R.id.tvEventTime, this);
        tvEventType = findView(R.id.tvEventType);
        btnInfo = findView(R.id.btnItemInfo,this);
        ll_eventitem = findView(R.id.ll_eventitem,this);
        return super.createView();
    }

    @Override
    public void bindView(Event.ResBean.ListBean data_) {
        super.bindView(data_);
        tvEventTitle.setText(data_.getEventName());
        tvEventTime.setText(data_.getEventOccur());
        tvEventType.setText(data_.getEventTypeName());
        switch (data_.getEventLevel()){
            case 1:
                tvEventLevel.setImageResource(R.drawable.level1);
                break;
            case 2:
                tvEventLevel.setImageResource(R.drawable.level2);
                break;
            case 3:
                tvEventLevel.setImageResource(R.drawable.level3);
                break;
            case 4:
                tvEventLevel.setImageResource(R.drawable.level4);
                break;
            default:
                break;
        }
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_eventitem:
                toActivity(EventInfoActivity.createIntent(context, data.getEventId(),false));
                break;
            default:
                break;
        }
    }
}
