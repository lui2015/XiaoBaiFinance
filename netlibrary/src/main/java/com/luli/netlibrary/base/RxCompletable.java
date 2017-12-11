package com.luli.netlibrary.base;

import android.support.annotation.NonNull;


import com.luli.netlibrary.DisposableManager;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by KCrason on 2017/7/11.
 */

public class RxCompletable implements CompletableObserver {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        DisposableManager.from().addSubscribe(d);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }
}
