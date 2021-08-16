package com.example.itunesapi;

import android.app.ProgressDialog;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private ArrayList<ResultsDTO> list;
    private OnClickListener onClickListener;
    public ItemAdapter(ArrayList<ResultsDTO> list ,OnClickListener onClickListener){
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {

        ResultsDTO model = list.get(position);
        holder.setData(model);
    }

    public void update(ArrayList<ResultsDTO> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder{

    private ImageView image;
    private TextView artistName, trackName;
    private Button play, pause, delete;

//    private ResponseDTO responseDTO;
    private MediaPlayer mediaPlayer;
    private OnClickListener onClickListener;

    public ItemViewHolder(@NonNull @NotNull View itemView, OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener = onClickListener;

        initView(itemView);
    }

    private void initView(View itemView) {
        image = itemView.findViewById(R.id.Image);
        artistName = itemView.findViewById(R.id.artistName);
        trackName = itemView.findViewById(R.id.trackName);
        play  = itemView.findViewById(R.id.play);
        pause = itemView.findViewById(R.id.pause);
        delete = itemView.findViewById(R.id.delete);
    }

    public void setData(ResultsDTO model){

        Glide.with(image).load(model.getArtworkUrl100()).into(image);
        artistName.setText(model.getArtistName());
        trackName.setText(model.getTrackName());
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onClickListener.onClicked(model,getAdapterPosition());

            }
        });

    }
}
