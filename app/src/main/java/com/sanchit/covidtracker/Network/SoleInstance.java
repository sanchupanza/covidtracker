package com.sanchit.covidtracker.Network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoleInstance {

    public static final String BASE_URL_SERVER = " https://api.covid19india.org/";
    public static final String WORLD_BASE_URL = "https://api.covid19api.com/";


    private static volatile OkHttpClient okHttpClientInstance = null;
    private static volatile Gson gsonInstance = null;
    private static volatile StethoInterceptor stethoInterceptorInstance = null;
    private static volatile Retrofit retrofitInstance = null;
    private static volatile ApiService apiServiceInstance = null;



    private SoleInstance() {
        if (okHttpClientInstance != null) {
            throw new RuntimeException("Can not create this way, please use getOkHttpClientInstance method");
        } else if (stethoInterceptorInstance != null) {
            throw new RuntimeException("Can not create this way, please use getStethoInterceptorInstance method");
        } else if (gsonInstance != null) {
            throw new RuntimeException("Can not create this way, please use getGsonInstance method");
        } else if (retrofitInstance != null) {
            throw new RuntimeException("Can not create this way, please use getRetrofitInstance method");
        } else if (apiServiceInstance != null) {
            throw new RuntimeException("Can not create this way, please use getApiServiceInstance method");
        } /*else if (picassoInstance != null) {
            throw new RuntimeException("Can not create this way, please use getPicassoInstance method");
        } else if (appDatabase != null) {
            throw new RuntimeException("Can not create this way, please use getAppDatabase method");
        }*/
    }


    public static ApiService getApiServiceInstance() {
        if (apiServiceInstance == null) {
            synchronized (SoleInstance.class) {
                if (apiServiceInstance == null) {
                    apiServiceInstance = getRetrofitInstance().create(ApiService.class);
                }
            }
        }
        return apiServiceInstance;
    }

    public static ApiService getWorldApiServiceInstance() {
        if (apiServiceInstance == null) {
            synchronized (SoleInstance.class) {
                if (apiServiceInstance == null) {
                    apiServiceInstance = getWorldRetrofitInstance().create(ApiService.class);
                }
            }
        }
        return apiServiceInstance;
    }

    public static Retrofit getWorldRetrofitInstance() {
        if (retrofitInstance == null) {
            synchronized (SoleInstance.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(WORLD_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(getGsonInstance()))
                            .client(getOkHttpClientInstance())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }


    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            synchronized (SoleInstance.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL_SERVER)
                            .addConverterFactory(GsonConverterFactory.create(getGsonInstance()))
                            .client(getOkHttpClientInstance())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }

    public static Gson getGsonInstance() {
        if (gsonInstance == null) {
            synchronized (SoleInstance.class) {
                if (gsonInstance == null) {
                    gsonInstance = new GsonBuilder()
                            .setLenient()
                            .create();
                }
            }
        }
        return gsonInstance;
    }

    public static OkHttpClient getOkHttpClientInstance() {
        if (okHttpClientInstance == null) {
            synchronized (SoleInstance.class) {
                if (okHttpClientInstance == null) {
                    okHttpClientInstance = new OkHttpClient.Builder()
                            .addNetworkInterceptor(getStethoInterceptorInstance()).build();
                }
            }
        }
        return okHttpClientInstance;
    }
    private static StethoInterceptor getStethoInterceptorInstance() {
        if (stethoInterceptorInstance == null) {
            synchronized (SoleInstance.class) {
                if (stethoInterceptorInstance == null) {
                    stethoInterceptorInstance = new StethoInterceptor();
                }
            }
        }
        return stethoInterceptorInstance;
    }


}
