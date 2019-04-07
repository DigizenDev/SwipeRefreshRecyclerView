package com.dyhdyh.base.components.delegate;

import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author dengyuhan
 * created 2019/3/27 18:15
 */
public interface DialogFragmentDelegateCallback extends FragmentDelegateCallback {
    void onBuildToolbar(@Nullable View toolbarView);
}
