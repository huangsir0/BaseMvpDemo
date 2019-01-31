package com.example.hcl.basemvp;

import android.app.Application;

/**
 * 进行一些App 配置
 */
public class BaseApp extends Application {

    private static BaseApp app;

    public synchronized static BaseApp Instance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

}
