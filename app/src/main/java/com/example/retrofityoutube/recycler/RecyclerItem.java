package com.example.retrofityoutube.recycler;

import android.graphics.drawable.Drawable;

public class RecyclerItem {
    private Drawable iconDrawable ;
    private Drawable channalDrawable ;
    private String titleStr ;
    //descStr = channalname
    private String channelStr ;
    private String countStr;



    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setChan(Drawable channalimage) {
        channalDrawable = channalimage ;
    }

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String channel) {
        channelStr = channel ;
    }
    public void setCount(String count){countStr = count ; }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public Drawable getChan() {
        return this.channalDrawable ;
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
