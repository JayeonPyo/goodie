package com.example.retrofityoutube.recycler;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofityoutube.R;
import com.example.retrofityoutube.model.VideoModel;
import com.example.retrofityoutube.retrofit.NetworkHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerMainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView = null ;
    RecyclerImageTextAdapter mAdapter = null ;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();

    ArrayList<VideoModel> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        GetVideo();


        mRecyclerView = findViewById(R.id.recycler1) ;
        mAdapter = new RecyclerImageTextAdapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

//썸네일,채널이미지,채널이름,조회수
        addItem(getDrawable(R.mipmap.ic_launcher),
                (getDrawable(R.mipmap.ic_launcher)),"타이틀", "채널","조회수 200000") ;
        // 두 번째 아이템 추가.
        addItem(getDrawable(R.mipmap.ic_launcher_round),
        (getDrawable(R.mipmap.ic_launcher)),"Circle", "Account Circle Black 36dp","조회수 200000") ;
        // 세 번째 아이템 추가.
        addItem(getDrawable(R.mipmap.ic_launcher_round),
                (getDrawable(R.mipmap.ic_launcher)), "Ind", "Assignment Ind Black 36dp","조회수 203039") ;

        mAdapter.notifyDataSetChanged() ;
    }

    public void addItem(Drawable icon,Drawable channalimage, String title, String channalname,String count) {
        RecyclerItem item = new RecyclerItem();


        item.setIcon(icon);
        item.setChan(channalimage);
        item.setTitle(title);
        item.setDesc(channalname);
        item.setCount(count);
         mList.add(item);

    }

    void GetVideo() {

      NetworkHelper.getInstance().GetVideo().enqueue(new Callback<ArrayList<VideoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<VideoModel>> call, Response<ArrayList<VideoModel>> response) {
                Log.e("response",response.toString()+"");
                if(response.isSuccessful()){
                    if(response.code() == 200) {
                       ArrayList<VideoModel> responseBody = response.body();
                        datas = responseBody;
                        for(int i=0;i<datas.size(); i++){
                            addItem(getDrawable(R.mipmap.ic_launcher),
                                    (getDrawable(R.mipmap.ic_launcher)),datas.get(i).getTitle(),datas.get(i).getPublisher(),"조회수"+datas.get(i).getViewCount());
                        }
                    }
                }
                    }


            @Override
            public void onFailure(Call<ArrayList<VideoModel>> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}
