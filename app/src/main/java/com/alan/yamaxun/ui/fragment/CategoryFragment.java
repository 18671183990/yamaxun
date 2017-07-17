package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alan.yamaxun.R;
import com.alan.yamaxun.config.Constans;
import com.alan.yamaxun.ui.activity.MainActivity;
import com.alan.yamaxun.ui.adapter.CategoryLeftAdapter;

import java.util.ArrayList;
import java.util.Random;

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
public class CategoryFragment extends AppBaseFragment implements AdapterView.OnItemClickListener {
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
    @BindView(R.id.category_fragment_drag_listview)
    ListView mDragListView;
    @BindView(R.id.main_titlebar_search_tv)
    TextView mainTitlebarSearchTv;
    @BindView(R.id.main_titlebar_linearlayout)
    LinearLayout mainTitlebarLinearlayout;
    @BindView(R.id.main_titlebar_divider_view)
    View mainTitlebarDividerView;
    @BindView(R.id.titlebar_withsearch)
    RelativeLayout titlebarWithsearch;

    private Context mContext;
    private MainActivity mMainActivity;
    private FragmentManager mFragmentManager;
    private CategoryLeftAdapter mLeftAdapter;   //左侧列表部分Adapter
    private ArrayList<Fragment> mFragmentList;  //Fragment列表集合

    public CategoryFragment() {
    }

    public CategoryFragment(Context context) {
        this.mContext = context;
        this.mMainActivity = (MainActivity) mContext;
        this.mFragmentManager = mMainActivity.getAppFragmentManager();
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

    @OnClick({R.id.main_titlebar_logo_iv, R.id.main_titlebar_camera_iv, R.id.main_titlebar_search_container, R.id.main_titlebar_gouwuche_container})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_logo_iv:
                mMainActivity.goToHome();
                break;
            case R.id.main_titlebar_camera_iv:
                mMainActivity.goScanActivity();
                break;
            case R.id.main_titlebar_search_container:
                //HomeFragment里已经有去搜索界面的方法，本想拿到HomeFragment的实例，但之前没有为Fragment设置Id所以方法暂时不可行，只能再写一次
                //将方法写在MainActivity中，Fragment可以拿到MainActivity的实例，所以四个Fragment都可以调用那几个方法
                mMainActivity.goSearchActivity();
                break;
            case R.id.main_titlebar_gouwuche_container:
                mMainActivity.goGouWuCheActivity();
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initLeft();
        initAllFragment();
    }

    /**
     * 初始化左侧列表
     */
    private void initLeft() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Constans.categoryLeftData.length; i++) {
            list.add(Constans.categoryLeftData[i]);
        }
        mLeftAdapter = new CategoryLeftAdapter(mContext, list);
        mDragListView.setAdapter(mLeftAdapter);
        mDragListView.setVerticalScrollBarEnabled(false);       //隐藏ListView的Indicator
        mDragListView.setOnItemClickListener(this);
        mDragListView.setItemChecked(0, true);
    }

    /**
     * 初始化所有的Fragment
     */
    private void initAllFragment() {

        mFragmentList = new ArrayList<>();
        RightTuiJianFragment tuiJianFragment = new RightTuiJianFragment();
        RightKindleFragment kindleFragment = new RightKindleFragment();
        RightHaiWaiGouFragment haiWaiGouFragment = new RightHaiWaiGouFragment();
        RightTuShuFragment tuShuFragment = new RightTuShuFragment();
        RightPhoneFragment phoneFragment = new RightPhoneFragment();
        RightComputerFragment computerFragment = new RightComputerFragment();
        RightFuShiFragment fuShiFragment = new RightFuShiFragment();
        RightMuYingFragment muYingFragment = new RightMuYingFragment();
        RightSupportFragment supportFragment = new RightSupportFragment();
        mFragmentList.add(tuiJianFragment);
        mFragmentList.add(kindleFragment);
        mFragmentList.add(haiWaiGouFragment);
        mFragmentList.add(tuShuFragment);
        mFragmentList.add(phoneFragment);
        mFragmentList.add(computerFragment);
        mFragmentList.add(fuShiFragment);
        mFragmentList.add(muYingFragment);
        mFragmentList.add(supportFragment);

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.category_right_container, mFragmentList.get(0));
        transaction.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int checkedPosition = mDragListView.getCheckedItemPosition();
        int checkedItemCount = mDragListView.getCheckedItemCount();
        Log.d(TAG, "checkedPosition: " + checkedPosition + "----checkedItemCount: " + checkedItemCount);
        mDragListView.smoothScrollToPositionFromTop(i, 0, 200);
        mDragListView.setItemChecked(i, true);
        //更改右侧界面内容TODO:
        FragmentManager fm = mMainActivity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //因为是手动
        int a = new Random().nextInt(8);
        transaction.replace(R.id.category_right_container, mFragmentList.get(i > 7 ? a : i));
        transaction.commit();
    }

}
