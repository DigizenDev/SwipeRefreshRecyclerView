package com.dyhdyh.base.components.delegate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * activity的回调类
 * @author dengyuhan
 * created 2019/3/15 17:55
 */
public interface ActivityDelegateCallback extends DelegateCallback<AppCompatActivity> {

    void onInitIntent(@NonNull Intent intent);

    void onBuildSystemBar();

}
