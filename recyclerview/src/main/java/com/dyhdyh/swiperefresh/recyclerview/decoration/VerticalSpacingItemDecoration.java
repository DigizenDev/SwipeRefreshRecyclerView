package com.dyhdyh.swiperefresh.recyclerview.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;

/**
 * author  dengyuhan
 * created 2016/8/22 11:07
 */
public class VerticalSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int verticalSpacing;

    public VerticalSpacingItemDecoration(int verticalSpacing) {
        this.verticalSpacing = verticalSpacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (adapter instanceof HeaderAndFooterRecyclerViewAdapter) {
            if (((HeaderAndFooterRecyclerViewAdapter) adapter).isHeader(childAdapterPosition) || ((HeaderAndFooterRecyclerViewAdapter) adapter).isFooter(childAdapterPosition)) {
                return;
            }
        }
        outRect.bottom = verticalSpacing;
    }
}