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
import com.example.lenovo.zy2.bean.RecentBean;

import java.util.ArrayList;
import java.util.List;

class MyWoAdapter extends RecyclerView.Adapter {

    private List<RecentBean> list;
    private Context context;
    private int wd1=0;
    private int wd2=1;

    public MyWoAdapter(List<RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return wd1;
        }else{
            return wd2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==0){
            View view = LayoutInflater.from(context).inflate(R.layout.wd1,viewGroup,false);
            return new ViewHolder1(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.wd2,viewGroup,false);
            return new ViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(getItemViewType(i)==wd1){
            ViewHolder1 holder1 = (ViewHolder1) viewHolder;
            holder1.text_wd1.setText(list.get(i).getTitle());
            holder1.text_wd11.setText(list.get(i).getTitle());
            Glide.with(context).load(list.get(i).getThumbnail()).into(holder1.image_wd1);
        }else{
            ViewHolder2 holder2 = (ViewHolder2) viewHolder;
            holder2.text_wd2.setText(list.get(i).getTitle());
            holder2.text_wd22.setText(list.get(i).getTitle());
            Glide.with(context).load(list.get(i).getThumbnail()).into(holder2.image_wd2);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {
            ImageView image_wd1;
            TextView text_wd1;
            TextView text_wd11;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image_wd1=itemView.findViewById(R.id.image_wd1);
            text_wd1=itemView.findViewById(R.id.text_wd1);
            text_wd11=itemView.findViewById(R.id.text_wd11);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView image_wd2;
        TextView text_wd2;
        TextView text_wd22;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            image_wd2=itemView.findViewById(R.id.image_wd2);
            text_wd2=itemView.findViewById(R.id.text_wd2);
            text_wd22=itemView.findViewById(R.id.text_wd22);
        }
    }
}
