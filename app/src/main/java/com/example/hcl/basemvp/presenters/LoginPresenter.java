package com.example.hcl.basemvp.presenters;

import android.util.Log;

import com.example.hcl.basemvp.constract.LoginContract;
import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.domains.NewsDomain;
import com.example.hcl.basemvp.models.impls.LoginModel;
import com.example.hcl.basemvp.others.constant.AppConstant;
import com.example.hcl.basemvp.others.inter.ICallBack;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class LoginPresenter extends LoginContract.ILoginPresenter {

    //登录Model
    private LoginModel loginModel = new LoginModel();

    /**
     * 去登录
     *
     * @param userName
     * @param userPsw
     */
    @Override
    public void onLogin(String userName, String userPsw) {
        loginModel.onLogin(userName, userPsw, new LoginCallBack());
    }

    @Override
    public void onTest() {
       Observable<NewsDomain> newsDomainObservable= loginModel.onTest();
       newsDomainObservable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new DisposableObserver<NewsDomain>() {
                   @Override
                   public void onNext(NewsDomain newsDomain) {
                       Log.i(AppConstant.LogTag.Log_TAG,newsDomain.toString());
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });

    }


    /**
     * 登录回调
     */
    class  LoginCallBack  implements ILoginCallBack<LoginDomain,Exception>{

        @Override
        public void showLogining() {
            mView.showLoading();
        }


        @Override
        public void onSuccess(LoginDomain result) {
            mView.hideLoading();
            mView.loginSuccess(result.sayHello());
        }

        @Override
        public void onFail(String result) {
            mView.loginFail(result);
        }

        @Override
        public void ErrorExcept(Exception result) {
            mView.loginFail(result.getMessage());
        }
    }

}
