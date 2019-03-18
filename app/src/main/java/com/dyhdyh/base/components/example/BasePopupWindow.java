package com.dyhdyh.base.components.example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.PopupWindow;
import com.dyhdyh.base.components.delegate.PopupWindowDelegate;
import com.dyhdyh.base.components.delegate.PopupWindowDelegateCallback;
import com.dyhdyh.base.components.delegate.impl.PopupWindowDelegateImpl;

/**
 * @author dengyuhan
 * created 2019/3/18 16:05
 */
public abstract class BasePopupWindow extends PopupWindow implements PopupWindowDelegateCallback {
    protected PopupWindowDelegate mDelegate;

    public BasePopupWindow(Context context) {
        super(context);
        delegate().onCreate(context);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        delegate().showAsDropDown(anchor, xoff, yoff);
    }

    @NonNull
    @Override
    public PopupWindow get() {
        return this;
    }

    @NonNull
    @Override
    public PopupWindowDelegate delegate() {
        if (mDelegate == null) {
            mDelegate = new PopupWindowDelegateImpl(this);
        }
        return mDelegate;
    }

    @Override
    public void onBeforeViews() {

    }

    @Override
    public void setSize(float widthScale, float heightScale) {
        delegate().setSize(widthScale, heightScale);
    }

    @Override
    public View getView() {
        return delegate().getView();
    }

    @Override
    public Context getRawContext() {
        return delegate().getRawContext();
    }
}
