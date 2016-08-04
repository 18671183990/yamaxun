package com.alan.yamaxun.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.view
 * className:   CheckedRelativeLayout
 * author:  Alan
 * time:    2016/8/4	13:50
 * desc:    TODO
 */
public class CheckedRelativeLayout extends RelativeLayout implements Checkable {

    private boolean mChecked;

    public CheckedRelativeLayout(Context context) {
        super(context);
    }

    public CheckedRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckedRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

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
