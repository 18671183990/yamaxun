package com.alan.yamaxun.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alan.yamaxun.R;

import java.util.ArrayList;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.adapter
 * className:   CategoryLeftAdapter
 * author:  Alan
 * time:    2016/8/3	20:21
 * desc:    TODO
 */
public class CategoryLeftAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> mList;

    public CategoryLeftAdapter() {

    }


    public CategoryLeftAdapter(Context context, ArrayList<String> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    public void setData(ArrayList<String> list) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.layout_category_left_lv_item, null);
            holder = new ViewHolder();
            holder.type = (TextView) view.findViewById(R.id.category_left_item_tv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String title = mList.get(i);
        holder.type.setText(title);
        return view;
    }

    private class ViewHolder {
        TextView type;
    }
}
