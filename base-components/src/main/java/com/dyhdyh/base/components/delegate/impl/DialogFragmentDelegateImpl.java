package com.dyhdyh.base.components.delegate.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dyhdyh.base.components.delegate.DialogFragmentDelegateCallback;

/**
 * @author dengyuhan
 * created 2019/3/27 18:14
 */
public class DialogFragmentDelegateImpl extends FragmentDelegateImpl {
    private DialogFragmentDelegateCallback mCallback;

    public DialogFragmentDelegateImpl(DialogFragmentDelegateCallback callback) {
        super(callback);
        mCallback = callback;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        mCallback.onBuildToolbar(view);
        return view;
    }
}
