package com.example.hcl.basemvp.widgets.activitys;



import com.example.hcl.basemvp.R;
import com.example.hcl.basemvp.mvp.constract.MainContract;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import com.example.hcl.basemvp.mvp.presenters.MainPresenter;
import com.example.hcl.basemvp.widgets.activitys.base.BaseAppActivity;

public class MainActivity extends BaseAppActivity<MainPresenter> implements MainContract.IMainView {


    @Override
    protected void setupActivityCommponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

}
