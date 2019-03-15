package com.dyhdyh.base.components.preset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.dyhdyh.base.components.delegate.ActivityDelegate;
import com.dyhdyh.base.components.delegate.impl.ActivityDelegateImpl;

/**
 * @author dengyuhan
 * created 2019/3/15 17:58
 */
public abstract class DelegateActivity extends CallbackActivity {
    private ActivityDelegate mDelegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate().onCreate(savedInstanceState);
    }

    protected ActivityDelegate delegate() {
        if (mDelegate == null) {
            mDelegate = new ActivityDelegateImpl(this);
        }
        return mDelegate;
    }
}
