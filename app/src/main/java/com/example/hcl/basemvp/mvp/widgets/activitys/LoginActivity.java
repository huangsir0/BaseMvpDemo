package com.example.hcl.basemvp.mvp.widgets.activitys;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.mvp.constract.LoginContract;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import com.example.hcl.basemvp.daggers.components.DaggerLoginComponent;
import com.example.hcl.basemvp.daggers.moudles.LoginMoudle;
import com.example.hcl.basemvp.mvp.presenters.LoginPresenter;
import com.example.hcl.basemvp.mvp.widgets.activitys.base.BaseAppActivity;
import com.example.hcl.basemvp.mvp.widgets.views.BallsLoadingView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseAppActivity<LoginPresenter> implements LoginContract.ILoginView {
    @BindView(R.id.edit_userName)
    EditText edit_userName;
    @BindView(R.id.edit_userPsw)
    EditText edit_userPsw;

    @BindView(R.id.loading_layout)
    FrameLayout loadingLayout;

    @BindView(R.id.loading_ball)
    BallsLoadingView loading_view;




    @Override
    protected void setupActivityCommponent(AppComponent appComponent) {
        DaggerLoginComponent.builder().appComponent(appComponent)
                .loginMoudle(new LoginMoudle(this))
                .build().inject(this);
    }



    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }


    @Override
    protected void init() {
        super.init();
        edit_userName.setText("world");
        edit_userPsw.setText("123456");
    }

    @Override
    public void hideLoading() {
       loadingLayout.setVisibility(View.GONE);
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
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess(String successMsg) {
        showToast(successMsg);
        startActivity(new Intent(this,MainActivity.class));
    }
}
