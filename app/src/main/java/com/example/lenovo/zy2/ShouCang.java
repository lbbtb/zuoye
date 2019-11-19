package com.example.lenovo.zy2;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.lenovo.zy2.bean.Bean;
import com.example.lenovo.zy2.bean.RecentBean;
import com.example.lenovo.zy2.presenter.MyPersenter;
import com.example.lenovo.zy2.view.MyView;
import com.example.xts.greendaodemo.db.RecentBeanDao;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouCang extends Fragment implements MyView {


    private View view;
    private RecyclerView mRecy;
    private MyPersenter persenter;
    private ArrayList<RecentBean> list;
    private MyAdapter adapter;
    private Button qd;
    private Button qx;
    private int dext=0;
    private PopupWindow popupWindow;

    public ShouCang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shou_cang, container, false);
        initView(view);
        persenter = new MyPersenter(this);
        persenter.setData();
        return view;
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new MyAdapter(list,getContext());
        mRecy.setAdapter(adapter);
        initData();
    }

    private void initData() {
        adapter.setOnItemClickListener1(new MyAdapter.OnItemClickListener1() {
            @Override
            public void OnItemClickListener(int pos) {
                dext=pos;
                 View view = View.inflate(getActivity(), R.layout.pop_fenxiang, null);
                qd = view.findViewById(R.id.qd);
                qx = view.findViewById(R.id.qx);
                init(pos);
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                 popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                                 popupWindow.setOutsideTouchable(true);
                                 popupWindow.setFocusable(true);
                                 popupWindow.showAtLocation(view,Gravity.CENTER,0,0);

                                 WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                                 attributes.alpha=0.3f;
                                 getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                                 getActivity().getWindow().setAttributes(attributes);
                                 popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                     @Override
                                     public void onDismiss() {
                                         WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                                         attributes.alpha=1.0f;
                                         getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                                         getActivity().getWindow().setAttributes(attributes);
                                     }
                                 });
            }

            private void init(final int pos) {
                qd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BaseApp.getInstance().getDaoSession().getRecentBeanDao().insertOrReplaceInTx(list.get(pos));
                        Toast.makeText(getActivity(),"插入成功",Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void getData(List<RecentBean> recent) {
        list.addAll(recent);
        adapter.setData(recent);
    }
}