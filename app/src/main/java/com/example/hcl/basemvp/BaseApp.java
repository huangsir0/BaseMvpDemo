package com.example.hcl.basemvp;

import android.app.Application;

import com.example.hcl.basemvp.daggers.components.AppComponent;
import com.example.hcl.basemvp.daggers.components.DaggerAppComponent;
import com.example.hcl.basemvp.daggers.moudles.ApiServiceMoudle;
import com.example.hcl.basemvp.daggers.moudles.AppMoudle;
import com.example.hcl.basemvp.daggers.moudles.HttpMoudle;

import dagger.android.DaggerApplication;

/**
 * 进行一些App 配置
 */
public class BaseApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder()
                .appMoudle(new AppMoudle(this))
                .apiServiceMoudle(new ApiServiceMoudle())
                .httpMoudle(new HttpMoudle())
                .build();
    }

    public AppComponent getAppComponent(){
        return this.appComponent;
    }
}
