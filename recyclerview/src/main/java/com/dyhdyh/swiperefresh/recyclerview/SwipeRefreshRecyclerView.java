package com.dyhdyh.swiperefresh.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.cundong.recyclerview.ExStaggeredGridLayoutManager;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.HeaderSpanSizeLookup;
import com.cundong.recyclerview.LoadingFooter;
import com.cundong.recyclerview.RecyclerOnScrollListener;
import com.cundong.recyclerview.RecyclerViewUtils;


/**
 * @author dengyuhan
 * @desc
 * @create 2016/7/23 21:45
 */
public class SwipeRefreshRecyclerView extends SwipeRefreshLayout {
    private RecyclerView mRecyclerView;
    private LoadingFooter mLoadingFooter;
    private HeaderAndFooterRecyclerViewAdapter mRecyclerViewAdapter;
    private boolean mLoadMoreEnabled;
    protected OnRefreshListener mOnRefreshListener;

    private final String TAG = "SwipeRefreshRecycler";


    public SwipeRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初始化RecyclerView
        this.mRecyclerView = new RecyclerView(context, attrs);
        this.mRecyclerView.addOnScrollListener(mOnScrollListener);
        addView(this.mRecyclerView);

        //自定义属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SwipeRefreshRecyclerView);
        int colorScheme = a.getColor(R.styleable.SwipeRefreshRecyclerView_colorScheme, 0);
        if (colorScheme != 0) {
            setColorSchemeColors(colorScheme);
        } else {
            //setDefaultColorScheme(context, attrs);
        }
        //模式
        this.mLoadMoreEnabled = a.getBoolean(R.styleable.SwipeRefreshRecyclerView_loadMoreEnabled, true);

