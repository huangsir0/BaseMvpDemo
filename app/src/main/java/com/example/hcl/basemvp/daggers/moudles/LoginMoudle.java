package com.example.hcl.basemvp.daggers.moudles;


import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.mvp.constract.LoginContract;
import com.example.hcl.basemvp.mvp.models.impls.LoginModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginMoudle {

    private LoginContract.ILoginView loginView;


    public LoginMoudle(LoginContract.ILoginView view){
        this.loginView=view;
    }


    @ActivityScope
    @Provides
    public LoginContract.ILoginView provideLoginView(){
      return this.loginView;
    }

    @ActivityScope
    @Provides
    public LoginContract.ILoginModel provideLoginModel(LoginModel loginModel){
        return loginModel;
    }




}
