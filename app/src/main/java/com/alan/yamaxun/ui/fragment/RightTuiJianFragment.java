package com.alan.yamaxun.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alan.yamaxun.R;
import com.alan.yamaxun.config.Constans;
import com.alan.yamaxun.ui.view.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   RightTuiJianFragment
 * author:  Alan
 * time:    2016/8/4	16:04
 * desc:    推荐模块的Fragment
 */
public class RightTuiJianFragment extends AppBaseFragment {
    @BindView(R.id.right_tuijian_item_listview)
    MyListView mTuijianItemListview;

    @Override
    public View initToolBar() {
        return null;
    }

    @Override
    public View initContentView() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.layout_category_fragment_right_tuijian, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initListView();
    }

    private void initListView() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Constans.fenlei.length; i++) {
            list.add(Constans.fenlei[i]);
        }
        MyAdapter adapter = new MyAdapter(list);
        mTuijianItemListview.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter {
        private ArrayList<String> mList;

        public MyAdapter(ArrayList<String> mList) {
            this.mList = mList;
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
                view = View.inflate(getContext(), R.layout.layout_category_fragment_right_tuijian_listview_item, null);
                holder = new ViewHolder();
                holder.title = (TextView) view.findViewById(R.id.right_tuijian_item_tv);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            String title = mList.get(i);
            holder.title.setText(title);
            return view;
        }

        private class ViewHolder {
            TextView title;
        }
    }
}
