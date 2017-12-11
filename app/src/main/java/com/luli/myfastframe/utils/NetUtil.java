package com.luli.myfastframe.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.luli.myfastframe.base.Constants;
import com.luli.myfastframe.net.Api;
import com.luli.netlibrary.ApiRequest;
import com.luli.netlibrary.RxSchedulers;
import com.luli.netlibrary.base.RxSingleObserverSuccess;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Function;

/**
 * Created by luli on 2017/12/5.
 */

public class NetUtil {


    /**
     * 获取网络请求map
     */
    public static Map<String, String> getRequestMap() {
        Map<String, String> map = new HashMap<>();
        map.put(Constants.FID_USER, Constants.FID_USER_NAME);
        map.put(Constants.FID_KEY, Constants.FID_KEY_VALUE);
       /* if (hasNetWorkConection(AppLogic.getAppContext())) {
            Toast.makeText(AppLogic.getAppContext(), "亲，当前网络不可用，请检查网络!", Toast.LENGTH_SHORT).show();
        }*/

        return map;
    }


    public static void senRequest(final GetNetDataListener listener, Map<String, String> map, final String tag) {
        LogUtil.request("获取" + tag + "请求：" + map.toString());
        ApiRequest.createScalarService(Api.class, Constants.baseUrl).queryData(map)
                .map(new Function<String, String>() {
                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        LogUtil.response("获取" + tag + "返回：" + s);
                        return s;
                    }
                })
                .compose(RxSchedulers.<String>applySingleSchedulers())
                .subscribe(new RxSingleObserverSuccess<String>() {
                    @Override
                    public void onSuccess(@NonNull String response) {
                        listener.onSuccess(response);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                        listener.onError(e);
                    }
                });
    }


    public interface GetNetDataListener {
        void onSuccess(String response);
        void onError(Throwable e);
    }


    /**
     * 判断是否具有网络连接
     *
     * @param context
     * @return
     */
    public static final boolean hasNetWorkConection(Context context) {
        //获取连接活动管理器
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取连接的网络信息
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isAvailable());
    }

    /**
     * 判断是否具有wifi连接
     *
     * @param context
     * @return
     */
    public static final boolean hasWifiConnection(Context context) {
        //获取连接活动管理器
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return (networkInfo != null && networkInfo.isAvailable());
    }

    /**
     * 判断是否有GPRS连接
     *
     * @param context
     * @return
     */
    public static final boolean hasGPRSConnection(Context context) {
        //获取连接活动管理器
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return (networkInfo != null && networkInfo.isAvailable());
    }

    /**
     * 判断网络连接类型
     *
     * @param context
     * @return
     */
    public static final int getNetworkConnectionType(Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo wifiNetWorkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final NetworkInfo mobileNetWorkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiNetWorkInfo != null && wifiNetWorkInfo.isAvailable()) {
            return ConnectivityManager.TYPE_WIFI;
        } else if (mobileNetWorkInfo != null && mobileNetWorkInfo.isAvailable()) {
            return ConnectivityManager.TYPE_MOBILE;
        } else {
            return -1;
        }
    }
}
