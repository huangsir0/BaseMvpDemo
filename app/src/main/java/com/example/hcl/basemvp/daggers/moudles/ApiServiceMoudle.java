package com.example.hcl.basemvp.daggers.moudles;

import com.example.hcl.basemvp.others.net.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiServiceMoudle {

    @Singleton
    @Provides
    Api provideUserService(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}
