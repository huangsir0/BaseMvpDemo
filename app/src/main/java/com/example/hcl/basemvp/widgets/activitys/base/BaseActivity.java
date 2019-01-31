package com.example.hcl.basemvp.widgets.activitys.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);

        init();
    }

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
