package com.alan.yamaxun.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alan.yamaxun.R;
import com.alan.yamaxun.bean.Shoe;
import com.alan.yamaxun.config.Constans;
import com.alan.yamaxun.ui.view.MyListView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   RightTuiJianFragment
 * author:  Alan
 * time:    2016/8/4	16:04
 * desc:    推荐模块的Fragment
 */
public class RightTuiJianFragment extends AppBaseFragment implements AdapterView.OnItemClickListener {

    @BindView(R.id.right_tuijian_item_listview)
    MyListView mTuijianItemListview;
    @BindView(R.id.tuijian_grad1_rv)
    RecyclerView mGradView1;
    private ArrayList<Shoe> mGradData1;


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
        //更新GradView1的数据
        mGradData1 = new ArrayList<>();
        for (int i = 0; i < Constans.gradImageData1.length; i++) {
            mGradData1.add(new Shoe(Constans.gradImageData1[i], "" + i, Constans.gradDescData1[i], i));
        }
        MyGradAdapter1 myGradAdapter1 = new MyGradAdapter1(mGradData1);
        mGradView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mGradView1.setAdapter(myGradAdapter1);


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Constans.fenlei.length; i++) {
            list.add(Constans.fenlei[i]);
        }
        MyAdapter adapter = new MyAdapter(list);
        mTuijianItemListview.setAdapter(adapter);
        mTuijianItemListview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getContext(),"position"+i+"被点击了",Toast.LENGTH_SHORT).show();
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

    class MyGradAdapter1 extends RecyclerView.Adapter<MyGradAdapter1.MyViewHolder> {

        private ArrayList<Shoe> mList;

        public MyGradAdapter1(ArrayList<Shoe> mGradData1) {
            this.mList = mGradData1;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getContext(), R.layout.layout_category_right_grad1_item, null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.iv.setImageResource(mList.get(position).getProductIcon());
            holder.tv.setText(mList.get(position).getProductDesc());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView iv;
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.tuijian_grad1_item_product_desc_iv);
                tv = itemView.findViewById(R.id.tuijian_grad1_item_product_desc_tv);
            }
        }
    }
}
