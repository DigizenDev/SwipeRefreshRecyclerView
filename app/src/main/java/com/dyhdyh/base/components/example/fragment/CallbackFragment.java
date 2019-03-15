package com.dyhdyh.base.components.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.dyhdyh.base.components.delegate.DelegateFragmentCallback;

/**
 * @author dengyuhan
 * created 2019/3/15 17:44
 */
public class CallbackFragment extends Fragment implements DelegateFragmentCallback {
    @Override
    public Fragment get() {
        return this;
    }

    @Override
    public void onInitArguments(@NonNull Bundle arguments) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void onAfterViews() {

    }
}
