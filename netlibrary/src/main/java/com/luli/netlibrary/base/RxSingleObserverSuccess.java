package com.luli.netlibrary.base;

import android.support.annotation.NonNull;

/**
 * Created by KCrason on 2017/7/6.
 * 只返回成功方法
 */

public abstract class RxSingleObserverSuccess<T> extends RxSingleObserver<T> {
    @Override
    public void onError(@NonNull Throwable e) {

    }
}
