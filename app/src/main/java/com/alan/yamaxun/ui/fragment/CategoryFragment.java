package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * className:   CategoryFragment
 * author:  Alan
 * time:    2016/7/31	11:45
 * desc:    TODO
 */
public class CategoryFragment extends AppBaseFragment {
    @BindView(R.id.main_titlebar_logo_iv)
    ImageView mTitlebarLogoIv;
    @BindView(R.id.main_titlebar_search_iv)
    ImageView mTitlebarSearchIv;
    @BindView(R.id.main_titlebar_camera_iv)
    ImageView mTitlebarCameraIv;
    @BindView(R.id.main_titlebar_search_container)
    RelativeLayout mTitlebarSearchContainer;
    @BindView(R.id.main_titlebar_gouwu_tv)
    ImageView mTitlebarGouwuTv;
    @BindView(R.id.main_titlebar_progress_view)
    View mTitlebarProgressView;

    private Context mContext;
    private MainActivity mMainActivity;

    public CategoryFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) mContext;
    }

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
        View rootView = inflater.inflate(R.layout.layout_category_fragment_content, null, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.main_titlebar_logo_iv, R.id.main_titlebar_camera_iv, R.id.main_titlebar_search_container, R.id.main_titlebar_gouwu_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_logo_iv:
                mMainActivity.goToHome();
                break;
            case R.id.main_titlebar_search_iv:
                break;
            case R.id.main_titlebar_camera_iv:
                break;
            case R.id.main_titlebar_search_container:
                break;
            case R.id.main_titlebar_gouwu_tv:
                break;
        }
    }

}
