package com.dyhdyh.base.components.delegate.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dyhdyh.base.components.delegate.DelegateFragment;
import com.dyhdyh.base.components.delegate.DelegateFragmentCallback;

/**
 * fragment代理类 接管fragment
 *
 * @author dengyuhan
 * created 2019/3/15 17:37
 */
public class DelegateFragmentImpl implements DelegateFragment {
    private DelegateFragmentCallback mFragmentCallback;

    public DelegateFragmentImpl(DelegateFragmentCallback callback) {
        this.mFragmentCallback = callback;
    }

    @Override
    public void onAttach(Context context) {
        final Bundle arguments = mFragmentCallback.get().getArguments();
        if (arguments != null) {
            mFragmentCallback.onInitArguments(arguments);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(mFragmentCallback.getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mFragmentCallback.onAfterViews();
    }
}
