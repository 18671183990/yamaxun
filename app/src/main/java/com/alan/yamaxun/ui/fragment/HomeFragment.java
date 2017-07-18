package com.alan.yamaxun.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alan.yamaxun.R;
import com.alan.yamaxun.bean.Shoe;
import com.alan.yamaxun.bean.Time;
import com.alan.yamaxun.config.Constans;
import com.alan.yamaxun.ui.activity.MainActivity;
import com.alan.yamaxun.ui.adapter.HomeGridAdapter;
import com.alan.yamaxun.ui.adapter.ZmiaoShaAdapter;
import com.alan.yamaxun.ui.view.MyGridView;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class HomeFragment extends AppBaseFragment
        implements Animation.AnimationListener,
        BGABanner.OnItemClickListener,
        BGABanner.Adapter,
        AdapterView.OnItemClickListener,
        ZmiaoShaAdapter.OnItemClickListener {

    private static final long TEN_HOUR_SECOND = 1000 * 60 * 60 * 5;   //倒计时5个小时
    private static final int MESSAGE_TYPE_UPDATE_TIME = 10010;
    private static final int MESSAGE_TYPE_INIT_BANNER = 10011;
    private static final int MESSAGE_TYPE_INIT_MORE_PRODUCT = 10012;

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
    @BindView(R.id.z_miaosha_hour_tv)
    TextView mZMiaoShaHourTv;
    @BindView(R.id.z_miaosha_minute_tv)
    TextView mZMiaoShaMinuteTv;
    @BindView(R.id.z_miaosha_second_tv)
    TextView mZMiaoShaSecondTv;
    @BindView(R.id.zhendian_hour_tv)
    TextView mZhenDianHourTv;
    @BindView(R.id.zhendian_minute_tv)
    TextView mZhenDianMinuteTv;
    @BindView(R.id.zhendian_second_tv)
    TextView mZhenDianSecondTv;

    @BindView(R.id.kindle)
    View mKindle;
    @BindView(R.id.haiwaigou)
    View mHaiwaigou;
    @BindView(R.id.guojiaguan)
    View mGuojiaguan;
    @BindView(R.id.app_miaosha)
    View mAppMiaoSha;
    @BindView(R.id.babiguan)
    View mBaBiGuan;
    @BindView(R.id.z_miaosha_rv)
    RecyclerView mZMiaoShaRv;


    private Context mContext;
    private MainActivity mMainActivity;

    /**
     *
     */
    private TimeHelper mTimeHelper = new TimeHelper() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_TYPE_UPDATE_TIME:
                    Time time = (Time) msg.obj;
                    mZMiaoShaHourTv.setText(time.getHour());
                    mZMiaoShaMinuteTv.setText(time.getMinute());
                    mZMiaoShaSecondTv.setText(time.getSecond());
                    break;
                case MESSAGE_TYPE_INIT_BANNER:
                    List<View> list = (ArrayList<View>) msg.obj;
                    mCubeBanner.setAdapter(HomeFragment.this);
                    mCubeBanner.setData(list);
                    break;
                case MESSAGE_TYPE_INIT_MORE_PRODUCT:
                    ArrayList<Shoe> shoeList = (ArrayList<Shoe>) msg.obj;
                    HomeGridAdapter homeGridAdapter = new HomeGridAdapter(mContext, shoeList);
                    mMoreGridView.setAdapter(homeGridAdapter);
                    mMoreGridView.setOnItemClickListener(HomeFragment.this);
            }
        }
    };

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
        initBanner();       //初始化Banner数据

        initZMiaoSha();

        initMoreProduct();  //初始化更多数据
    }

    /**
     * 初始化轮播图数据
     */
    private void initBanner() {
        //此部分是假数据,实际情况需要从网络获取图片//TODO:
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<View> mBannerList = new ArrayList<>();
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                for (int pic : Constans.bannerPics) {
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setLayoutParams(params);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageResource(pic);
                    mBannerList.add(imageView);
                }
                Message msg = Message.obtain();
                msg.what = MESSAGE_TYPE_INIT_BANNER;
                msg.obj = mBannerList;
                mTimeHelper.sendMessage(msg);
            }
        }).start();
    }

    /**
     * 初始化Z秒杀数据
     */
    private void initZMiaoSha() {
        initCurrentTime();      //初始化时间
        initCountDownTime();    //初始化倒计时器
        //初始化Z秒杀数据,使用RecyclerView
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, OrientationHelper.HORIZONTAL);
        mZMiaoShaRv.setLayoutManager(staggeredGridLayoutManager);

        //假数据
        ArrayList<Integer> mZList = new ArrayList<>();
        for (int i = 0; i < Constans.zMiaoSha.length; i++) {
            mZList.add(Constans.zMiaoSha[i]);
        }
        ZmiaoShaAdapter mZmiaoShaAdapter = new ZmiaoShaAdapter(this, mZList);
        mZmiaoShaAdapter.setmOnItemClickListener(this);
        mZMiaoShaRv.setAdapter(mZmiaoShaAdapter);
    }

    /**
     * 初始化镇店之宝的倒计时器
     */
    private void initCountDownTime() {
        CountDownTimer mCountDownTimer = new CountDownTimer(TEN_HOUR_SECOND, 1000) {
            @Override
            public void onTick(long l) {
                long seconds = l / 1000;
                long second = seconds % 60;
                long minute = seconds / 60 % 60;
                long hour = seconds / 60 / 60;
                mZhenDianHourTv.setText(hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour));
                mZhenDianMinuteTv.setText(minute < 10 ? "0" + String.valueOf(minute) : String.valueOf(minute));
                mZhenDianSecondTv.setText(second < 10 ? "0" + String.valueOf(second) : String.valueOf(second));
            }

            @Override
            public void onFinish() {

            }
        };
        mCountDownTimer.start();
    }

    private void initCurrentTime() {
        new Thread(mTimeHelper).start();    //开启子线程去更新时间
        //Date date = new Date();
        //long time = date.getTime();
        //String s = date.toString();
        //Log.d(TAG, "initCurrentTime: "+time);
        //Log.d(TAG, "initCurrentTime: "+s);
    }

    /**
     * 初始化更多商品数据
     */
    private void initMoreProduct() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Shoe> list = new ArrayList<>();
                for (int i = 0; i < Constans.shoesIcons.length; i++) {
                    Shoe shoe = new Shoe(Constans.shoesIcons[i], null, Constans.shoesDescs[i], Constans.shoesPrices[i]);
                    list.add(shoe);
                }
                Message msg = Message.obtain();
                msg.what = MESSAGE_TYPE_INIT_MORE_PRODUCT;
                msg.obj = list;
                mTimeHelper.sendMessage(msg);
            }
        }).start();
    }

    private void initEvent() {
        mCubeBanner.setOnItemClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
//        playLoadDataAnimation();
    }

    @Override
    public void onStop() {
        super.onStop();
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


    /**
     * ButterKnife中绑定的方法
     * @param view
     */
    @OnClick(
            {R.id.main_titlebar_logo_iv,
                    R.id.main_titlebar_camera_iv,
                    R.id.main_titlebar_search_container,
                    R.id.main_titlebar_gouwuche_container,
                    R.id.kindle,
                    R.id.haiwaigou,
                    R.id.guojiaguan,
                    R.id.app_miaosha,
                    R.id.babiguan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titlebar_logo_iv:
                break;
            case R.id.main_titlebar_camera_iv:
                mMainActivity.goScanActivity();
                break;
            case R.id.main_titlebar_gouwuche_container:
                //进入购物车页面
                mMainActivity.goGouWuCheActivity();
                break;
            case R.id.main_titlebar_search_container:
                //进入搜索页面：SearchActivity
//                goSearchActivity();
                mMainActivity.goSearchActivity();
                break;
            case R.id.kindle:
                mMainActivity.goProductActivity();
                break;
            case R.id.haiwaigou:
                mMainActivity.goProductActivity();
                break;
            case R.id.guojiaguan:
                mMainActivity.goProductActivity();
                break;
            case R.id.app_miaosha:
                mMainActivity.goProductActivity();
                break;
            case R.id.babiguan:
                mMainActivity.goProductActivity();
                break;
        }
    }


    /**
     * 以下三个方法是AnimationListener的实现
     * @param animation
     */
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
                mMainActivity.goProductActivity();
                break;
            case 1:
                mMainActivity.goProductActivity();
                break;
            case 2:
                mMainActivity.goProductActivity();
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

    /**
     * @param adapterView GradView的AdapterView
     * @param view        当前点击的view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(mContext, "第" + i + "个view被点击了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimeHelper.stop();
        mTimeHelper = null;
    }

    /**
     * HomeFragment中RevyclerView的OnitemClickListener的回调方法
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(mContext, "第" + position + "个view被点击了", Toast.LENGTH_SHORT).show();
    }

    /**
     * 继承了Handler的Runnable
     */
    private class TimeHelper extends Handler implements Runnable {

        private boolean start = true;

        @Override
        public void run() {
            if (start) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                String time = format.format(new Date());
                String hour = time.substring(0, 2);
                String minute = time.substring(3, 5);
                String second = time.substring(6, 8);
                Message msg = Message.obtain();
                Time myTime = new Time();
                myTime.setHour(hour);
                myTime.setMinute(minute);
                myTime.setSecond(second);
                msg.what = MESSAGE_TYPE_UPDATE_TIME;
                msg.obj = myTime;
                sendMessage(msg);   //handler的方法
                postDelayed(this, 1000);
            }
        }

        public void start() {
            this.start = true;
        }

        public void stop() {
            this.start = false;
        }
    }

}
