package com.example.hcl.basemvp.mvp.widgets.activitys;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;

import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.mvp.constract.LoginContract;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import com.example.hcl.basemvp.daggers.components.DaggerLoginComponent;
import com.example.hcl.basemvp.daggers.moudles.LoginMoudle;
import com.example.hcl.basemvp.mvp.presenters.LoginPresenter;

import com.example.hcl.basemvp.mvp.widgets.activitys.base.BaseAppActivity;
import com.example.hcl.basemvp.mvp.widgets.views.SmileLoadingView;


import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseAppActivity<LoginPresenter> implements LoginContract.ILoginView {
    @BindView(R.id.edit_userName)
    EditText edit_userName;
    @BindView(R.id.edit_userPsw)
    EditText edit_userPsw;
    @BindView(R.id.loading_smile)
    SmileLoadingView loading_smile;



    @Override
    protected void setupActivityCommponent(AppComponent appComponent) {
        DaggerLoginComponent.builder().appComponent(appComponent)
                .loginMoudle(new LoginMoudle(this))
                .build().inject(this);
    }



    @Override
    public void showLoading() {
        loading_smile.setViewColor(Color.RED);
        loading_smile.startAnim();
    }



    @Override
    public void hideLoading() {
        loading_smile.stopAnim();
    }




    /**
     * 布局ID
     *
     * @return
     */
    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }


    @OnClick(R.id.btn_userLogin)
    void onClick(View view){
        String name =edit_userName.getText().toString();
        String psw =edit_userPsw.getText().toString();
        mPresenter.onLogin(name,psw);
    }


    @OnClick(R.id.btn_onTest)
    void onTestClick(View view){
        mPresenter.onTest();
    }


    @Override
    public void loginFail(String errorMsg) {
        showToast(errorMsg);
    }

    @Override
    public void loginSuccess(String successMsg) {
        showToast(successMsg);
        startActivity(new Intent(this,MainActivity.class));
    }
}
