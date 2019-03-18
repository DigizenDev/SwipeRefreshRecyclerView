package com.dyhdyh.base.components.delegate.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dyhdyh.base.components.delegate.FragmentDelegate;
import com.dyhdyh.base.components.delegate.FragmentDelegateCallback;

/**
 * BaseFragment的逻辑具体实现
 *
 * @author dengyuhan
 * created 2019/3/15 17:37
 */
public class FragmentDelegateImpl implements FragmentDelegate {
    private FragmentDelegateCallback mFragmentCallback;

    public FragmentDelegateImpl(FragmentDelegateCallback callback) {
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
