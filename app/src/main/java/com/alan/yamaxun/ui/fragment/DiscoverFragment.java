package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alan.yamaxun.R;
import com.alan.yamaxun.ui.activity.MainActivity;

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
    @BindView(R.id.main_titlebar_nosearch_gouwuche_container)
    RelativeLayout mTitlebarGouwucheContainer;
    @BindView(R.id.main_titlebar_nosearch_search_iv)
    ImageView mTitlebarSearchIv;
    @BindView(R.id.main_titlebar_progress_view)
    View mTitlebarProgressView;

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

    @OnClick({R.id.main_titlebar_nosearch_logo_iv, R.id.main_titlebar_nosearch_gouwu_iv, R.id.main_titlebar_nosearch_gouwu_tv, R.id.main_titlebar_nosearch_gouwuche_container, R.id.main_titlebar_nosearch_search_iv, R.id.main_titlebar_progress_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_nosearch_logo_iv:
                mMainActivity.goToHome();
                break;
            case R.id.main_titlebar_nosearch_gouwu_iv:
                break;
            case R.id.main_titlebar_nosearch_gouwu_tv:
                break;
            case R.id.main_titlebar_nosearch_gouwuche_container:
                break;
            case R.id.main_titlebar_nosearch_search_iv:
                break;
            case R.id.main_titlebar_progress_view:
                break;
        }
    }

}
