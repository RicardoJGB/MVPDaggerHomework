package com.mobileapps.mvpdaggerhomework.dependencyinjection.module;

import android.app.Application;

import com.mobileapps.mvpdaggerhomework.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private InitApplication initApplication;

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return initApplication;
    }
}