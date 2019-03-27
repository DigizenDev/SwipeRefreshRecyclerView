package com.dyhdyh.base.components.delegate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;

/**
 * @author dengyuhan
 * created 2019/3/15 17:53
 */
public interface DialogDelegate {
    float WRAP_CONTENT = WindowManager.LayoutParams.WRAP_CONTENT;
    //填满 不包含StatusBar和NavigationBar
    float MATCH_PARENT = WindowManager.LayoutParams.MATCH_PARENT;
    float CONTENT_VIEW = Integer.MIN_VALUE;

    @NonNull
    DialogDelegateCallback getCallback();

    void onCreate(Context context);

    void setSize(float widthScale, float heightScale);

    View getView();

    @NonNull
    Context getRawContext();

}
