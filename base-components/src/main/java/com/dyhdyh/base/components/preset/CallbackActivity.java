package com.dyhdyh.base.components.preset;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.dyhdyh.base.components.delegate.ActivityDelegateCallback;

/**
 * @author dengyuhan
 * created 2019/3/15 17:57
 */
public abstract class CallbackActivity extends AppCompatActivity implements ActivityDelegateCallback {

    @NonNull
    @Override
    public AppCompatActivity get() {
        return this;
    }

}
