package com.example.hcl.basemvp.widgets.activitys.base;

import android.view.View;
import android.widget.Toast;

import com.example.hcl.basemvp.IBasePresenter;
import com.example.hcl.basemvp.IBaseView;

/**
 * @param <P>
 */
public abstract class BaseAppActivity<P extends IBasePresenter> extends BaseActivity implements IBaseView {

    protected P mPresenter;

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void showLoading() {

    }

    /**
     * 初始化
     */
    @Override
    protected void init() {
        mPresenter = bindPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }

    }




    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }

    protected abstract P bindPresenter();

}