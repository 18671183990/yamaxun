package com.alan.yamaxun.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.view
 * className:   CheckedRelativeLayout
 * author:  Alan
 * time:    2016/8/4	13:50
 * desc:    TODO
 */
public class CheckedTextView extends TextView implements Checkable {

    private boolean mChecked;

    public CheckedTextView(Context context) {
        super(context);
    }

    public CheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setChecked(boolean b) {
        mChecked = b;
        refreshDrawableState();
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(mChecked);
    }
}
