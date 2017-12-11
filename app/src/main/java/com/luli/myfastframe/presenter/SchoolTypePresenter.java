package com.luli.myfastframe.presenter;

import android.support.annotation.NonNull;

import com.luli.myfastframe.base.Constants;
import com.luli.myfastframe.net.Api;
import com.luli.myfastframe.utils.LogUtil;
import com.luli.myfastframe.utils.NetUtil;
import com.luli.myfastframe.utils.StringUtil;
import com.luli.myfastframe.views.viewInterface.SchoolTypeView;
import com.luli.netlibrary.ApiRequest;
import com.luli.netlibrary.RxSchedulers;
import com.luli.netlibrary.base.RxSingleObserverSuccess;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Function;


/**
 * 学堂分类列表页面接口呈现类
 * Created by luli on 2017/5/17.
 */

public class SchoolTypePresenter {
    private SchoolTypeView mSchoolView;

    public SchoolTypePresenter(SchoolTypeView schoolView) {
        this.mSchoolView = schoolView;
    }

    /**
     * 获取学堂列表
     */
    public void getSchoolDetailList() {
        Map<String, String> map = NetUtil.getRequestMap();
        LogUtil.request("获取学堂分类列表请求：：" + map.toString());
    }
}
