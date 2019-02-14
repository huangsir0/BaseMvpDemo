package com.example.hcl.basemvp.widgets.activitys.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Dagger
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        BaseApp baseApp= (BaseApp) getApplication();
        setupActivityCommponent(baseApp.getAppComponent());
        init();
    }

    protected abstract void setupActivityCommponent(AppComponent appComponent);

    /***
     * 初始化工作
     */
    protected abstract void init();

    /**
     * 布局ID
     *
     * @return
     */
    protected abstract int getLayoutID();

}
