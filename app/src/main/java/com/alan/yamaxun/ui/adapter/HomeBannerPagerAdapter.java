package com.alan.yamaxun.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.adapter
 * className:   HomeBannerPagerAdapter
 * author:  Alan
 * time:    2016/7/31	21:01
 * desc:    TODO
 */
public class HomeBannerPagerAdapter extends PagerAdapter {

    private ArrayList<ImageView> mList;

    public HomeBannerPagerAdapter(ArrayList<ImageView> list) {
        this.mList = list;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mList == null) {
            return null;
        }
        ImageView imageView = mList.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
