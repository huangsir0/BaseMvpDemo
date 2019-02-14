package com.example.hcl.basemvp.mvp;

import com.example.hcl.basemvp.mvp.models.inter.IBaseModel;

import javax.inject.Inject;

public class BasePresenter<M extends IBaseModel, V extends IBaseView> implements IBasePresenter {

    @Inject
    protected V mView;

    @Inject
    protected M mModel;

    public BasePresenter(){

    }



    @Override
    public void onCreate() {

    }


    @Override
    public void onDestory() {
        this.mView=null;
        this.mModel=null;
    }
}
