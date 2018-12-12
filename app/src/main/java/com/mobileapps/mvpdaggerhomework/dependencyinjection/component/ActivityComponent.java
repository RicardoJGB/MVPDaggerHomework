package com.mobileapps.mvpdaggerhomework.dependencyinjection.component;

import com.mobileapps.mvpdaggerhomework.MainContract;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.MvpModule;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.scope.ActivityScope;
import com.mobileapps.mvpdaggerhomework.view.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    MainContract.PresenterCallBack getMainPresenter();
}
