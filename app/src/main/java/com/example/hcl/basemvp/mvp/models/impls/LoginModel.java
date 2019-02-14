package com.example.hcl.basemvp.mvp.models.impls;
import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.mvp.constract.LoginContract;
import com.example.hcl.basemvp.domains.LoginDomain;
import com.example.hcl.basemvp.domains.NewsDomain;
import com.example.hcl.basemvp.mvp.models.BaseModel;
import com.example.hcl.basemvp.others.inter.ILoginCallBack;

import javax.inject.Inject;
import io.reactivex.Observable;

@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.ILoginModel {



    /**
     * 构造
     */
    @Inject
    public LoginModel(){

    }


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

    @Override
    public Observable<NewsDomain> onTest() {
        return netService.getNews("top", "dc4fed8fb5fb46ac78e51d66306e6762");
    }


}
