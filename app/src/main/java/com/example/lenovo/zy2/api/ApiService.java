package com.example.lenovo.zy2.api;

import com.example.lenovo.zy2.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String Url="http://news-at.zhihu.com/";
    @GET("api/4/news/hot")
    Observable<Bean> getBean();
}
