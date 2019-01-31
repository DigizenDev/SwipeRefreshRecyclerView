package com.dyhdyh.base.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @author dengyuhan
 * created 2018/12/15 21:13
 */
public abstract class AbstractCompatActivity extends AppCompatActivity {
    //最外层的View
    private ViewGroup mActivityContainerView;
    //传入的Layout的容器
    private ViewGroup mContentContainerView;
    //传入的Layout
    private View mContentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitIntent(getIntent());
        buildStatusBar();
        buildNavigationBar();

        onBeforeViews();

        buildContentView();

        onAfterViews();
    }

    protected void onInitIntent(Intent intent) {

    }

    /**
     * 状态栏
     */
    protected void buildStatusBar() {

    }

    /**
     * 虚拟按键
     */
    protected void buildNavigationBar() {

    }

    /**
     * setContentView之前
     */
    protected void onBeforeViews() {

    }

    /**
     * @return Activity Container ID
     */
    protected @LayoutRes
    int getActivityContainerViewId() {
        return R.layout.base_activity_container;
    }

    /**
     * @return ContentView ID
     */
    protected abstract @LayoutRes
    int getContentViewId();

    /**
     * setContentView
     */
    protected void buildContentView() {
        mActivityContainerView = buildActivityContainerView();
        mContentContainerView = mActivityContainerView.findViewById(R.id.content_container);

        //如果有content_container就添加到content_container，没有就添加到activity_container
        final ViewGroup contentContainer = getContentContainer();
        mContentView = LayoutInflater.from(this).inflate(getContentViewId(), contentContainer, false);
        contentContainer.addView(mContentView);
        this.setContentView(mActivityContainerView);

        //Toolbar View
        View toolbarView = mActivityContainerView.findViewById(R.id.toolbar);
        if (toolbarView != null) {
            buildToolbarView(toolbarView);
        }
    }


    protected ViewGroup buildActivityContainerView() {
        return (ViewGroup) LayoutInflater.from(this).inflate(getActivityContainerViewId(), null);
    }

    /**
     * @param toolbarView
     */
    protected void buildToolbarView(View toolbarView) {

    }

    /**
     * setContentView之后
     */
    protected abstract void onAfterViews();


    public ViewGroup getActivityContainer() {
        return mActivityContainerView;
    }

    public ViewGroup getContentContainer() {
        if (mContentContainerView != null) {
            return mContentContainerView;
        }
        return mActivityContainerView;
    }

    public View getContentView() {
        return mContentView;
    }

}
