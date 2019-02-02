package com.example.hcl.basemvp.daggers.moudles;


import com.example.hcl.basemvp.constract.LoginContract;
import com.example.hcl.basemvp.models.impls.LoginModel;
import com.example.hcl.basemvp.presenters.LoginPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class LoginMoudle {

    private LoginContract.ILoginView loginView;


    public LoginMoudle(LoginContract.ILoginView view){
        this.loginView=view;
    }



    @Provides
    public LoginPresenter provideLoginPresenter(){
        return  new LoginPresenter(new LoginModel(),this.loginView);
    }



}