        a.recycle();
    }

    @Deprecated
    private void setDefaultColorScheme(Context context, AttributeSet attr) {
        //刷新进度圈的默认颜色
        int[] colorAccentAttributes;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            colorAccentAttributes = new int[]{android.R.attr.colorAccent};
        } else {
            colorAccentAttributes = new int[]{android.support.v7.appcompat.R.attr.colorAccent};
        }
        TypedArray androidTypedArray = context.obtainStyledAttributes(attr, colorAccentAttributes);
        int defaultColorScheme = androidTypedArray.getColor(0, 0);
        if (defaultColorScheme != 0) {
            setColorSchemeColors(defaultColorScheme);
        }
        androidTypedArray.recycle();
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mOnRefreshListener = listener;
        super.setOnRefreshListener(listener);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        if (mLoadMoreEnabled) {
            mLoadingFooter = new LoadingFooter(getContext());
            this.setLoadMoreView(mLoadingFooter);
        }
    }

    public void scrollToPosition(int position) {
        mRecyclerView.scrollToPosition(position);
    }
    public void smoothScrollToPosition(int position) {
        mRecyclerView.smoothScrollToPosition(position);
    }
    public void smoothScrollBy(int dx, int dy) {
        mRecyclerView.smoothScrollBy(dx,dy);
    }

    public void setLoadMoreEnabled(boolean loadMoreEnabled) {
        this.mLoadMoreEnabled = loadMoreEnabled;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new HeaderSpanSizeLookup(mRecyclerViewAdapter, ((GridLayoutManager) layoutManager).getSpanCount()));
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            ExStaggeredGridLayoutManager exLayoutManager = new ExStaggeredGridLayoutManager(spanCount, ((StaggeredGridLayoutManager) layoutManager).getOrientation());
            exLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup(mRecyclerViewAdapter, spanCount));
            exLayoutManager.setGapStrategy(((StaggeredGridLayoutManager) layoutManager).getGapStrategy());
            layoutManager = exLayoutManager;
        } else if (layoutManager instanceof ExStaggeredGridLayoutManager) {
            ((ExStaggeredGridLayoutManager) layoutManager).setSpanSizeLookup(new HeaderSpanSizeLookup(mRecyclerViewAdapter, ((ExStaggeredGridLayoutManager) layoutManager).getSpanCount()));
        }
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return mRecyclerView.getLayoutManager();
    }

    public RecyclerView.Adapter getAdapter() {
        return mRecyclerView.getAdapter();
    }

    /**
     * 通过布局id添加头部
     * 需在setAdapter之前
     *
     * @param headerLayoutId
     */
    public void addHeaderView(@LayoutRes int headerLayoutId) {
        this.addHeaderView(LayoutInflater.from(getContext()).inflate(headerLayoutId, this, false));
    }

    /**
     * 添加头部
     * 需在setAdapter之前
     *
     * @param headerView
     */
    public void addHeaderView(View headerView) {
        RecyclerViewUtils.addHeaderView(mRecyclerView, headerView);
    }

    /**
     * 通过布局id添加尾部
     * 需在setAdapter之前
     *
     * @param footerLayoutId
     */
    public void addFooterView(@LayoutRes int footerLayoutId) {
        this.addFooterView(LayoutInflater.from(getContext()).inflate(footerLayoutId, this, false));
    }

    /**
     * 添加尾部
     * 需在setAdapter之前
     *
     * @param footerView
     */
    public void addFooterView(View footerView) {
        RecyclerViewUtils.addFooterView(mRecyclerView, footerView);
    }

    public void setEmptyView(View emptyView) {
        // mRecyclerView.setEmptyView(emptyView);
    }

    public int getHeadersCount() {
        return mRecyclerViewAdapter.getHeaderViewsCount();
    }

    public int getFootersCount() {
        return mRecyclerViewAdapter.getFooterViewsCount();
    }

    public void removeFootView(View footerView) {
        RecyclerViewUtils.removeFooterView(mRecyclerView, footerView);
    }

    public void removeHeaderView(View headerView) {
        RecyclerViewUtils.removeHeaderView(mRecyclerView, headerView);
    }

    public void setLoadMoreView(View loadMoreView) {
        int footersCount = this.getFootersCount();
        if (footersCount > 0) {
            RecyclerViewUtils.removeFooterView(mRecyclerView, footersCount - 1);
        }
        addFooterView(loadMoreView);
    }

    public RecyclerOnScrollListener mOnScrollListener = new RecyclerOnScrollListener() {

        @Override
        public void onBottom() {
            if (!mLoadMoreEnabled) {
                return;
            }
            LoadingFooter.State state = getLoadingFooterState();
            if (state == LoadingFooter.State.Loading) {
                Log.d(TAG, "上一个请求还未执行完成");
            }else if (state == LoadingFooter.State.NormalTheEnd) {
                Log.d(TAG, "第一页就已经到底了");
            }else if (state == LoadingFooter.State.TheEnd) {
                Log.d(TAG, "已经到底了");
            }else{
                if (mOnRefreshListener != null && mOnRefreshListener instanceof OnRefreshListener2 && mRecyclerViewAdapter.getInnerAdapter().getItemCount() > 0) {
                    setLoadingFooterState(LoadingFooter.State.Loading);
                    ((OnRefreshListener2) mOnRefreshListener).onLoadMore();
                }
            }
        }
    };

    @Override
    @Deprecated
    public void setRefreshing(boolean refreshing) {
        super.setRefreshing(refreshing);
    }

    /**
     * 手动刷新
     */
    public void refresh() {
        super.setRefreshing(true);
        if (mOnRefreshListener != null) {
            mOnRefreshListener.onRefresh();
        }
    }

    /**
     * 刷新完成或者加载更多完成
     */
    public void refreshComplete() {
        super.setRefreshing(false);
        setLoadingFooterState(LoadingFooter.State.Normal);
    }

    public void setLoadingFooterState(LoadingFooter.State state) {
        if (mLoadingFooter == null) {
            return;
        }
        mLoadingFooter.setState(state);
    }

    public LoadingFooter.State getLoadingFooterState() {
        if (mLoadingFooter == null) {
            return LoadingFooter.State.Normal;
        }
        return mLoadingFooter.getState();
    }

    public interface OnRefreshListener2 extends OnRefreshListener {
        void onLoadMore();
    }

}
