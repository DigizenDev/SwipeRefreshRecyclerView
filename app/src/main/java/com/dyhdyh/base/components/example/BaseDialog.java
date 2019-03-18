package com.dyhdyh.base.components.example;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.dyhdyh.base.components.delegate.DialogDelegate;
import com.dyhdyh.base.components.delegate.DialogDelegateCallback;
import com.dyhdyh.base.components.delegate.impl.DialogDelegateImpl;

/**
 * @author dengyuhan
 * created 2019/3/18 12:00
 */
public abstract class BaseDialog extends Dialog implements DialogDelegateCallback {
    private DialogDelegate mDelegate;

    public BaseDialog(Context context) {
        super(context);
        delegate().onCreate(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        delegate().onCreate(context);
    }


    @NonNull
    @Override
    public Dialog get() {
        return this;
    }

    @NonNull
    @Override
    public DialogDelegate delegate() {
        if (mDelegate == null) {
            mDelegate = new DialogDelegateImpl(this);
        }
        return mDelegate;
    }

    @Override
    public void onBeforeViews() {

    }

    @Override
    public View getView() {
        return delegate().getView();
    }


    @NonNull
    @Override
    public Context getRawContext() {
        return delegate().getRawContext();
    }
}
