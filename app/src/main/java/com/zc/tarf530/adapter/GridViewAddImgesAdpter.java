package com.zc.tarf530.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zc.tarf530.R;
import com.zc.tarf530.activity.EventInfoActivity;

import java.io.File;
import java.util.List;

/**
 * com.bm.falvzixun.adapter.GridViewAddImgAdpter
 *
 * @author yuandl on 2015/12/24.
 *         添加上传图片适配器
 */
public class GridViewAddImgesAdpter extends BaseAdapter {
    private List<String> data;
    private Context context;
    private LayoutInflater inflater;
    private int mType;
    /**
     * 可以动态设置最多上传几张，之后就不显示+号了，用户也无法上传了
     * 默认9张
     */
    private int maxImages = 9;

    public GridViewAddImgesAdpter(List<String> data, Context context,int type) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mType = type;
    }

    public List<String> getData(){
        if(getCount()==1)
            return null;
        return data;
    }

    /**
     * 获取最大上传张数
     *
     * @return
     */
    public int getMaxImages() {
        return maxImages;
    }

    /**
     * 设置最大上传张数
     *
     * @param maxImages
     */
    public void setMaxImages(int maxImages) {
        this.maxImages = maxImages;
    }

    /**
     * 让GridView中的数据数目加1最后一个显示+号
     *
     * @return 返回GridView中的数量
     */
    @Override
    public int getCount() {
        int count = data == null ? 1 : data.size() + 1;
        if (count >= maxImages) {
            return data.size();
        } else {
            return count;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void notifyDataSetChanged(List<String> data) {
        this.data = data;
        this.notifyDataSetChanged();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_published_grida, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (data != null && position < data.size()) {

            if(data.get(position)!=null && data.get(position).contains("http")){
                Glide.with(context).load(data.get(position)).into(viewHolder.ivimage);
                viewHolder.btdel.setVisibility(View.GONE);
            }else {
                final File file = new File(data.get(position));
                Glide.with(context)
                        .load(file)
                        .into(viewHolder.ivimage);
                viewHolder.btdel.setVisibility(View.VISIBLE);
                viewHolder.btdel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (file.exists()) {
                            file.delete();
                        }
                        data.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }

        } else {
            viewHolder.ivimage.setScaleType(ImageView.ScaleType.FIT_XY);
            viewHolder.btdel.setVisibility(View.GONE);
            if(EventInfoActivity.mIsReport){
                if(mType==1){
                    Glide.with(context)
                            .load(R.mipmap.addimg)
                            .into(viewHolder.ivimage);
                }else {
                    Glide.with(context)
                            .load(R.mipmap.addvideo)
                            .into(viewHolder.ivimage);
                }

            }else {
                if(getData()!=null && getData().size()==position)
                    viewHolder.ivimage.setVisibility(View.INVISIBLE);

                //如果想不显示暂无图片的话 隐藏
                if(mType==1){
                    Glide.with(context)
                            .load(R.mipmap.noimg)
                            .into(viewHolder.ivimage);
                }else {
                    Glide.with(context)
                            .load(R.mipmap.novideo)
                            .into(viewHolder.ivimage);
                }

            }


        }

        return convertView;

    }

    public class ViewHolder {
        public final ImageView ivimage;
        public final Button btdel;
        public final View root;

        public ViewHolder(View root) {
            ivimage = (ImageView) root.findViewById(R.id.iv_image);
            btdel = (Button) root.findViewById(R.id.bt_del);
            this.root = root;
        }
    }
}
