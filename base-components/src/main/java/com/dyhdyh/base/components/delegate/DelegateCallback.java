package com.dyhdyh.base.components.delegate;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * 最基础的回调类
 *
 * @author dengyuhan
 * created 2019/3/15 17:38
 */
public interface DelegateCallback<T> {

    @NonNull T get();

    @LayoutRes
    int getLayoutId();

    void onAfterViews();
}
