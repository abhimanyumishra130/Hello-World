package com.example.recyclerview_3_musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private ClickListener clickListener;
    private ArrayList<Music> musicArrayList;

    public MusicAdapter(ArrayList<Music> music, ClickListener clickListener) {
        this.musicArrayList = music;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MusicViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music music = musicArrayList.get(position);
        holder.setData(music);
    }



    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }

    public void updateData(ArrayList<Music> musicArrayList) {
        this.musicArrayList = musicArrayList;
        notifyDataSetChanged();
    }
}
