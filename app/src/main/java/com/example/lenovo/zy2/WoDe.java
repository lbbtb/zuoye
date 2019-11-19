package com.example.lenovo.zy2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.zy2.bean.RecentBean;
import com.example.xts.greendaodemo.db.RecentBeanDao;

import java.util.ArrayList;
import java.util.List;


public class WoDe extends Fragment {


    private View view;
    private RecyclerView mRe;
    private MyWoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wo_de, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRe = (RecyclerView) view.findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        RecentBeanDao dao = BaseApp.getInstance().getDaoSession().getRecentBeanDao();
        List<RecentBean> loadAll = dao.loadAll();
        adapter = new MyWoAdapter(loadAll, getContext());
        mRe.setAdapter(adapter);
    }
}
