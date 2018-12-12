package com.mobileapps.mvpdaggerhomework.dependencyinjection.module;

import com.mobileapps.mvpdaggerhomework.MainContract;
import com.mobileapps.mvpdaggerhomework.model.Model;
import com.mobileapps.mvpdaggerhomework.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {

    private MainContract.ViewCallBack viewCallBack;

    public MvpModule(MainContract.ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Provides
    public MainContract.ViewCallBack provideView() {
        return viewCallBack;
    }

    @Provides
    public MainContract.PresenterCallBack providePresenter(MainContract.ViewCallBack view, Model model) {
        return new MainPresenterImpl(view, model);
    }
}
