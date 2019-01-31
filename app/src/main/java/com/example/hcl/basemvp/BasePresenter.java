package com.example.hcl.basemvp;

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;


    @Override
    public void attachView(IBaseView view) {
        this.mView=(V)view;
    }

    @Override
    public void detachView() {
        this.mView=null;
    }
}
