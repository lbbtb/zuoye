package com.example.lenovo.zy2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RecentBean {
    @Id(autoincrement = true)
    private Long news_id;
    private String url;
    private String thumbnail;
    private String title;
    @Generated(hash = 331941798)
    public RecentBean(Long news_id, String url, String thumbnail, String title) {
        this.news_id = news_id;
        this.url = url;
        this.thumbnail = thumbnail;
        this.title = title;
    }
    @Generated(hash = 1697461393)
    public RecentBean() {
    }
    public Long getNews_id() {
        return this.news_id;
    }
    public void setNews_id(Long news_id) {
        this.news_id = news_id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public RecentBean(String url, String thumbnail, String title) {
        this.url = url;
        this.thumbnail = thumbnail;
        this.title = title;
    }
}
