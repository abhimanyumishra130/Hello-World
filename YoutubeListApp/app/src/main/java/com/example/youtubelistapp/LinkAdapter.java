package com.example.youtubelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {
    @NonNull
    private ArrayList<LinkModel> linkList;
    public LinkAdapter(ArrayList<LinkModel> linkList){
        this.linkList=linkList;
    }
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_item_layout,parent,false);
        return new LinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  LinkViewHolder holder, int position) {

        LinkModel model = linkList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }
}
