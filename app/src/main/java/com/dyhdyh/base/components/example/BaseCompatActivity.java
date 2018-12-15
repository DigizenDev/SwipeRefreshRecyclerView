package com.dyhdyh.base.components.example;

import com.dyhdyh.base.components.AbstractCompatActivity;

/**
 * @author dengyuhan
 * created 2018/12/16 03:13
 */
public abstract class BaseCompatActivity extends AbstractCompatActivity {
    @Override
    protected int getActivityContainerViewId() {
        return R.layout.base_toolbar_activity_container;
    }
}
