package com.lucifer.utils;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpUtil {

    public static OkHttpClient normalInstance() {
        return new OkHttpClient.Builder()
//                .followRedirects(false)
//                .followSslRedirects(false)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpClient notRedirectInstance() {
        return new OkHttpClient.Builder()
                .followRedirects(false)
                .followSslRedirects(false)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
    }

//    public static OkHttpClient _10SenondInstance() {
//        return new OkHttpClient.Builder()
////                .followRedirects(false)
////                .followSslRedirects(false)
//                .readTimeout(10, TimeUnit.SECONDS)
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .build();
//    }
}
