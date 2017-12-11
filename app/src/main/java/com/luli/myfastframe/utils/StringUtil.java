package com.luli.myfastframe.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 工具类
 * Created by luli on 16/7/22.
 */
public class StringUtil {

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0||str.equals("null");
    }

    /**
     * 判断是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 是否包含某个字符串
     */
    public static boolean contains(String str, String searchStr) {
        if (str == null || searchStr == null)
            return false;
        else
            return str.indexOf(searchStr) >= 0;
    }

    /**
     * 字符替换
     */
    public static String replace(String text, String searchString,
                                 String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    /**
     * 字符替换
     */
    public static String replace(String text, String searchString,
                                 String replacement, int max) {
        if (isEmpty(text) || isEmpty(searchString) || replacement == null
                || max == 0)
            return text;
        int start = 0;
        int end = text.indexOf(searchString, start);
        if (end == -1)
            return text;
        int replLength = searchString.length();
        int increase = replacement.length() - replLength;
        increase = increase >= 0 ? increase : 0;
        increase *= max >= 0 ? max <= 64 ? max : 64 : 16;
        StringBuffer buf = new StringBuffer(text.length() + increase);
        do {
            if (end == -1)
                break;
            buf.append(text.substring(start, end)).append(replacement);
            start = end + replLength;
            if (--max == 0)
                break;
            end = text.indexOf(searchString, start);
        } while (true);
        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
     * 移除某个字符串
     */
    public static String remove(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove))
            return str;
        else
            return replace(str, remove, "", -1);
    }

    /**
     * 移除某个字符
     */
    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == -1)
            return str;
        char chars[] = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++)
            if (chars[i] != remove)
                chars[pos++] = chars[i];

        return new String(chars, 0, pos);
    }

    /**
     * 判断是否为纯数字
     */
    public static boolean isNumeric(String str) {
        if (str == null)
            return false;
        int sz = str.length();
        for (int i = 0; i < sz; i++)
            if (!Character.isDigit(str.charAt(i)))
                return false;

        return true;
    }

    /**
     * 判断数字字符串是否是小数
     *
     * @param value
     * @return
     */
    public static boolean isBigDecimal(String value) {
        double n = Double.parseDouble(value);
        int temp;
        double i;
        temp = (int) n;
        i = n - temp;
        if (i == 0) {
            return false;
        } else
            return true;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否为英文
     */
    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");
    }


    /**
     * 将数字转为数字加汉字数字单位
     * */
    public static String getChineseNumUnitString(long num) {
        int count=0;
        long temp=num;
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
        while(Math.abs(temp)%10>0||temp/10!=0){
            count++;
            temp=temp/10;
        }
        if(count>4&count<=8){
            return num/10000+"万";
        } else if(count>8){
            return df.format((double)num/100000000)+"亿";
        }else{
            return num+"元";
        }
    }
}
