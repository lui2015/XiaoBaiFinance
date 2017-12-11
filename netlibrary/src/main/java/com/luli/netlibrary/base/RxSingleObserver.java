package com.luli.netlibrary.base;

import android.support.annotation.NonNull;

import com.luli.netlibrary.DisposableManager;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by KCrason on 2017/7/6.
 * 实现SingleObserver回调，将请求加入disposable管理
 */

public abstract class RxSingleObserver<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        DisposableManager.from().addSubscribe(d);
    }
}
