
package com.example.hcl.basemvp.daggers.components;


import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.daggers.moudles.LoginMoudle;
import com.example.hcl.basemvp.mvp.widgets.activitys.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = LoginMoudle.class,dependencies = AppComponent.class)
public interface LoginComponent {


    /**
     * 注入
     *
     * @param activity
     */
    void inject(LoginActivity activity);


}

