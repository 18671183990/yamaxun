package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alan.yamaxun.R;
import com.alan.yamaxun.bean.Shoe;
import com.alan.yamaxun.db.DiscoverDao;
import com.alan.yamaxun.ui.activity.MainActivity;
import com.alan.yamaxun.ui.adapter.ZmiaoShaAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   DiscoverFragment
 * author:  Alan
 * time:    2016/7/31	12:21
 * desc:    TODO
 */
public class DiscoverFragment extends AppBaseFragment {
    @BindView(R.id.main_titlebar_nosearch_logo_iv)
    ImageView mTitlebarLogoIv;
    @BindView(R.id.main_titlebar_nosearch_gouwu_iv)
    ImageView mTitlebarGouwuIv;
    @BindView(R.id.main_titlebar_nosearch_gouwu_tv)
    TextView mTitlebarGouwuTv;
    //    @BindView(R.id.main_titlebar_nosearch_gouwuche_container)
//    RelativeLayout mTitlebarGouwucheContainer;
    @BindView(R.id.main_titlebar_nosearch_search_iv)
    ImageView mTitlebarSearchIv;
    @BindView(R.id.main_titlebar_progress_view)
    View mTitlebarProgressView;

    @BindView(R.id.discover_rv)
    RecyclerView mRecyclerView;

    CardView mCardView;

    private Context mContext;
    private MainActivity mMainActivity;

    @Override
    public View initToolBar() {
        return null;
    }

    @Override
    public View initContentView() {
        return null;
    }

    public DiscoverFragment() {
    }

    public DiscoverFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_discover_fragment_content, null, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        //从数据库获取数据
        DiscoverDao dao = new DiscoverDao(mContext);
        int dataCounts = dao.queryAll();
//        Toast.makeText(mContext, "总共有"+dataCounts+"件商品", Toast.LENGTH_SHORT).show();
        if (dataCounts != 10) {
            dao.insert10Datas();
        }
        final ArrayList<Shoe> shoes = dao.queryAll2();

        MyAdapter myAdapter = new MyAdapter(shoes);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                double price = shoes.get(position).getProductPrice();
                Toast.makeText(mContext, "商品的价格是：" + price + "元", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({R.id.main_titlebar_nosearch_logo_iv,
            R.id.main_titlebar_nosearch_gouwu_tv,
            R.id.main_titlebar_nosearch_gouwuche_container,
            R.id.main_titlebar_nosearch_search_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_nosearch_logo_iv:
                mMainActivity.goToHome();
                break;
            case R.id.main_titlebar_nosearch_gouwuche_container:
                mMainActivity.goGouWuCheActivity();
                break;
            case R.id.main_titlebar_nosearch_search_iv:
                mMainActivity.goSearchActivity();
                break;
        }
    }

    /**
     * 发现页面RecyclerView的Adapter
     */
    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

        interface OnItemClickListener {

            void onItemClick(View view, int position);
        }

        //回调接口
        OnItemClickListener mOnItemClickListener;
        //数据
        ArrayList<Shoe> mList;

        public MyAdapter(ArrayList<Shoe> mList) {
            this.mList = mList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.layout_discover_rv_item, null);
            ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(this);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Shoe shoe = mList.get(position);
            int productIcon = shoe.getProductIcon();
            holder.iv.setImageResource(productIcon);
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView iv;

            public ViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.imageView2);
            }

        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.mOnItemClickListener = listener;
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                //注意这里使用getTag方法获取position
                mOnItemClickListener.onItemClick(view, (int) view.getTag());
            }
        }

    }


}
