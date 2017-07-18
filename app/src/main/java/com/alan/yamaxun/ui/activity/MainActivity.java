package com.alan.yamaxun.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alan.yamaxun.R;
import com.alan.yamaxun.ui.fragment.CategoryFragment;
import com.alan.yamaxun.ui.fragment.DiscoverFragment;
import com.alan.yamaxun.ui.fragment.HomeFragment;
import com.alan.yamaxun.ui.fragment.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.activity
 * className:   MainActivity
 * author:  Alan
 * time:    2016/7/30	17:59
 * desc:    主界面的Activity
 */
public class MainActivity extends AppBaseActivity {

    @BindView(R.id.main_container)
    FrameLayout mContainer;
    @BindView(R.id.radio_bar_home)
    RadioButton mRadioBarHome;
    @BindView(R.id.radio_bar_category)
    RadioButton mRadioBarCategory;
    @BindView(R.id.radio_bar_discover)
    RadioButton mRadioBarDiscover;
    @BindView(R.id.radio_bar_my)
    RadioButton mRadioBarMy;
    @BindView(R.id.main_radio_group)
    RadioGroup mRainRadioGroup;

    private FragmentManager mFranmentManager;
    private HomeFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private DiscoverFragment mDiscoverFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        switchFragment(0, R.id.radio_bar_home);
    }

    private void initFragment() {
        FragmentTransaction transaction = getAppFragmentManager().beginTransaction();
        mHomeFragment = new HomeFragment(this);
        mCategoryFragment = new CategoryFragment(this);
        mDiscoverFragment = new DiscoverFragment(this);
        mMyFragment = new MyFragment(this);
        transaction.add(R.id.main_container, mHomeFragment);
        transaction.add(R.id.main_container, mCategoryFragment);
        transaction.add(R.id.main_container, mDiscoverFragment);
        transaction.add(R.id.main_container, mMyFragment);
        transaction.commit();
    }

    /**
     * 获取Activity唯一的FragmentManager
     *
     * @return FragmentManager
     */
    public FragmentManager getAppFragmentManager() {
        if (mFranmentManager == null) {
            mFranmentManager = getSupportFragmentManager();
        }
        return mFranmentManager;
    }

    /**
     * 通过RadioGroup切换Fragment
     *
     * @param currentFragment 当前Fragment的index
     * @param radioBtnId      当前RadioButton的id
     */
    public void switchFragment(int currentFragment, int radioBtnId) {
        FragmentTransaction transaction = getAppFragmentManager().beginTransaction();
        //transaction.setCustomAnimations(R.anim.fragment_transition_pop_in,R.anim.fragment_transition_pop_out);
        mRainRadioGroup.check(radioBtnId);
        switch (currentFragment) {
            case 0:
                transaction.hide(mCategoryFragment);
                transaction.hide(mDiscoverFragment);
                transaction.hide(mMyFragment);
                transaction.show(mHomeFragment);
                break;
            case 1:
                transaction.hide(mHomeFragment);
                transaction.hide(mDiscoverFragment);
                transaction.hide(mMyFragment);
                transaction.show(mCategoryFragment);
                break;
            case 2:
                transaction.hide(mHomeFragment);
                transaction.hide(mCategoryFragment);
                transaction.hide(mMyFragment);
                transaction.show(mDiscoverFragment);
                break;
            case 3:
                transaction.hide(mHomeFragment);
                transaction.hide(mCategoryFragment);
                transaction.hide(mDiscoverFragment);
                transaction.show(mMyFragment);
                break;
        }
        transaction.commit();
    }


    /**
     * 跳转到HomeFragment
     */
    public void goToHome() {
        switchFragment(0, R.id.radio_bar_home);
    }

    @OnClick({R.id.radio_bar_home, R.id.radio_bar_category, R.id.radio_bar_discover, R.id.radio_bar_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_bar_home:
                switchFragment(0, view.getId());
                break;
            case R.id.radio_bar_category:
                switchFragment(1, view.getId());
                break;
            case R.id.radio_bar_discover:
                switchFragment(2, view.getId());
                break;
            case R.id.radio_bar_my:
                switchFragment(3, view.getId());
                break;
        }
    }


    /**
     * 进入搜索页面
     */
    public void goSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    /**
     * 进入扫一扫页面
     */
    public void goScanActivity() {
        startActivity(new Intent(this, ScanActivity.class));
    }

    /**
     * 进入购物车页面
     */
    public void goGouWuCheActivity() {
        startActivity(new Intent(this, GouWuCheActivity.class));
    }

    public void goProductActivity(){
        startActivity(new Intent(this,ProductActivity.class));
    }
}




