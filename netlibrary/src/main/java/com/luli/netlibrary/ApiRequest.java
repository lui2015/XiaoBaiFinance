package com.luli.netlibrary;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by KCrason on 2017/7/4.
 */

public class ApiRequest {


    //rxjava构造器
    public final static RxJava2CallAdapterFactory RX_JAVA_2_CALL_ADAPTER_FACTORY = RxJava2CallAdapterFactory.create();

    //gson解析器
    public final static GsonConverterFactory GSON_CONVERTER_FACTORY = GsonConverterFactory.create();

    //返回String的构造器
    public final static ScalarsConverterFactory SCALARS_CONVERTER_FACTORY = ScalarsConverterFactory.create();


    //构建自定义okhttpclient自定义重连3次。
    public final static OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();


    public static <S> S createService(Class<S> sClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OK_HTTP_CLIENT)
                .addConverterFactory(GSON_CONVERTER_FACTORY)
                .addCallAdapterFactory(RX_JAVA_2_CALL_ADAPTER_FACTORY)
                .build();
        return retrofit.create(sClass);
    }


    public static <S> S createNoAdapterService(Class<S> sClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OK_HTTP_CLIENT)
                .addConverterFactory(GSON_CONVERTER_FACTORY)
                .build();
        return retrofit.create(sClass);
    }

    /**
     * 构建返回String类型的retrofit,
     * 该构造器用于需要手动解析数据时使用
     *
     * @param sClass
     * @param baseUrl
     * @param <S>
     * @return
     */
    public static <S> S createScalarService(Class<S> sClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OK_HTTP_CLIENT)
                .addConverterFactory(SCALARS_CONVERTER_FACTORY)
                .addCallAdapterFactory(RX_JAVA_2_CALL_ADAPTER_FACTORY)
                .build();
        return retrofit.create(sClass);
    }


}
