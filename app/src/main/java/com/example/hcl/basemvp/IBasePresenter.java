package com.example.hcl.basemvp;

/**
 * 基类持有IBaseView
 *
 * @param <V>
 */
public interface IBasePresenter<V extends IBaseView> {

    /**
     * 绑定view
     * @param view
     */
    void attachView(V view);


    /**
     * 解绑
     */
    void detachView();


}
