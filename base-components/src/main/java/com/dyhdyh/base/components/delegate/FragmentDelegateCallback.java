package com.dyhdyh.base.components.delegate;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * fragment的回调类 给fragment实现
 * @author dengyuhan
 * created 2019/3/15 17:38
 */
public interface FragmentDelegateCallback {

    Fragment get();

    /**
     * 初始化参数
     * @param arguments
     */
    void onInitArguments(@NonNull Bundle arguments);


    @LayoutRes int getLayoutId();


    void onAfterViews();
}
