package com.example.hcl.basemvp.mvp.widgets.fragments.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hcl.basemvp.BaseApp;
import com.example.hcl.basemvp.mvp.BasePresenter;
import com.example.hcl.basemvp.mvp.IBaseView;
import com.example.hcl.basemvp.daggers.components.AppComponent;
import javax.inject.Inject;
import butterknife.ButterKnife;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected View rootView;

    @Inject
    protected P mPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =initView(inflater,container,savedInstanceState);
        ButterKnife.bind(this,rootView);
        return  rootView;
        //return inflater.inflate(R.layout.fragment_base, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseApp baseApp= (BaseApp) getActivity().getApplicationContext();
        setupActivityCommponent(baseApp.getAppComponent());
        initData();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter=null;
        this.rootView=null;
    }

    protected abstract void initData();

    protected abstract void setupActivityCommponent(AppComponent appComponent);

    /**
     * 初始化视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}
