package com.example.lenovo.zy2.model;

import com.example.lenovo.zy2.api.ApiService;
import com.example.lenovo.zy2.api.CallBack;
import com.example.lenovo.zy2.bean.Bean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void setData(final CallBack<Bean> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        callBack.setData(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.setString(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
