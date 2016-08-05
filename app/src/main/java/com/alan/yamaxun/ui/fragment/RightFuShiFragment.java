package com.alan.yamaxun.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alan.yamaxun.R;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.ui.fragment
 * className:   RightTuiJianFragment
 * author:  Alan
 * time:    2016/8/4	16:04
 * desc:    TODO
 */
public class RightFuShiFragment extends AppBaseFragment {
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
        View view = View.inflate(getContext(), R.layout.layout_category_fragment_right_kindle, null);
        return view;
    }
}
