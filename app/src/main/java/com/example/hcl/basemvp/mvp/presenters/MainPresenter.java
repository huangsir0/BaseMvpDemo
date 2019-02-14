package com.example.hcl.basemvp.mvp.presenters;

import com.example.hcl.basemvp.mvp.BasePresenter;
import com.example.hcl.basemvp.mvp.constract.MainContract;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.IMainModel,MainContract.IMainView> {


    @Inject
    public MainPresenter() {

    }

}
