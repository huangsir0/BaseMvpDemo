package com.example.hcl.basemvp.daggers.moudles;

import com.example.hcl.basemvp.others.constant.AppConstant;
import com.example.hcl.basemvp.others.net.Api;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpMoudle {


    /**
     * 连接超时时间，单位s
     */
    private static final byte DEFAULT_CONNECT_TIMEOUT = 10;
    /**
     * 读超时时间，单位s
     */
    private static final int DEFAULT_READ_TIMEOUT = 10;
    /**
     * 写超时时间，单位s
     */
    private static final int DEFAULT_WRITE_TIMEOUT = 10;




    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit
                .Builder()
                .baseUrl(AppConstant.Url.BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        //添加拦截
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        builder.addInterceptor(logInterceptor);
        return builder.build();
    }



}
