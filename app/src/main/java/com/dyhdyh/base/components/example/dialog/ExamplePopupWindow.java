package com.dyhdyh.base.components.example.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import com.dyhdyh.base.components.delegate.DialogDelegate;
import com.dyhdyh.base.components.example.BasePopupWindow;
import com.dyhdyh.base.components.example.R;

/**
 * @author dengyuhan
 * created 2018/12/24 14:20
 */
public class ExamplePopupWindow extends BasePopupWindow {
    public ExamplePopupWindow(@NonNull Context context) {
        super(context);
    }

    @Override
    public void onBeforeViews() {
        setAnimationStyle(R.style.animation_top);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_example;
    }

    @Override
    public void onAfterViews() {
        setSize(DialogDelegate.MATCH_PARENT, DialogDelegate.WRAP_CONTENT);
    }

}
