package com.example.hcl.basemvp;

/**
 * 基类持有IBaseView
 */
public interface IBasePresenter<V extends IBaseView> {



    void onCreate();


    void onDestory();


}
