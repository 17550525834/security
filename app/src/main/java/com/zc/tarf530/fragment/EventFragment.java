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

package com.zc.tarf530.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zc.tarf530.R;
import com.zc.tarf530.activity.EventInfoActivity;
import com.zc.tarf530.adapter.EventAdapter;
import com.zc.tarf530.model.Event;
import com.zc.tarf530.util.HttpRequest;
import com.zc.tarf530.util.ShareData;
import com.zc.tarf530.view.EventView;

import java.util.List;

import zuo.biao.library.base.BaseHttpRecyclerFragment;
import zuo.biao.library.interfaces.AdapterCallBack;
import zuo.biao.library.interfaces.CacheCallBack;
import zuo.biao.library.ui.TopTabView;
import zuo.biao.library.util.JSON;

/**
 * 用户列表界面fragment
 *
 * @author Lemon
 * @use new UserListFragment(),详细使用见.DemoFragmentActivity(initData方法内)
 * @must 查看 .HttpManager 中的@must和@warn
 * 查看 .SettingUtil 中的@must和@warn
 */
public class EventFragment extends BaseHttpRecyclerFragment<Event.ResBean.ListBean, EventView, EventAdapter> implements CacheCallBack<Event.ResBean.ListBean> {

    //与Activity通信<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public static final String ARGUMENT_RANGE = "ARGUMENT_RANGE";
    public ViewGroup toptapcontainer;
    public TopTabView topTabView;
    public int state;//处置状态
    private int mpage, mpagesize;

    public static EventFragment createInstance(int position) {
        EventFragment fragment = new EventFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_RANGE, position);

        fragment.setArguments(bundle);
        return fragment;
    }

    private int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(zuo.biao.library.R.layout.base_http_recycler_fragment);
        argument = getArguments();
        if (argument != null) {
            position = argument.getInt(ARGUMENT_RANGE, position);
        }


        //功能归类分区方法，必须调用<<<<<<<<<<
        initView();
        initData();
        initEvent();
        //功能归类分区方法，必须调用>>>>>>>>>>

        srlBaseHttpRecycler.autoRefresh();

        return view;
    }


    //UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Override
    public void initView() {//必须调用
        super.initView();
        topTabView = new TopTabView(context);
        toptapcontainer = findView(R.id.toptapcontainer);
        toptapcontainer.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        toptapcontainer.addView(topTabView.createView(),params);
        topTabView.setCurrentPosition(position);
//        topTabView.bindView(new String[]{"未处置", "处置完成"});
        topTabView.bindView(new String[]{"待确认", "待处理","处理中","处理完成"});
        topTabView.setOnTabSelectedListener(new TopTabView.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TextView tvTab, int position, int id) {

                if (state != position) {
                    mpage = 0;
                    state = position;
                    srlBaseHttpRecycler.autoRefresh();
                }

            }
        });
        findView(R.id.btn_report).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EventInfoActivity.class).putExtra(INTENT_ID, -11).putExtra(INTENT_TYPE, true));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        topTabView.select(ShareData.getShareIntData("index"));
        ShareData.remove("index");
    }

    //    @Override
//    public void onLoadmore(RefreshLayout refreshlayout) {
//        super.onLoadmore(refreshlayout);
//        page++;
//    }

    @Override
    public void setList(final List<Event.ResBean.ListBean> list) {
        setList(new AdapterCallBack<EventAdapter>() {

            @Override
            public EventAdapter createAdapter() {
                return new EventAdapter(context);
            }

            @Override
            public void refreshAdapter() {
                adapter.refresh(list);
            }
        });
    }


    //UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //Data数据区(存在数据获取或处理代码，但不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Override
    public void initData() {//必须调用
        super.initData();
        state = 0;
        mpagesize = 5;

    }

    @Override
    public void getListAsync(final int page) {
        mpage = page;
//        HttpRequest.getEventList(ShareData.getShareIntData("id"), state, mpagesize, page, -page, this);
        HttpRequest.getEventList(ShareData.getShareStringData("id"), state, mpagesize, page, -page, this);
//		HttpRequest.getEventList(1, 0, 10, page, -page, new OnHttpResponseListener() {
//			@Override
//			public void onHttpResponse(int requestCode, String resultJson, Exception e) {
//				final Event event = JSON.parseObject(resultJson,Event.class);
//				setList(event.getRes().getList());
//
//
//			}
//		});
    }


    @Override
    public List<Event.ResBean.ListBean> parseArray(String json) {
        Event event = JSON.parseObject(json, Event.class);
//		Log.e("1",JSON.toJSONString(event.getRes()));
//		Log.e("2",JSON.toJSONString(event.getRes().getList()));
//		Log.e("3",JSON.toJSONString(event.getRes().getPage()));
        if (event == null || event.getCode() != 0)
            return null;
        if (mpage > event.getRes().getPage().getPageSize())
            return null;
        return JSON.parseArray(JSON.toJSONString(event.getRes().getList()), Event.ResBean.ListBean.class);
    }


    //Data数据区(存在数据获取或处理代码，但不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //Event事件区(只要存在事件监听代码就是)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    @Override
    public void initEvent() {//必须调用
        super.initEvent();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (id > 0) {
//            toActivity(EventInfoActivity.createIntent(context, id));
        }
    }

    @Override
    public Class<Event.ResBean.ListBean> getCacheClass() {
        return Event.ResBean.ListBean.class;
    }

    @Override
    public String getCacheGroup() {
        return "range=";
    }

    @Override
    public String getCacheId(Event.ResBean.ListBean data) {
        return data.getEventId() + "";
    }

    @Override
    public int getCacheCount() {
        return 10;
    }


    //生命周期、onActivityResult<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //生命周期、onActivityResult>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //Event事件区(只要存在事件监听代码就是)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //内部类,尽量少用<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //内部类,尽量少用>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


}