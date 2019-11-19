package com.example.lenovo.zy2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrame;
    private TabLayout mTable;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame,new ShouCang()).commit();
        mTable = (TabLayout) findViewById(R.id.table);
        mTable.addTab(mTable.newTab().setText("收藏"));
        mTable.addTab(mTable.newTab().setText("我的"));
        mTable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                if(i==0){
                    manager.beginTransaction().replace(R.id.frame,new ShouCang()).commit();

                }
                if(i==1){
                    manager.beginTransaction().replace(R.id.frame,new WoDe()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
