package com.example.hcl.basemvp;

import android.view.View;

/**
 * 基础视图接口,存放一些Activity,Fragment的共同行为
 */
public interface IBaseView {

    /**
     * 显示加载进度条
     */
    void  showLoading();


    /**
     * 隐藏加载视图
     *
     */
    void hideLoading();


    /**
     * Toast
     * @param msg
     */
    void showToast(String msg);
}
