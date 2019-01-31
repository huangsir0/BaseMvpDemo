package com.example.hcl.basemvp.constract;

import com.example.hcl.basemvp.BasePresenter;
import com.example.hcl.basemvp.IBaseView;

/**
 * Login 契约接口
 */
public interface LoginContract {
    interface ILoginView extends IBaseView {
        /**
         * 登录失败
         * @param errorMsg
         */
        void loginFail(String errorMsg);

        /**
         *登录成功
         * @param successMsg
         */
        void loginSuccess(String successMsg);
    }

    abstract class ILoginPresenter extends BasePresenter<ILoginView> {

        public abstract void onLogin(String userName, String userPsw);
    }


}
