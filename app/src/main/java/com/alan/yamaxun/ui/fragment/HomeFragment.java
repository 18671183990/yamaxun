package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alan.yamaxun.R;
import com.alan.yamaxun.bean.Shoe;
import com.alan.yamaxun.config.Constans;
import com.alan.yamaxun.ui.activity.MainActivity;
import com.alan.yamaxun.ui.adapter.HomeGridAdapter;
import com.alan.yamaxun.ui.view.MyGridView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   HomeFragment
 * author:  Alan
 * time:    2016/7/30	23:57
 * desc:    TODO
 */
public class HomeFragment extends AppBaseFragment implements Animation.AnimationListener, BGABanner.OnItemClickListener, BGABanner.Adapter, AdapterView.OnItemClickListener {

    @BindView(R.id.main_titlebar_logo_iv)
    ImageView mTitlebarLogoIv;
    @BindView(R.id.main_titlebar_camera_iv)
    ImageView mTitlebarCameraIv;
    @BindView(R.id.main_titlebar_gouwu_tv)
    ImageView mTitlebarGouwuTv;
    @BindView(R.id.main_titlebar_progress_view)
    View mProgressView;
    @BindView(R.id.main_titlebar_search_container)
    RelativeLayout mSearchContainer;
    @BindView(R.id.banner_main_cube)
    BGABanner mCubeBanner;
    @BindView(R.id.home_content__more_product_gridview)
    MyGridView mMoreGridView;


    private Context mContext;
    private MainActivity mMainActivity;

    public HomeFragment() {
    }

    public HomeFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) mContext;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_home_fragment_container, null, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

        initEvent();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        initBanner();


        initMoreProduct();
    }

    private void initEvent() {
        mCubeBanner.setOnItemClickListener(this);
    }

    /**
     * 初始化轮播图数据
     */
    private void initBanner() {
        //此部分是假数据,实际情况需要从网络获取图片//TODO:
        List<View> mBannerList = new ArrayList<>();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int pic : Constans.bannerPics) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(pic);
            mBannerList.add(imageView);
        }
        mCubeBanner.setAdapter(this);
        mCubeBanner.setData(mBannerList);
    }

    /**
     * 初始化更多商品数据
     */
    private void initMoreProduct() {
        ArrayList<Shoe> list = new ArrayList<>();
        for (int i = 0; i < Constans.shoesIcons.length; i++) {
            Shoe shoe = new Shoe(Constans.shoesIcons[i], null, Constans.shoesDescs[i], Constans.shoesPrices[i]);
            list.add(shoe);
        }
        HomeGridAdapter homeGridAdapter = new HomeGridAdapter(mContext, list);
        mMoreGridView.setAdapter(homeGridAdapter);
        mMoreGridView.setOnItemClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        playLoadDataAnimation();
    }

    /**
     * 播放进度条动画
     */
    public void playLoadDataAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.titlebar_progress_translate_animation);
        animation.setAnimationListener(this);
        mProgressView.startAnimation(animation);
    }


    @Override
    public View initToolBar() {
        return null;
    }

    @Override
    public View initContentView() {
        return null;
    }


    @OnClick(
            {R.id.main_titlebar_logo_iv,
                    R.id.main_titlebar_camera_iv,
                    R.id.main_titlebar_gouwu_tv,
                    R.id.main_titlebar_search_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_logo_iv:
                break;
            case R.id.main_titlebar_camera_iv:
                break;
            case R.id.main_titlebar_gouwu_tv:
                break;
            case R.id.main_titlebar_search_container:
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mProgressView.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /**
     * Banner中的item被点击时的回调
     *
     * @param banner   被点击的Banner
     * @param view     被点击的View
     * @param model    被点击view的数据
     * @param position 被点击的postiton
     */
    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        switch (position) {
            case 0:
                Log.d(TAG, "梦想家");
                break;
            case 1:
                Log.d(TAG, "女神");
                break;
            case 2:
                Log.d(TAG, "神经病");
                break;
        }
    }

    /**
     * 该方法是BGABanner Adapter接口中的方法
     *
     * @param banner   当前Banner
     * @param view     当前的容器对象
     * @param model    数据
     * @param position 当前是第几个
     */
    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        ArrayList<View> list = (ArrayList<View>) model;
        if (list == null) return;
        Glide.with(this)
                .load(list.get(position))
                .placeholder(R.mipmap.holder)
                .error(R.mipmap.holder)
                .into((ImageView) view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
