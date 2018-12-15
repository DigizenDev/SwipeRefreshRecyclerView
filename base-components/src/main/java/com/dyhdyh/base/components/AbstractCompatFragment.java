package com.dyhdyh.base.components;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author dengyuhan
 * created 2018/12/16 01:24
 */
public abstract class AbstractCompatFragment extends Fragment {
    protected View mContentView;

    /**
     * @return ContentView ID
     */
    protected abstract @LayoutRes
    int getContentViewId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mContentView = inflater.inflate(getContentViewId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View getContentView() {
        return mContentView;
    }
}
