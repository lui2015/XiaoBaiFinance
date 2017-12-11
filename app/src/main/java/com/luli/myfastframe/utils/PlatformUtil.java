package com.luli.myfastframe.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

/**
 * 第三方平台工具类
 * Created by luli on 2017/11/30.
 */

public class PlatformUtil {


    public final static int PLATFORM_WEIXIN = 1;//微信
    public final static int PLATFORM_QQ = 2;//QQ
    public final static int PLATFORM_WEIBO = 3;//微博
    public final static int PLATFORM_ALIPAY = 4;//支付宝


    /**
     * 检查平台是否可用
     */
    public static boolean isPlatformAvilible(Context context, int type) {
        String toast = "";
        boolean isAvilible=false;
        switch (type) {
            case PLATFORM_WEIXIN:
                toast="您的手机还没有安装微信哦~";
                isAvilible=isWeixinAvilible(context);
                break;
            case PLATFORM_QQ:
                toast="您的手机还没有安装QQ哦~";
                isAvilible=isQQClientAvailable(context);
                break;
            case PLATFORM_WEIBO:
                toast="您的手机还没有安装微博哦~";
                isAvilible=isWeiboAvailable(context);
                break;
            case PLATFORM_ALIPAY:
                toast="您的手机还没有安装支付宝哦~";
                isAvilible=isAliPayClientAvailable(context);
                break;
        }
        if(!isAvilible)
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
        return isAvilible;
    }


    /**
     * 判断微信是否可用
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 判断支付宝是否可用
     *
     * @param context
     * @return
     */
    public static boolean isAliPayClientAvailable(Context context) {

        Uri uri = Uri.parse("alipays://platformapi/startApp");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        ComponentName componentName = intent.resolveActivity(context.getPackageManager());
        return componentName != null;
    }

    /**
     * 判断微博是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeiboAvailable(Context context) {
        PackageManager pm;
        if ((pm = context.getApplicationContext().getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("com.sina.weibo".equals(name)) {
                return true;
            }
        }
        return false;
    }
}
