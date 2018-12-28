package com.dyhdyh.base.components;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * @author dengyuhan
 * created 2018/12/15 23:57
 */
public abstract class AbstractCompatDialog extends Dialog {
    public static final float WRAP_CONTENT = WindowManager.LayoutParams.WRAP_CONTENT;
    //填满 不包含StatusBar和NavigationBar
    public static final float MATCH_PARENT = WindowManager.LayoutParams.MATCH_PARENT;
    public static final float CONTENT_VIEW = Integer.MIN_VALUE;

    private Context mContext;
    private View mContentView;

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
        mContentView = LayoutInflater.from(mContext).inflate(getContentViewId(), null);
        super.setContentView(mContentView);
        setSize(CONTENT_VIEW, CONTENT_VIEW);
    }

    protected abstract void onAfterViews();


    /**
     * 设置Dialog从顶部进入和退出
     */
    public void setGravityBottom() {
        getWindow().setGravity(Gravity.BOTTOM);
    }

    public void setGravityBottomAnim() {
        setGravityBottom();
        getWindow().setWindowAnimations(R.style.animation_bottom);
    }

    /**
     * 设置Dialog从底部进入和退出
     */
    public void setGravityTop() {
        getWindow().setGravity(Gravity.TOP);
    }

    public void setGravityTopAnim() {
        setGravityTop();
        getWindow().setWindowAnimations(R.style.animation_top);
    }


    /**
     * 需要在setContentView之后
     *
     * @param widthScale
     * @param heightScale
     */
    public void setSize(float widthScale, float heightScale) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        if (widthScale == WRAP_CONTENT) {
            getWindow().getAttributes().width = WindowManager.LayoutParams.WRAP_CONTENT;
        } else if (widthScale == MATCH_PARENT) {
            getWindow().getAttributes().width = WindowManager.LayoutParams.MATCH_PARENT;
        } else if (widthScale > 0) {
            getWindow().getAttributes().width = (int) ((float) metrics.widthPixels * widthScale);
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                getWindow().getAttributes().width = mContentView.getLayoutParams().width;
            }
        }

        if (heightScale == WRAP_CONTENT) {
            getWindow().getAttributes().height = WindowManager.LayoutParams.WRAP_CONTENT;
        } else if (heightScale == MATCH_PARENT) {
            getWindow().getAttributes().height = WindowManager.LayoutParams.MATCH_PARENT;
        } else if (heightScale > 0) {
            getWindow().getAttributes().height = (int) ((float) metrics.heightPixels * heightScale);
        }
    }

    public Context getRawContext() {
        return mContext;
    }

    public View getContentView() {
        return mContentView;
    }
}
