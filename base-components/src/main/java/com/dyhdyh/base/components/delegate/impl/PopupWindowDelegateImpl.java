package com.dyhdyh.base.components.delegate.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.widget.PopupWindowCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.dyhdyh.base.components.delegate.PopupWindowDelegate;
import com.dyhdyh.base.components.delegate.PopupWindowDelegateCallback;

/**
 * @author dengyuhan
 * created 2019/3/18 11:54
 */
public class PopupWindowDelegateImpl implements PopupWindowDelegate {
    private PopupWindowDelegateCallback mCallback;

    private Context mContext;
    private View mContentView;

    public PopupWindowDelegateImpl(PopupWindowDelegateCallback callback) {
        this.mCallback = callback;
    }


    @Override
    public void onCreate(Context context) {
        this.mContext = context;
        this.onBeforeViews();
        this.onBuildContentView();
        mCallback.onAfterViews();
    }


    protected void onBeforeViews() {
        //让返回键和点击外面消失
        mCallback.get().setOutsideTouchable(true);
        mCallback.get().setFocusable(true);
        mCallback.get().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mCallback.onBeforeViews();
    }


    protected void onBuildContentView() {
        mContentView = LayoutInflater.from(mContext).inflate(mCallback.getLayoutId(), null);
        mCallback.get().setContentView(mContentView);
        setSize(CONTENT_VIEW, CONTENT_VIEW);
    }

    @Override
    public void setSize(float widthScale, float heightScale) {
        final PopupWindow window = mCallback.get();
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        if (widthScale == WRAP_CONTENT) {
            window.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (widthScale == MATCH_PARENT) {
            window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        } else if (widthScale > 0) {
            window.setWidth((int) ((float) metrics.widthPixels * widthScale));
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                window.setWidth(mContentView.getLayoutParams().width);
            } else {
                window.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }

        if (heightScale == WRAP_CONTENT) {
            window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (heightScale == MATCH_PARENT) {
            window.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        } else if (heightScale > 0) {
            window.setHeight((int) ((float) metrics.heightPixels * heightScale));
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                window.setHeight(mContentView.getLayoutParams().height);
            } else {
                window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        final int DEFAULT_ANCHORED_GRAVITY = Gravity.TOP | Gravity.START;
        PopupWindowCompat.showAsDropDown(mCallback.get(), anchor, xoff, yoff, DEFAULT_ANCHORED_GRAVITY);
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
