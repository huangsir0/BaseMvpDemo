package com.example.hcl.basemvp.presenters;

import com.example.hcl.basemvp.constract.LoginContract;
import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.models.impls.LoginModel;
import com.example.hcl.basemvp.others.inter.ICallBack;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

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
