package com.example.birdgridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdAdapter extends RecyclerView.Adapter<BIrdViewHolder> {
    private ClickListener clickListener;
    private ArrayList<Bird> birdList;

    public BirdAdapter(ArrayList<Bird> birdList,ClickListener clickListener) {
        this.birdList = birdList;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public BIrdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new BIrdViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BIrdViewHolder holder, int position) {
        Bird bird = birdList.get(position);
        holder.setData(bird,clickListener);
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }
}
