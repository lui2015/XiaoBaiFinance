package com.luli.netlibrary;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by KCrason on 2017/7/5.
 * 管理rxjava网络请求，onDestory()时调用removeSubscribe()方法取消请求。
 */

public class DisposableManager {

    private CompositeDisposable mCompositeDisposable;


    private final static DisposableManager DISPOSABLE_MANAGER = new DisposableManager();

    public synchronized static DisposableManager from() {
        return DISPOSABLE_MANAGER;
    }


    /**
     * 将请求加入队列
     *
     * @param disposable
     */
    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        //注意该处不要将一个为null的disposable加入到CompositeDisposable中，否则会抛出异常而导致接收不到对应的事件
        if (disposable != null) {
            mCompositeDisposable.add(disposable);
        }
    }

    /**
     * 取消某一个请求。
     *
     * @param disposable
     */
    public void removeSubscribe(Disposable disposable) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.remove(disposable);
        }
    }

    /**
     * 清空所有队列请求。
     */
    public void clearSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
