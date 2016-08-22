package com.dyhdyh.swiperefresh.recyclerview.decoration;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.RecyclerViewUtils;

/**
 * author  dengyuhan
 * created 2016/8/22 11:07
 */
public class HorizontalSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int horizontalSpacing;

    public HorizontalSpacingItemDecoration(int horizontalSpacing) {
        this.horizontalSpacing = horizontalSpacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (adapter instanceof HeaderAndFooterRecyclerViewAdapter) {
            if (((HeaderAndFooterRecyclerViewAdapter) adapter).isHeader(childAdapterPosition) || ((HeaderAndFooterRecyclerViewAdapter) adapter).isFooter(childAdapterPosition)) {
                return;
            }
            childAdapterPosition = RecyclerViewUtils.getAdapterPosition(parent, parent.getChildViewHolder(view));
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        int spanCount = 0;
        if (layoutManager instanceof GridLayoutManager) {
            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        outRect.left = horizontalSpacing;
        if (spanCount != 0 && (childAdapterPosition + 1) % spanCount == 0) {
            outRect.right = horizontalSpacing;
        }
    }
}