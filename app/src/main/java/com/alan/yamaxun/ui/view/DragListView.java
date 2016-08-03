package com.alan.yamaxun.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.view
 * className:   BounceListView
 * author:  Alan
 * time:    2016/8/3	20:12
 * desc:    TODO
 */
public class DragListView extends ListView {

    private static final int MAX_Y_OVERSCROLL_DISTANCE = 300;
    private static final float SCROLL_RATIO = 0.5f;// 阻尼系数

    public DragListView(Context context) {
        super(context);
    }

    public DragListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        int newDeltaY = deltaY;
        int delta = (int) (deltaY * SCROLL_RATIO);
        if (delta != 0) {
            newDeltaY = delta;
        }
        return super.overScrollBy(deltaX, newDeltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, MAX_Y_OVERSCROLL_DISTANCE, isTouchEvent);
    }
}