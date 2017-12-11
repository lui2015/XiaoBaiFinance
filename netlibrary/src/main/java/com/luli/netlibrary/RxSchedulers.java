package com.luli.netlibrary;

import android.support.annotation.NonNull;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by KCrason on 2017/7/6.
 */

public class RxSchedulers {

    final static CompletableTransformer COMPLETABLE_TRANSFORMER = new CompletableTransformer() {
        @Override
        public CompletableSource apply(@NonNull Completable upstream) {
            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };


    final static SingleTransformer SINGLE_TRANSFORMER = new SingleTransformer() {
        @Override
        public SingleSource apply(@NonNull Single upstream) {
            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };


    final static FlowableTransformer FLOWABLE_TRANSFORMER = new FlowableTransformer() {
        @Override
        public Publisher apply(@NonNull Flowable upstream) {
            return  upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };


    final static ObservableTransformer OBSERVABLE_TRANSFORMER = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    };


    /**
     * Single从io转到主线程
     *
     * @param <T>
     * @return
     */
    public static <T> SingleTransformer<T, T> applySingleSchedulers() {
        return SINGLE_TRANSFORMER;
    }


    /**
     * Completable从io转到主线程
     *
     * @param <T>
     * @return
     */
    public static CompletableTransformer applyCompletableSchedulers() {
        return COMPLETABLE_TRANSFORMER;
    }

    /**
     * Flowable从io切换到main
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> applyFlowableSchedulers() {
        return FLOWABLE_TRANSFORMER;
    }

    /**
     * Observable从io转main
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> applyObservableSchedulers() {
        return OBSERVABLE_TRANSFORMER;
    }

}
