package com.mobileapps.mvpdaggerhomework.dependencyinjection.component;

import android.app.Application;
import android.content.Context;

import com.mobileapps.mvpdaggerhomework.InitApplication;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.AppModule;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.ContextModule;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.DataModule;
import com.mobileapps.mvpdaggerhomework.model.Model;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();

    Model getFindItemsInteractor();

    Application getApplication();
}
