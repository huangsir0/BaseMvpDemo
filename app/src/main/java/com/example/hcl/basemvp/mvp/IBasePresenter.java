package com.example.hcl.basemvp.mvp;

/**
 * 基类持有IBaseView
 */
public interface IBasePresenter<V extends IBaseView> {



    void onCreate();


    void onDestory();


}
