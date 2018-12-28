package com.dyhdyh.base.components.example.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import com.dyhdyh.base.components.AbstractCompatPopupWindow;
import com.dyhdyh.base.components.example.R;

/**
 * @author dengyuhan
 * created 2018/12/24 14:20
 */
public class ExamplePopupWindow extends AbstractCompatPopupWindow {
    public ExamplePopupWindow(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.dialog_example;
    }

    @Override
    protected void applyAttributes(Context context) {
        super.applyAttributes(context);
        setAnimationTop();
    }

    @Override
    protected void onAfterViews() {
        setSize(AbstractCompatDialog.MATCH_PARENT, AbstractCompatDialog.WRAP_CONTENT);
    }

}
