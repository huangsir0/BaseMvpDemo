package com.example.hcl.basemvp.models.inter;

import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.domains.NewsDomain;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

import io.reactivex.Observable;


public interface ILoginModel {

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
