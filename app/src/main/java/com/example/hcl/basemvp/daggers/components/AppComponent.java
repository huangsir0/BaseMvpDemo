package com.example.hcl.basemvp.daggers.components;


import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.daggers.moudles.ApiServiceMoudle;
import com.example.hcl.basemvp.daggers.moudles.AppMoudle;
import com.example.hcl.basemvp.others.net.Api;
import com.example.hcl.basemvp.others.utils.AppManager;
import com.example.hcl.basemvp.daggers.moudles.HttpMoudle;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppMoudle.class,HttpMoudle.class, ApiServiceMoudle.class})
public interface AppComponent {

    BaseApp application();

    /**
     * APP管理类
     * @return
     */
    AppManager appManager();

    Api serviceManager();

}
