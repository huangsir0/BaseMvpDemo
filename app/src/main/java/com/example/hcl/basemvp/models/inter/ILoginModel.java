package com.example.hcl.basemvp.models.inter;

import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.models.impls.LoginModel;
import com.example.hcl.basemvp.others.exceptions.SelfException;
import com.example.hcl.basemvp.others.inter.ICallBack;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

public interface ILoginModel {

    /**
     * 登录接口
     * @param name
     * @param psw
     */
    void onLogin(String name, String psw, ILoginCallBack<LoginDomain,Exception> callBack);
}
