package com.example.retrofityoutube.recycler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.example.retrofityoutube.R;
import com.example.retrofityoutube.model.VideoModel;
import com.example.retrofityoutube.retrofit.NetworkHelper;

import java.util.ArrayList;

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
        mAdapter = new RecyclerImageTextAdapter(mList,this) ;
        mRecyclerView.setAdapter(mAdapter) ;


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)) ;


//getDrawable(R.mipmap.ic_launcher)
//썸네일,채널이미지,채널이름,조회수

//
//        addItem("썸네일","타이틀","채널명", "조회수 200000") ;
//        addItem("썸네일","타이틀","채널명", "조회수 200000") ;
//        addItem("썸네일","타이틀","채널명", "조회수 200000") ;




        mAdapter.notifyDataSetChanged() ;
    }



    public void addItem(String thumnailimage, String title, String channalname,String count) {
        RecyclerItem item = new RecyclerItem();


        item.setThumnail(thumnailimage);
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
                            addItem(datas.get(i).getThumbnail(),datas.get(i).getTitle(),datas.get(i).getPublisher(),"조회수"+datas.get(i).getViewCount());
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
