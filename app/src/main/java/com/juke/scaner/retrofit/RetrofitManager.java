package com.juke.scaner.retrofit;

import com.juke.scaner.constacts.Constacts;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/29.
 */

public class RetrofitManager {

    private volatile static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    //无参的单利模式
    public static RetrofitManager getSingleton() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }

    //无参的构造方法
    private RetrofitManager() {
        initRetrofitManager();
    }

    //构造方法创建Retrofit实例
    private void initRetrofitManager() {
        retrofit = new Retrofit.Builder().baseUrl(Constacts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //构造方法创建Retrofit实例
    private RetrofitManager buildRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(Constacts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofitManager;
    }


    private OkHttpClient getClient() {
        CommonInterceptor commonInterceptor = new CommonInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(commonInterceptor)
                .build();
        return client;
    }

    public RetrofitService RetrofitService() {
        return retrofit.create(RetrofitService.class);
    }
}
