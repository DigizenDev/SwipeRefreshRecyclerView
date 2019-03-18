package com.dyhdyh.base.components.delegate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment的代理类 接管fragment
 * @author dengyuhan
 * created 2019/3/15 17:32
 */
public interface FragmentDelegate {
    void onAttach(Context context);

    View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);
}
