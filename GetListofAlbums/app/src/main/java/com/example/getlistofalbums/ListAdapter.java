package com.example.getlistofalbums;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends  RecyclerView.Adapter<ListViewHolder>{

    private ArrayList<ResponseDTO> list ;
    public ListAdapter(ArrayList<ResponseDTO> list){
        this.list = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ResponseDTO model = list.get(position);
        holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}


class ListViewHolder extends RecyclerView.ViewHolder{

    TextView title;
    private TextView id;

    public ListViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {

        title = itemView.findViewById(R.id.titleView);
        id = itemView.findViewById(R.id.idView);
    }

    public void setData(ResponseDTO model){
        title.setText(model.getTitle());
        id.setText(model.getId()+"");
    }
}
