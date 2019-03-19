package com.example.hcl.basemvp.daggers.moudles;

import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.mvp.constract.MainContract;
import com.example.hcl.basemvp.mvp.models.impls.MainModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainMoudle {


    private MainContract.IMainView mainView;


    public MainMoudle(MainContract.IMainView view){
        this.mainView=view;
    }


    @ActivityScope
    @Provides
    public MainContract.IMainView provideMainView(){
        return this.mainView;
    }

    @ActivityScope
    @Provides
    public MainContract.IMainModel provideMainModel(MainModel mainModel){
        return mainModel;
    }


}
