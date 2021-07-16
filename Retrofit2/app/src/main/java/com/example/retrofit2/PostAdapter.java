package com.example.retrofit2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private ArrayList<Responsemodel> postModelList;

    public PostAdapter(List<Responsemodel> postModelList) {
        this.postModelList = (ArrayList<Responsemodel>) postModelList;
    }

    @NonNull

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostViewHolder holder, int position) {
        Responsemodel responsemodel =postModelList.get(position);
        holder.setData(responsemodel);

    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }
}
