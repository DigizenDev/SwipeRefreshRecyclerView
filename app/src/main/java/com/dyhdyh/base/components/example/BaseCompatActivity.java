package com.dyhdyh.base.components.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.dyhdyh.base.components.delegate.ActivityDelegate;
import com.dyhdyh.base.components.delegate.ActivityDelegateCallback;
import com.dyhdyh.base.components.delegate.impl.ActivityDelegateImpl;

/**
 * @author dengyuhan
 * created 2018/12/16 03:13
 */
public abstract class BaseCompatActivity extends AppCompatActivity implements ActivityDelegateCallback {
    protected ActivityDelegate mDelegate;

    @NonNull
    @Override
    public Activity get() {
        return this;
    }

    @NonNull
    @Override
    public ActivityDelegate delegate() {
        if (mDelegate == null) {
            mDelegate = new ActivityDelegateImpl(this);
        }
        return mDelegate;
    }

    @Override
    public void onBeforeCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onInitIntent(@NonNull Intent intent) {

    }

    @Override
    public void onBuildSystemBar() {

    }

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public void onBuildToolbarView(@NonNull View toolbarView) {

    }


    @NonNull
    @Override
    public View getRootView() {
        return delegate().getRootView();
    }

    @NonNull
    @Override
    public View getContentView() {
        return delegate().getContentView();

    }

}
