package com.example.hcl.basemvp.mvp.constract;
import com.example.hcl.basemvp.mvp.IBaseView;
import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.domains.NewsDomain;
import com.example.hcl.basemvp.mvp.models.inter.IBaseModel;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

import io.reactivex.Observable;

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

    interface ILoginModel extends IBaseModel {

        /**
         * 登录接口
         * @param name
         * @param psw
         */
        void onLogin(String name, String psw, ILoginCallBack<LoginDomain,Exception> callBack);

        /**
         * Test
         */
        Observable<NewsDomain> onTest();
    }
}
