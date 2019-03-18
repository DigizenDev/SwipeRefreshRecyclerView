package com.dyhdyh.base.components.delegate.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.dyhdyh.base.components.delegate.DialogDelegate;
import com.dyhdyh.base.components.delegate.DialogDelegateCallback;

/**
 * @author dengyuhan
 * created 2019/3/18 11:54
 */
public class DialogDelegateImpl implements DialogDelegate {
    private DialogDelegateCallback mCallback;

    private Context mContext;
    private View mContentView;

    public DialogDelegateImpl(DialogDelegateCallback callback) {
        this.mCallback = callback;
    }


    @Override
    public void onCreate(Context context) {
        this.mContext = context;
        mCallback.onBeforeViews();
        this.onBuildContentView();
        mCallback.onAfterViews();
    }


    protected void onBuildContentView() {
        mContentView = LayoutInflater.from(mCallback.get().getContext()).inflate(mCallback.getLayoutId(), null);
        mCallback.get().setContentView(mContentView);
        setSize(CONTENT_VIEW, CONTENT_VIEW);
    }

    @Override
    public void setSize(float widthScale, float heightScale) {
        final Window window = mCallback.get().getWindow();
        DisplayMetrics metrics = mCallback.get().getContext().getResources().getDisplayMetrics();
        if (widthScale == WRAP_CONTENT) {
            window.getAttributes().width = WindowManager.LayoutParams.WRAP_CONTENT;
        } else if (widthScale == MATCH_PARENT) {
            window.getAttributes().width = WindowManager.LayoutParams.MATCH_PARENT;
        } else if (widthScale > 0) {
            window.getAttributes().width = (int) ((float) metrics.widthPixels * widthScale);
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                window.getAttributes().width = mContentView.getLayoutParams().width;
            }else{
                window.getAttributes().width = WindowManager.LayoutParams.WRAP_CONTENT;
            }
        }

        if (heightScale == WRAP_CONTENT) {
            window.getAttributes().height = WindowManager.LayoutParams.WRAP_CONTENT;
        } else if (heightScale == MATCH_PARENT) {
            window.getAttributes().height = WindowManager.LayoutParams.MATCH_PARENT;
        } else if (heightScale > 0) {
            window.getAttributes().height = (int) ((float) metrics.heightPixels * heightScale);
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                window.getAttributes().height = mContentView.getLayoutParams().height;
            }else{
                window.getAttributes().height = WindowManager.LayoutParams.WRAP_CONTENT;
            }
        }
    }

    public View getView() {
        return mContentView;
    }

    @NonNull
    @Override
    public Context getRawContext() {
        return mContext;
    }
}
