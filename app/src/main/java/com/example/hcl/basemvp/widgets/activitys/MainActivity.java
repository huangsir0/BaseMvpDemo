package com.example.hcl.basemvp.widgets.activitys;

import android.view.View;

import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.constract.MainContract;
import com.example.hcl.basemvp.presenters.MainPresenter;
import com.example.hcl.basemvp.widgets.activitys.base.BaseAppActivity;

public class MainActivity extends BaseAppActivity<MainPresenter> implements MainContract.IMainView {


    @Override
    protected MainPresenter bindPresenter() {
        return new MainPresenter();
    }



    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

}
