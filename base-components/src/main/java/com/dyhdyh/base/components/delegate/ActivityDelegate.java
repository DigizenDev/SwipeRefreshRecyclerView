package com.dyhdyh.base.components.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author dengyuhan
 * created 2019/3/15 17:53
 */
public interface ActivityDelegate {

    void onBeforeCreate(@Nullable Bundle savedInstanceState);

    void onCreate(@Nullable Bundle savedInstanceState);

    @NonNull
    View onBuildContentView(View view);

    ViewGroup getRootView();

    View getContentView();
}
