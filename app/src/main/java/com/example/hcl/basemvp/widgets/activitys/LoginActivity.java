package com.example.hcl.basemvp.widgets.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.constract.LoginContract;
import com.example.hcl.basemvp.presenters.LoginPresenter;
import com.example.hcl.basemvp.widgets.activitys.base.BaseAppActivity;
import com.example.hcl.basemvp.widgets.views.SmileLoadingView;

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
    protected LoginPresenter bindPresenter() {
        return new LoginPresenter();
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

    @Override
    public void loginFail(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String successMsg) {
        Toast.makeText(this,successMsg,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }
}
