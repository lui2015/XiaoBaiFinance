package com.luli.myfastframe.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * Created by luli on 2017/9/18.
 */

public class TimeUtil {

    public static String displayInfoTime(long timestamp) {
        String timeStr = null;
        long currentSeconds = System.currentTimeMillis();//系统当前时间
        long timeGapHour = (currentSeconds - timestamp) / (1000 * 60 * 60);//差距多少个小时
        long timeGap = (currentSeconds - timestamp) / 1000;
        SimpleDateFormat mh = new SimpleDateFormat("MM-dd HH:mm");
        SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
        String timenow = hm.format(new Date());
        int hour = Integer.valueOf(timenow.split(":")[0]);//当前时间的小时数
        if (timeGapHour == 0) {
            long t = timeGap / 60;
            if (t != 0) {
                timeStr = t + " 分钟前";
            } else {
                timeStr = "刚刚";
            }
        }
        if (timeGapHour > 0 && timeGapHour < 24) {
            timeStr = timeGapHour + "小时前";
        }
        if (timeGapHour >= 24) {
            int day = (int) (timeGapHour / 24);
            timeStr = day + "天前";
        }
        return timeStr;
    }
}
