package com.example.hcl.basemvp.mvp.models.impls;

import com.example.hcl.basemvp.daggers.moudles.MainMoudle;
import com.example.hcl.basemvp.mvp.constract.MainContract;
import com.example.hcl.basemvp.mvp.models.BaseModel;

import javax.inject.Inject;

public class MainModel extends BaseModel implements MainContract.IMainModel {


    @Inject
    public MainModel(){

    }
}
