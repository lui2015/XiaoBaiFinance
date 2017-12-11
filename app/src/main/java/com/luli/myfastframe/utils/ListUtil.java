package com.luli.myfastframe.utils;

import java.util.List;

/**
 * List工具类
 * Created by luli on 2017/5/12.
 */

public class ListUtil {


    /**
     * 判断列表是否为空
     * */
    public static boolean isEmpty(List list) {
        if (list != null && list.size() > 0) {
            return false;
        }
        else{
            return true;
        }
    }
}
