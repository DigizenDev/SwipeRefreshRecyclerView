package com.dyhdyh.swiperefresh.recyclerview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyhdyh.swiperefresh.recyclerview.SwipeRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SwipeRefreshRecyclerView.OnRefreshListener2{
    SwipeRefreshRecyclerView rv;

    Handler handler=new Handler();
    TextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv= (SwipeRefreshRecyclerView) findViewById(R.id.rv);
        adapter = new TextAdapter(testdata());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setOnRefreshListener(this);

        TextView tv=new TextView(this);
        tv.setText("你特么的我是头好吗");
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundResource(R.color.colorAccent);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100));
        rv.addHeaderView(tv);
        rv.addHeaderView(R.layout.header);
        //rv.removeHeaderView(tv);

        TextView footer=new TextView(this);
        footer.setText("什么鬼这么多bug");
        footer.setBackgroundResource(R.color.colorPrimary);
        //rv.addFooterView(footer);
    }

    public void request(){

    }



    private List<String> testdata() {
        List<String> data=new ArrayList<>();
        for (int i = 0; i < 55; i++) {
            data.add("Item"+i);
        }
        return data;
    }

    private List<String> adddata() {
        List<String> data=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < 3; i++) {
            data.add("Add Item "+random.nextInt(100));
        }
        return data;
    }

    private List<String> refreshdata() {
        List<String> data=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            data.add("Refresh Item "+i);
        }
        return data;
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.getDataSource().addAll(adddata());
                adapter.notifyDataSetChanged();
                rv.refreshComplete();
            }
        },1500);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = new TextAdapter(refreshdata());
                rv.setAdapter(adapter);
                rv.refreshComplete();
            }
        },1500);
    }
}
