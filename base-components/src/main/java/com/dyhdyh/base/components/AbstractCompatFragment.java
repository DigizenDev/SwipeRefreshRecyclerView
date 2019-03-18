package com.dyhdyh.base.components;

import android.content.Context;
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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final Bundle arguments = getArguments();
        if (arguments != null) {
            onInitArguments(arguments);
        }
    }

    protected void onInitArguments(Bundle arg) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getContentViewId(), container, false);
        return mContentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildContentView(mContentView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    protected void buildContentView(View contentView) {

    }

    public View getContentView() {
        return mContentView;
    }
}
