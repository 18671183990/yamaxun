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
 * className:   MyFragment
 * author:  Alan
 * time:    2016/7/31	12:23
 * desc:    TODO
 */
public class MyFragment extends AppBaseFragment {

    @BindView(R.id.main_titlebar_nosearch_logo_iv)
    ImageView mTitlebarNosearchLogoIv;
    @BindView(R.id.main_titlebar_nosearch_gouwu_iv)
    ImageView mTitlebarNosearchGouwuIv;
    @BindView(R.id.main_titlebar_nosearch_gouwu_tv)
    TextView mTitlebarNosearchGouwuTv;
    @BindView(R.id.main_titlebar_nosearch_gouwuche_container)
    RelativeLayout mTitlebarNosearchGouwucheContainer;
    @BindView(R.id.main_titlebar_nosearch_search_iv)
    ImageView mTitlebarNosearchSearchIv;
    @BindView(R.id.main_titlebar_progress_view)
    View mTitlebarProgressView;
    @BindView(R.id.my_fragment_content_zhanghu_container)
    RelativeLayout mZhangHuContainer;
    @BindView(R.id.my_fragment_content_guojia_container)
    RelativeLayout mGuoJiaContainer;

    private Context mContext;
    private MainActivity mMainActivity;

    public MyFragment() {
    }

    public MyFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) context;

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
        View rootView = inflater.inflate(R.layout.layout_my_fragment_content, null, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.main_titlebar_nosearch_logo_iv, R.id.main_titlebar_nosearch_gouwu_iv, R.id.main_titlebar_nosearch_gouwuche_container, R.id.main_titlebar_nosearch_search_iv, R.id.my_fragment_content_zhanghu_container, R.id.my_fragment_content_guojia_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_nosearch_logo_iv:
                mMainActivity.goToHome();
                break;
            case R.id.main_titlebar_nosearch_gouwu_iv:
                break;
            case R.id.main_titlebar_nosearch_gouwuche_container:
                break;
            case R.id.main_titlebar_nosearch_search_iv:
                break;
        }
    }
}
