package com.luli.myfastframe.utils;

import java.text.NumberFormat;

/**
 * 数字处理工具类
 * Created by luli on 17/4/19.
 */

public class NumberUtil {


    /**
     * 保留两位小数
     */
    public static String format(Double data) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        return df.format(data);
    }


    /**
     * 格式化为百分数保留两位小数
     */
    public static String formatWithPercent(Double data) {
        data = data * 100;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        return df.format(data) + "%";
    }


    /**
     * 长数据保留两位小数
     */
    public static String bigDataFormat(Double data) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return df.format(Double.parseDouble(nf.format(data)));
    }


    /**
     * 长数据格式化为百分数并保留两位小数
     */
    public static String bigDataFormatWithPercent(Double data) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        data = Double.parseDouble(nf.format(data)) * 100;
        return df.format(data) + "%";
    }


}
