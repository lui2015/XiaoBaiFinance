package com.luli.myfastframe.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;

/**
 * UI工具类
 * Created by luli on 2017/9/12.
 */

public class UiUtil {

    private final static Handler HANDLER = new Handler(Looper.myLooper());

    /**
     * 由于dpToPx(int dp)转换不精确,这里用系统实现的方法来计算dp转换成px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources()
                .getDisplayMetrics());
    }

    /**
     * 延迟显示swiperefreshlayout并加载数据
     *
     * @param swipeRefreshLayout
     * @param onStartRefreshListener
     */
    public static void showSwipeRefreshLayout(final SwipeRefreshLayout swipeRefreshLayout, final OnStartRefreshListener onStartRefreshListener) {
        if (swipeRefreshLayout != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!swipeRefreshLayout.isRefreshing()) {
                        swipeRefreshLayout.setRefreshing(true);
                    }
                    if (onStartRefreshListener != null) {
                        HANDLER.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                onStartRefreshListener.onStartRefresh();
                            }
                        }, 200);
                    }
                }
            }, 200);
        }
    }

    public static void hideSwipeRefreshLayout(final SwipeRefreshLayout swipeRefreshLayout) {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }

    public interface OnStartRefreshListener {
        void onStartRefresh();
    }


    /**
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
