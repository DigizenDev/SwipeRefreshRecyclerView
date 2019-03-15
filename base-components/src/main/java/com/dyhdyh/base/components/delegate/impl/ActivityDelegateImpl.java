package com.dyhdyh.base.components.delegate.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.dyhdyh.base.components.delegate.ActivityDelegate;
import com.dyhdyh.base.components.delegate.ActivityDelegateCallback;

/**
 * @author dengyuhan
 * created 2019/3/15 18:04
 */
public class ActivityDelegateImpl implements ActivityDelegate {
    private ActivityDelegateCallback mCallback;

    private View mContentView;

    public ActivityDelegateImpl(@NonNull ActivityDelegateCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        final Intent intent = mCallback.get().getIntent();
        if (intent != null) {
            mCallback.onInitIntent(intent);
        }
        mCallback.onBuildSystemBar();

        mCallback.onAfterViews();
    }


}
