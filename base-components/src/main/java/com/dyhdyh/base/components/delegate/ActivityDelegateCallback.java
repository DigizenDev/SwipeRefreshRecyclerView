package com.dyhdyh.base.components.delegate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * activity的回调类
 *
 * @author dengyuhan
 * created 2019/3/15 17:55
 */
public interface ActivityDelegateCallback{

    @NonNull
    Activity get();

    @NonNull
    ActivityDelegate delegate();

    void onBeforeCreate(@Nullable Bundle savedInstanceState);

    void onInitIntent(@NonNull Intent intent);

    void onBuildSystemBar();

    @LayoutRes
    int getRootViewId();

    @LayoutRes
    int getContentViewId();

    void onBuildToolbarView(@NonNull View toolbarView);

    void onAfterViews(@Nullable Bundle savedInstanceState);

    @NonNull
    View getRootView();

    @NonNull
    View getContentView();

}
