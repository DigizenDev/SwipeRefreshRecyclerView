package com.dyhdyh.base.components.delegate.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dyhdyh.base.components.R;
import com.dyhdyh.base.components.delegate.ActivityDelegate;
import com.dyhdyh.base.components.delegate.ActivityDelegateCallback;

/**
 * BaseActivity的具体逻辑实现
 *
 * @author dengyuhan
 * created 2019/3/15 18:04
 */
public class ActivityDelegateImpl implements ActivityDelegate {
    private ActivityDelegateCallback mCallback;

    //最外层的View
    private ViewGroup mRootView;
    //传入的Layout
    private View mContentView;

    public ActivityDelegateImpl(@NonNull ActivityDelegateCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void onBeforeCreate(@Nullable Bundle savedInstanceState) {
        mCallback.onBeforeCreate(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        final Intent intent = mCallback.get().getIntent();
        if (intent != null) {
            mCallback.onInitIntent(intent);
        }
        mCallback.onBuildSystemBar();

        mCallback.get().setContentView(mCallback.getContentViewId());

        mCallback.onAfterViews(savedInstanceState);
    }

    @NonNull
    @Override
    public View onBuildContentView(View view) {
        mRootView = buildRootView();
        ViewGroup contentContainer = mRootView.findViewById(R.id.content_container);
        //如果有content_container就添加到content_container，没有就添加到activity_container
        if (contentContainer == null) {
            contentContainer = mRootView;
        }
        mContentView = LayoutInflater.from(mCallback.get()).inflate(mCallback.getContentViewId(), contentContainer, false);
        contentContainer.addView(mContentView);

        //Toolbar View
        View toolbarView = mRootView.findViewById(R.id.toolbar);
        if (toolbarView != null) {
            mCallback.onBuildToolbarView(toolbarView);
        }
        return mRootView;
    }


    protected @NonNull
    ViewGroup buildRootView() {
        return (ViewGroup) LayoutInflater.from(mCallback.get()).inflate(mCallback.getRootViewId(), null);
    }

    @Override
    public ViewGroup getRootView() {
        return mRootView;
    }

    @Override
    public View getContentView() {
        return mContentView;
    }
}
