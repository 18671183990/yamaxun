package com.alan.yamaxun.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan.yamaxun.R;
import com.alan.yamaxun.bean.Shoe;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.adapter
 * className:   HomeGridAdapter
 * author:  Alan
 * time:    2016/8/1	16:52
 * desc:    更多数据的Adapter
 */
public class HomeGridAdapter extends BaseAdapter {

    private ArrayList<Shoe> mList;
    private Context mContext;

    public HomeGridAdapter() {

    }

    public HomeGridAdapter(Context context, ArrayList<Shoe> list) {
        this.mList = list;
        this.mContext = context;
    }

    public void setData(ArrayList<Shoe> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_home_gridview_item, null);
            holder = new ViewHolder();
            holder.shopIcon = (ImageView) convertView.findViewById(R.id.home_grid_item_icon_iv);
            holder.shopDesc = (TextView) convertView.findViewById(R.id.home_grid_item_desc_tv);
            holder.shopPrice = (TextView) convertView.findViewById(R.id.home_grid_item_price_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Shoe shoe = mList.get(i);
        Glide.with(mContext).load(shoe.productIcon).placeholder(R.mipmap.app_icon).error(R.mipmap.app_icon).fitCenter().into(holder.shopIcon);
        holder.shopDesc.setText(shoe.productDesc);
        holder.shopPrice.setText("￥" + shoe.productPrice);
        return convertView;
    }

    private class ViewHolder {
        ImageView shopIcon;
        TextView shopDesc;
        TextView shopPrice;
    }
}
