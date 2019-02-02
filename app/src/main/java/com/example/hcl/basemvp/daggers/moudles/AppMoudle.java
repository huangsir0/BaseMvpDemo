package com.example.hcl.basemvp.daggers.moudles;

import com.example.hcl.basemvp.BaseApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppMoudle {
    private BaseApp baseApp;

    public  AppMoudle(BaseApp app){
        this.baseApp=app;
    }


    @Singleton
    @Provides
    public BaseApp provideApplication(){
        return this.baseApp;
    }


}
