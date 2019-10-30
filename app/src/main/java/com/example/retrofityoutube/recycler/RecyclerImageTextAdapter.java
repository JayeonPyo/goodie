package com.example.retrofityoutube.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofityoutube.R;

import java.util.ArrayList;

public class RecyclerImageTextAdapter extends RecyclerView.Adapter<RecyclerImageTextAdapter.ViewHolder>{
    private ArrayList<RecyclerItem> mData = null ;


    RecyclerImageTextAdapter(ArrayList<RecyclerItem> list) {
        mData = list ;
    }


    @Override
    public RecyclerImageTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recycler_item, parent, false) ;
        RecyclerImageTextAdapter.ViewHolder vh = new RecyclerImageTextAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerImageTextAdapter.ViewHolder holder, int position) {

        RecyclerItem item = mData.get(position) ;

        holder.icon.setImageDrawable(item.getIcon()) ;
        holder.channalimage.setImageDrawable(item.getChan()) ;
        holder.title.setText(item.getTitle()) ;
        holder.channalname.setText(item.getDesc()) ;
        holder.count.setText(item.getCount()) ;
    }


    @Override
    public int getItemCount() {
        return mData.size() ;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon ;
        ImageView channalimage ;
        TextView title ;
        TextView channalname ;
        TextView count;

        ViewHolder(View itemView) {
            super(itemView) ;

            icon = itemView.findViewById(R.id.icon) ;
            channalimage = itemView.findViewById(R.id.channalimage) ;
            title = itemView.findViewById(R.id.title) ;
            channalname = itemView.findViewById(R.id.channalname) ;
            count = itemView.findViewById(R.id.count) ;


        }
    }
}
