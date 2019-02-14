package com.example.hcl.basemvp.models;

import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.models.inter.IBaseModel;
import com.example.hcl.basemvp.others.net.Api;
import com.example.hcl.basemvp.others.utils.AppManager;
import com.example.hcl.basemvp.daggers.moudles.HttpMoudle;

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
