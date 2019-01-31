package com.example.hcl.basemvp.others.inter;

/**
 * 结果成功失败回调
 * @param <S>
 * @param <F>
 */
public interface ICallBack<S,F> {

    void onSuccess(S result);

    void onFail(String result);

    void ErrorExcept(F result);
}
