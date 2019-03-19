package com.example.hcl.basemvp.daggers.components;

import com.example.hcl.basemvp.annotions.ActivityScope;
import com.example.hcl.basemvp.daggers.moudles.AppMoudle;
import com.example.hcl.basemvp.daggers.moudles.MainMoudle;
import com.example.hcl.basemvp.mvp.models.impls.MainModel;
import com.example.hcl.basemvp.mvp.widgets.activitys.MainActivity;

import dagger.Component;
import dagger.Module;

@ActivityScope
@Component(modules=MainMoudle.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
