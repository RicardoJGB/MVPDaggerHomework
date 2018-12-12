package com.mobileapps.mvpdaggerhomework.dependencyinjection.module;

import com.mobileapps.mvpdaggerhomework.model.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public Model provideModelClass() {
        return new Model();
    }
}
