package com.example.hcl.basemvp.mvp.models;

import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.mvp.models.inter.IBaseModel;
import com.example.hcl.basemvp.others.net.Api;

import javax.inject.Inject;


public class BaseModel implements IBaseModel {


    @Inject
    protected BaseApp baseApp;

    @Inject
    protected Api netService;

    /**
     * 构造
     */
    public BaseModel() {

    }


}
