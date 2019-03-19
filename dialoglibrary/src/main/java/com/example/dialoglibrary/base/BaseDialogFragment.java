package com.example.dialoglibrary.base;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.dialoglibrary.Const;
import com.example.dialoglibrary.utils.HDialogsManager;

/***
 * 基类
 */
public abstract class BaseDialogFragment extends DialogFragment {

    //视图
    protected View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutRes() > 0) {
            //通过布局创建view
            this.view = inflater.inflate(getLayoutRes(), null);
        } else if (getDialogView() != null) {
            //直接传入
            this.view = getDialogView();
        }
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Dialog dialog =getDialog();
        if (null!=dialog){
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //是否能返回
            dialog.setCancelable(isCancelable());
            //点击屏幕外边是否会消失
            dialog.setCanceledOnTouchOutside(isCancelableOutside());

            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN&&!isCancelable();
                }
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog=getDialog();
        if (null==dialog)return;;
        Window window =dialog.getWindow();
        if (null==window)return;;
        //设置背景透明
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置动画
        if (getAnimRes()>0)window.setWindowAnimations(getAnimRes());
        WindowManager.LayoutParams params =window.getAttributes();

        //设置Dialog的Width
        if (getDialogWidth()>0){
            params.width=getDialogWidth();
        }else {
            params.width=WindowManager.LayoutParams.WRAP_CONTENT;
        }
        //设置Dialog的Height
        if (getDialogHeight() > 0) {
            params.height = getDialogHeight();
        } else {
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }
        //设置屏幕透明度 0.0f~1.0f(完全透明~完全不透明)
        params.dimAmount =getDimAmount();
        params.gravity=getGravity();
        window.setAttributes(params);
    }

    /**
     * 获取视图
     * @return
     */
    protected View getBaseView(){
        return  this.view;
    }


    /**
     * 锚点
     * @return
     */
    protected  int getGravity(){
        return Gravity.CENTER;
    }

    /**
     * 能否点击外面消失
     * @return
     */
    protected  boolean isCancelableOutside(){

        return  true;
    }

    /***
     * 透明度
     * @return
     */
    protected  float getDimAmount(){
        return Const.DimAmount;
    }
    /**
     * 默认没动画
     * @return
     */
    protected  int getAnimRes(){return 0;}


    @Override
    public void onDestroy() {
        super.onDestroy();
        HDialogsManager.getInstance().over();
    }

    /**
     * 默认高
     * @return
     */
    protected  int getDialogHeight(){return WindowManager.LayoutParams.WRAP_CONTENT;};

    /**
     * 默认宽
     * @return
     */
    protected  int getDialogWidth(){return WindowManager.LayoutParams.WRAP_CONTENT;};



    protected abstract View getDialogView();

    protected abstract int getLayoutRes();
}
