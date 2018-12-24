package com.dyhdyh.base.components;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;

/**
 * @author dengyuhan
 * created 2018/12/15 23:57
 */
public abstract class AbstractCompatDialog extends Dialog {
    public static final float WRAP_CONTENT = -1;
    //填满 不包含StatusBar和NavigationBar
    public static final float MATCH_PARENT = 1f;

    protected Context mContext;

    public AbstractCompatDialog(@NonNull Context context) {
        this(context, R.style.Theme_Dialog_NoTitle_Enabled);
    }

    public AbstractCompatDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        applyDialogAttributes();
        buildContentView();
        onAfterViews();
    }

    /**
     * Dialog属性设置
     */
    protected void applyDialogAttributes() {

    }

    protected abstract int getContentViewId();

    protected void buildContentView() {
        super.setContentView(getContentViewId());
    }

    protected abstract void onAfterViews();


    /**
     * 设置Dialog从顶部进入和退出
     */
    public void setGravityBottom() {
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.animation_bottom);
    }

    /**
     * 设置Dialog从底部进入和退出
     */
    public void setGravityTop() {
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setWindowAnimations(R.style.animation_top);
    }


    /**
     * 需要在setContentView之后
     *
     * @param widthScale
     * @param heightScale
     */
    public void setSize(float widthScale, float heightScale) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        if (widthScale > 0) {
            getWindow().getAttributes().width = (int) ((float) metrics.widthPixels * widthScale);
        }

        if (heightScale > 0) {
            int displayHeight = metrics.heightPixels;
            getWindow().getAttributes().height = (int) ((float) displayHeight * heightScale);
        }
    }

    public Context getRawContext() {
        return mContext;
    }

}
