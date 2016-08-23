package com.dyhdyh.swiperefresh.recyclerview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * @author dengyuhan
 * @desc
 * @create 2016/6/15 14:06
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder>{

    private List<String> dataSource;
    public TextAdapter(List<String> dataSource) {
        this.dataSource=dataSource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    Random random=new Random();
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.getLayoutParams().height=random.nextInt(333)+100;
        holder.tv.setText(dataSource.get(position));
    }

    public List<String> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<String> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }

        TextView tv;
    }

}
