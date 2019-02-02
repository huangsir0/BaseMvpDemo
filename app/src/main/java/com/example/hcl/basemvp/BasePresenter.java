package com.example.hcl.basemvp;

import com.example.hcl.basemvp.models.inter.IBaseModel;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;

public class BasePresenter<M extends IBaseModel, V extends IBaseView> implements IBasePresenter {

    @Inject
    protected V mView;

    @Inject
    @Nullable
    protected M mModel;


    /**
     * 构造
     * @param model
     * @param view
     */
    @Inject
    public BasePresenter(M model,V view){
        this.mModel=model;
        this.mView=view;
    }


    public  BasePresenter(V view){
        this.mView=view;
    }



    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(IBaseView view) {
        this.mView= (V) view;
    }

    @Override
    public void onDestory() {
        this.mView=null;
        this.mModel=null;
    }
}
