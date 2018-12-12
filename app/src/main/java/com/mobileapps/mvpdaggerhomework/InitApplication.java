package com.mobileapps.mvpdaggerhomework;

import android.app.Application;
import android.content.Context;

import com.mobileapps.mvpdaggerhomework.dependencyinjection.component.AppComponent;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.component.DaggerAppComponent;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.AppModule;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.ContextModule;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.DataModule;

public class InitApplication extends Application {

    private AppComponent component;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent component() {
        return component;
    }
}
