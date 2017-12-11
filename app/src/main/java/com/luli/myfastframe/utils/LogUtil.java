package com.luli.myfastframe.utils;

import android.util.Log;
import com.luli.myfastframe.base.AppConfig;
import com.luli.myfastframe.base.Constants;

/**
 * 日志工具类
 * Created by luli
 */
public class LogUtil {
    /**
     * 打印网络请求日志
     */
    static public void request(String str) {
        if (AppConfig.debugFlag) {
            Log.w(Constants.logRequest, str);
        }
    }

    /**
     * 打印网络返回日志
     */
    static public void response(String str) {
        if (AppConfig.debugFlag)
            Log.w(Constants.logResponse, str);
    }

    /**
     * 打印个性化日志
     */
    static public void logPersonalDebug(String name, String str) {
        if (AppConfig.debugFlag)
            Log.i(name, str);
    }

    /**
     * 打印一般调试日志
     */
    static public void logDebug(String str) {
        if (AppConfig.debugFlag)
            Log.i(Constants.logDebug, str);
    }


    /**
     * 打印错误日志
     */
    static public void logError(String str) {

        if (AppConfig.debugFlag) {
            Log.e(Constants.logError, str);
        }
    }


}
