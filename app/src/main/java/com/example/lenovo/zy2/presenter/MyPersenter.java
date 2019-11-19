package com.example.lenovo.zy2.presenter;

import com.example.lenovo.zy2.api.CallBack;
import com.example.lenovo.zy2.bean.Bean;
import com.example.lenovo.zy2.model.MyModel;
import com.example.lenovo.zy2.view.MyView;

public class MyPersenter {
    private MyModel myModel;
    private MyView myView;

    public MyPersenter(MyView myView) {
        this.myModel=new MyModel();
        this.myView = myView;
    }
    public void setData(){
        myModel.setData(new CallBack<Bean>() {
            @Override
            public void setData(Bean bean) {
                if(bean!=null&&bean.getRecent()!=null&&bean.getRecent().size()>0&&myView!=null){
                    myView.getData(bean.getRecent());
                }
            }

            @Override
            public void setString(String str) {

            }
        });
    }
}
