package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    //    @BindView(R.id.category_fragment_radio_btn0)
//    RadioButton categoryFragmentRadioBtn0;
//    @BindView(R.id.category_fragment_radio_btn1)
//    RadioButton categoryFragmentRadioBtn1;
//    @BindView(R.id.category_fragment_radio_btn2)
//    RadioButton categoryFragmentRadioBtn2;
//    @BindView(R.id.category_fragment_radio_btn3)
//    RadioButton categoryFragmentRadioBtn3;
//    @BindView(R.id.category_fragment_radio_btn4)
//    RadioButton categoryFragmentRadioBtn4;
//    @BindView(R.id.category_fragment_radio_btn5)
//    RadioButton categoryFragmentRadioBtn5;
//    @BindView(R.id.category_fragment_radio_btn6)
//    RadioButton categoryFragmentRadioBtn6;
//    @BindView(R.id.category_fragment_radio_btn7)
//    RadioButton categoryFragmentRadioBtn7;
//    @BindView(R.id.category_fragment_radio_btn8)
//    RadioButton categoryFragmentRadioBtn8;
//    @BindView(R.id.category_fragment_radio_btn9)
//    RadioButton categoryFragmentRadioBtn9;
//    @BindView(R.id.category_fragment_radio_btn10)
//    RadioButton categoryFragmentRadioBtn10;
//    @BindView(R.id.category_fragment_radio_btn11)
//    RadioButton categoryFragmentRadioBtn11;
//    @BindView(R.id.category_fragment_radio_btn12)
//    RadioButton categoryFragmentRadioBtn12;
//    @BindView(R.id.category_fragment_radio_btn13)
//    RadioButton categoryFragmentRadioBtn13;
//    @BindView(R.id.category_fragment_radio_btn14)
//    RadioButton categoryFragmentRadioBtn14;
//    @BindView(R.id.category_fragment_radio_btn15)
//    RadioButton categoryFragmentRadioBtn15;
//    @BindView(R.id.category_fragment_radio_btn16)
//    RadioButton categoryFragmentRadioBtn16;
//    @BindView(R.id.category_fragment_radio_btn17)
//    RadioButton categoryFragmentRadioBtn17;
//    @BindView(R.id.category_fragment_radio_btn18)
//    RadioButton categoryFragmentRadioBtn18;
//    @BindView(R.id.category_fragment_radio_btn19)
//    RadioButton categoryFragmentRadioBtn19;
//    @BindView(R.id.category_fragment_radio_btn20)
//    RadioButton categoryFragmentRadioBtn20;
//    @BindView(R.id.category_fragment_radio_btn21)
//    RadioButton categoryFragmentRadioBtn21;
//    @BindView(R.id.category_fragment_radio_btn22)
//    RadioButton categoryFragmentRadioBtn22;
//    @BindView(R.id.category_fragment_radio_btn23)
//    RadioButton categoryFragmentRadioBtn23;
//    @BindView(R.id.category_fragment_radio_btn24)
//    RadioButton categoryFragmentRadioBtn24;
//    @BindView(R.id.category_fragment_radio_btn25)
//    RadioButton categoryFragmentRadioBtn25;
//    @BindView(R.id.category_fragment_radio_btn26)
//    RadioButton categoryFragmentRadioBtn26;
//    @BindView(R.id.category_fragment_radio_btn27)
//    RadioButton categoryFragmentRadioBtn27;
//    @BindView(R.id.category_fragment_radio_btn28)
//    RadioButton categoryFragmentRadioBtn28;
//    @BindView(R.id.category_fragment_radio_btn29)
//    RadioButton categoryFragmentRadioBtn29;
//    @BindView(R.id.category_fragment_radio_btn30)
//    RadioButton categoryFragmentRadioBtn30;
//    @BindView(R.id.category_fragment_radio_btn31)
//    RadioButton categoryFragmentRadioBtn31;
//    @BindView(R.id.category_fragment_left_radio_group)
//    RadioGroup mCategoryLeftRG;
//    @BindView(R.id.category_fragment_left_srollview)
//    ScrollView mScrollView;
    @BindView(R.id.category_left_content_tv)
    TextView mLeftContentTv;

    private Context mContext;
    private MainActivity mMainActivity;

    public CategoryFragment() {
    }

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initLeft();
    }

    /**
     * 初始化左侧列表
     */
    private void initLeft() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Constans.categoryLeftData.length; i++) {
            list.add(Constans.categoryLeftData[i]);
        }
        CategoryLeftAdapter leftAdapter = new CategoryLeftAdapter(mContext, list);
        mDragListView.setAdapter(leftAdapter);
        mDragListView.setOnItemClickListener(this);
        //TODO:使用ListView暂时无法实现单选功能,待实现
        //方法二
//        mCategoryLeftRG.check(0);
//        mCategoryLeftRG.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        adapterView.setSelected(true);
        int pos = adapterView.getSelectedItemPosition();
        Log.d(TAG, "onItemClick: " + pos);
        mDragListView.smoothScrollToPositionFromTop(i, 0, 300);
        mLeftContentTv.setText(Constans.categoryLeftData[i]);
    }

}
