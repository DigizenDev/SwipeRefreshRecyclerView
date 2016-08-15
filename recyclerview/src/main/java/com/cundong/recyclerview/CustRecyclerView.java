package com.cundong.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by lizhixian on 16/1/4.
 */
public class CustRecyclerView extends RecyclerView{
    private View emptyView;
    public CustRecyclerView(Context context) {
        super(context);
    }

    public CustRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            Adapter adapter =  getAdapter();

            if(adapter instanceof HeaderAndFooterRecyclerViewAdapter){
                HeaderAndFooterRecyclerViewAdapter headerAndFooterAdapter = (HeaderAndFooterRecyclerViewAdapter) adapter;
                if(headerAndFooterAdapter.getInnerAdapter() != null && emptyView != null) {
                    int count = headerAndFooterAdapter.getInnerAdapter().getItemCount();
                    if(count == 0) {
                        emptyView.setVisibility(View.VISIBLE);
                        CustRecyclerView.this.setVisibility(View.GONE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        CustRecyclerView.this.setVisibility(View.VISIBLE);
                    }
                }
            }else {
                if(adapter != null && emptyView != null) {
                    if(adapter.getItemCount() == 0) {
                        emptyView.setVisibility(View.VISIBLE);
                        CustRecyclerView.this.setVisibility(View.GONE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        CustRecyclerView.this.setVisibility(View.VISIBLE);
                    }
                }
            }

        }
    };

    public void setAdapter(Adapter adapter) {
        Adapter oldAdapter = getAdapter();
        if(oldAdapter != null && emptyObserver != null){
            oldAdapter.unregisterAdapterDataObserver(emptyObserver);
        }
        super.setAdapter(adapter);

        if(adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }
        emptyObserver.onChanged();
    }

    /**
     * set view when no content item
     * @param emptyView  visiable view when items is empty
     */
    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }
}
