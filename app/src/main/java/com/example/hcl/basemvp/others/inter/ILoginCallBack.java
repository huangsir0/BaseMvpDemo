package com.example.hcl.basemvp.others.inter;

import com.example.hcl.basemvp.domains.LoginDomain;

public interface ILoginCallBack<S,F> extends ICallBack<S,F>{

    /**
     * 显示进度条
     */
    void showLogining();
}
