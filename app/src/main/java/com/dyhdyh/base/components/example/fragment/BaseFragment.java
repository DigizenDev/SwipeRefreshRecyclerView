package com.dyhdyh.base.components.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dyhdyh.base.components.delegate.FragmentDelegate;
import com.dyhdyh.base.components.delegate.impl.FragmentDelegateImpl;

/**
 * @author dengyuhan
 * created 2019/3/15 17:33
 */
public class BaseFragment extends CallbackFragment{
    private FragmentDelegate mDelegate;

    public BaseFragment() {
        mDelegate = new FragmentDelegateImpl(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDelegate.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mDelegate.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDelegate.onViewCreated(view, savedInstanceState);
    }
}
