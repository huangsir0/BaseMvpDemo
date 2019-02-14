package com.example.hcl.basemvp.presenters;

import com.example.hcl.basemvp.BasePresenter;
import com.example.hcl.basemvp.constract.MainContract;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.IMainModel,MainContract.IMainView> {


    @Inject
    public MainPresenter() {

    }

}
