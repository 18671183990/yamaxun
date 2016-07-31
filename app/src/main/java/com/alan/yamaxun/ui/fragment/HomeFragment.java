package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alan.yamaxun.R;
import com.alan.yamaxun.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   HomeFragment
 * author:  Alan
 * time:    2016/7/30	23:57
 * desc:    TODO
 */
public class HomeFragment extends AppBaseFragment implements Animation.AnimationListener {

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

    private Context mContext;
    private MainActivity mMainActivity;



    public HomeFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) mContext;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_home_fragment_content, null, false);
        ButterKnife.bind(this, rootView);
        return rootView;
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


    @OnClick({R.id.main_titlebar_logo_iv, R.id.main_titlebar_camera_iv, R.id.main_titlebar_gouwu_tv, R.id.main_titlebar_search_container})
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
}
