package com.example.hcl.basemvp.models.impls;

import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.models.inter.ILoginModel;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

public class LoginModel implements ILoginModel {


    @Override
    public void onLogin(String name, String psw, ILoginCallBack<LoginDomain, Exception> callBack) {
        //模拟网络请求
        try {

            callBack.showLogining();
            Thread.sleep(2000);
            if ("world".equals(name)&&"123456".equals(psw)){
                LoginDomain loginDomain=new LoginDomain("HuangSir","123456");
                callBack.onSuccess(loginDomain);
            }else {
                callBack.onFail("用户名或者密码不正确!");
            }
        } catch (InterruptedException e) {
            callBack.ErrorExcept(e);
        }
    }
}
