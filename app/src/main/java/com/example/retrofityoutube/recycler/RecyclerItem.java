package com.example.retrofityoutube.recycler;

import android.graphics.drawable.Drawable;

public class RecyclerItem {
    private String  thumnailStr ;
    private String titleStr ;
    private String channelStr ;
    private String countStr;



    public void setThumnail(String thumnailimage) {
        thumnailStr = thumnailimage ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String channel) {
        channelStr = channel ;
    }
    public void setCount(String count){countStr = count ; }



    public String getThumnail() {
        return this.thumnailStr ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.channelStr ;
    }
    public String getCount() {
        return this.countStr ;
    }




}
