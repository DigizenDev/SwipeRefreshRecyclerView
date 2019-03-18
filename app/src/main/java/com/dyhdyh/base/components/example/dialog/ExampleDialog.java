package com.dyhdyh.base.components.example.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import com.dyhdyh.base.components.delegate.DialogDelegate;
import com.dyhdyh.base.components.example.BaseDialog;
import com.dyhdyh.base.components.example.R;

/**
 * @author dengyuhan
 * created 2018/12/24 14:20
 */
public class ExampleDialog extends BaseDialog {

    public ExampleDialog(@NonNull Context context) {
        super(context, R.style.Theme_Dialog_NoTitle_Enabled);
    }

    @Override
    public void onBeforeViews() {
        getWindow().setGravity(Gravity.TOP);
        getWindow().setWindowAnimations(R.style.animation_top);
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
