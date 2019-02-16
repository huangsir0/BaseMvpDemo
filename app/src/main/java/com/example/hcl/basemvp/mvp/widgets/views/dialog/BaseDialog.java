package com.example.hcl.basemvp.mvp.widgets.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public abstract   class BaseDialog extends DialogFragment {

    //布局ID
    protected int mLayoutResId;

    //背景昏暗度
    private float mDimAmount =0.5f;

    private boolean mShowBottomEnable;//是否底部显示

    private int mMargin = 0;//左右边距
    private int mAnimStyle = 0;//进入退出动画
    private boolean mOutCancel=true;//点击外部取消
    private Context mContext;
    private int mWidth;
    private int mHeight;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
