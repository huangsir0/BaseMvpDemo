package com.example.hcl.basemvp.others.utils;

import com.example.hcl.basemvp.others.constant.AppConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {


    private Retrofit mRetrofit;

    private HttpUtils(){
        init();
    }


    private static class SingleInstance{
        private static final  HttpUtils Instance=new HttpUtils();
    }

    public static  HttpUtils Instance(){
        return SingleInstance.Instance;
    }

    private void init() {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.connectTimeout(6000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        //添加拦截
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        builder.addInterceptor(logInterceptor);
        OkHttpClient client = builder.build();

        mRetrofit=new Retrofit
                .Builder()
                .baseUrl(AppConstant.Url.BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

    /**
     * 创建Api
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> cls){return mRetrofit.create(cls);}

}
