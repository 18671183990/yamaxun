package com.alan.yamaxun;

import android.app.Application;
import android.content.Context;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun
 * className:   BaseApplication
 * author:  Alan
 * time:    2016/7/30	16:30
 * desc:    应用程序的基类Application,可做全局初始化操作,如网络请求,线程池,第三方SDK等
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initOhter();
    }

    /**
     * @return 返回自定义的Application的上下文
     */
    public static Context getAppContext() {
        return mContext;
    }

    /**
     * 初始化其他功能
     */
    private void initOhter() {
        //TODO:
    }
}
