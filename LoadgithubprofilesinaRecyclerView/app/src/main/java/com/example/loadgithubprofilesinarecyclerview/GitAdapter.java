package com.example.loadgithubprofilesinarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GitAdapter extends RecyclerView.Adapter<GitViewHolder> {

    private ArrayList<ResponseDTO> list ;

    public GitAdapter(ArrayList<ResponseDTO> list) {
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new GitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GitViewHolder holder, int position) {
        ResponseDTO model = list.get(position);
        holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void updateData(ArrayList<ResponseDTO> responseList){
        this.list = responseList;
        notifyDataSetChanged();
    }
}

class GitViewHolder extends RecyclerView.ViewHolder{

    private ImageView image;
    private TextView text1,text2;

    public GitViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        image=itemView.findViewById(R.id.ImageView);
        text1=itemView.findViewById(R.id.textView1);
        text2 = itemView.findViewById(R.id.textView2);
    }

    public void setData(ResponseDTO model){
        Glide.with(image).load(model.getOwner().getAvatarUrl()).into(image);
        text1.setText(model.getName());
        text2.setText(model.getOwner().getLogin());
    }
}
