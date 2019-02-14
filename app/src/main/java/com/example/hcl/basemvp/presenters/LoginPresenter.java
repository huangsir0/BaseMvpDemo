package com.example.hcl.basemvp.presenters;

import android.util.Log;

import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.BasePresenter;
import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.constract.LoginContract;
import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.domains.NewsDomain;
import com.example.hcl.basemvp.others.constant.AppConstant;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;
import com.example.hcl.basemvp.others.net.Api;
import com.example.hcl.basemvp.others.utils.AppManager;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class LoginPresenter extends BasePresenter<LoginContract.ILoginModel,LoginContract.ILoginView> {







    @Inject
    public LoginPresenter() {

    }



    /**
     * 去登录
     *
     * @param userName
     * @param userPsw
     */
    public void onLogin(String userName, String userPsw) {
        this.mModel.onLogin(userName, userPsw, new LoginCallBack());
    }


    public void onTest() {
       Observable<NewsDomain> newsDomainObservable= this.mModel.onTest();
       newsDomainObservable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new DisposableObserver<NewsDomain>() {
                   @Override
                   public void onNext(NewsDomain newsDomain) {
                       Log.i(AppConstant.Log.Log_TAG,newsDomain.toString());
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
