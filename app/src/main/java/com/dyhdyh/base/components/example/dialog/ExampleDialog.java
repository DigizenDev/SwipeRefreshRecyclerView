package com.dyhdyh.base.components.example.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.dyhdyh.base.components.AbstractCompatDialog;
import com.dyhdyh.base.components.example.R;

/**
 * @author dengyuhan
 * created 2018/12/24 14:20
 */
public class ExampleDialog extends AbstractCompatDialog {
    public ExampleDialog(@NonNull Context context) {
        super(context);
    }

    public ExampleDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.dialog_example;
    }

    @Override
    protected void applyDialogAttributes() {
        super.applyDialogAttributes();
        setGravityBottom();
    }

    @Override
    protected void onAfterViews() {
        setSize(AbstractCompatDialog.MATCH_PARENT, AbstractCompatDialog.WRAP_CONTENT);
    }

}
