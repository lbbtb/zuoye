package com.example.lenovo.zy2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.zy2.bean.Bean;
import com.example.lenovo.zy2.bean.RecentBean;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<RecentBean> list;
    private Context context;

    public MyAdapter(ArrayList<RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.text_item1.setText(list.get(i).getTitle());
        holder.text_item11.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getThumbnail()).into(holder.image_item1);
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener1.OnItemClickListener(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<RecentBean> recent) {
        list.addAll(recent);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_item1;
        TextView text_item1;
        TextView text_item11;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item1=itemView.findViewById(R.id.image_item);
            text_item1=itemView.findViewById(R.id.text_item1);
            text_item11=itemView.findViewById(R.id.text_item11);
        }
    }
    interface  OnItemClickListener1{
            void  OnItemClickListener(int pos);

        }
        OnItemClickListener1 onItemClickListener1;

        public void setOnItemClickListener1(OnItemClickListener1 onItemClickListener1) {
            this.onItemClickListener1 = onItemClickListener1;
        }

}
