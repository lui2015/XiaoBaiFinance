package com.luli.myfastframe.net;

import java.util.Map;
import io.reactivex.Single;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * Created by luli on 2017/12/5.
 */

public interface Api {

    /**
     * 获取资讯学堂页数据
     */
    @FormUrlEncoded
    @POST("fidnews/v1/geek/v3/queryWhiteList")
    Single<String> queryData(@FieldMap Map<String, String> stringMap);

}
