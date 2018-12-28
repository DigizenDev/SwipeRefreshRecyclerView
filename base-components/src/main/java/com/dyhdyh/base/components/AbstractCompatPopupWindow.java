package com.dyhdyh.base.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.widget.PopupWindowCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * @author dengyuhan
 * created 2018/12/15 23:57
 */
public abstract class AbstractCompatPopupWindow extends PopupWindow {
    public static final float WRAP_CONTENT = WindowManager.LayoutParams.WRAP_CONTENT;
    //填满 不包含StatusBar和NavigationBar
    public static final float MATCH_PARENT = WindowManager.LayoutParams.MATCH_PARENT;

    private static final int DEFAULT_ANCHORED_GRAVITY = Gravity.TOP | Gravity.START;

    private View mContentView;

    public AbstractCompatPopupWindow(@NonNull Context context) {
        super(context);
        applyAttributes(context);
        buildContentView(context);
        onAfterViews();
    }

    /**
     * Dialog属性设置
     *
     * @param context
     */
    protected void applyAttributes(Context context) {
        //让返回键和点击外面消失
        setOutsideTouchable(true);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setBackgroundDrawable(new ColorDrawable(Color.BLACK));
            setElevation(context.getResources().getDimensionPixelSize(R.dimen.popupwindow_default_elevation));
        } else {
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    protected abstract int getContentViewId();

    protected void buildContentView(Context context) {
        mContentView = LayoutInflater.from(context).inflate(getContentViewId(), null);
        super.setContentView(mContentView);
    }

    protected abstract void onAfterViews();


    public void setAnimationBottom() {
        setAnimationStyle(R.style.animation_bottom);
    }


    public void setAnimationTop() {
        setAnimationStyle(R.style.animation_top);
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
            setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (widthScale == MATCH_PARENT) {
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        } else if (widthScale > 0) {
            setWidth((int) ((float) metrics.widthPixels * widthScale));
        } else {
            if (mContentView != null && mContentView.getLayoutParams() != null) {
                setWidth(mContentView.getLayoutParams().width);
            }
        }

        if (heightScale == WRAP_CONTENT) {
            setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (heightScale == MATCH_PARENT) {
            setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        } else if (heightScale > 0) {
            setHeight((int) ((float) metrics.heightPixels * heightScale));
        }
    }

    @Override
    public void showAsDropDown(View anchor) {
        this.showAsDropDown(anchor, 0, 0);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        this.showAsDropDownCompat(anchor, xoff, yoff, DEFAULT_ANCHORED_GRAVITY);
    }

    public void showAsDropDownCompat(View anchor, int xoff, int yoff, int gravity) {
        PopupWindowCompat.showAsDropDown(this, anchor, xoff, yoff, gravity);
    }

    public Context getContext() {
        return getContentView().getContext();
    }

}
