package com.example.hcl.basemvp.constract;

import com.example.hcl.basemvp.BasePresenter;
import com.example.hcl.basemvp.IBaseView;

/**
 * Main契约接口
 */
public interface MainContract {

    interface IMainView extends IBaseView{

    }


    abstract class IMainPresenter extends BasePresenter<IMainView> {

    }
}
