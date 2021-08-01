package com.example.youtubelistapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinkViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private Button link;


    public LinkViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        name = itemView.findViewById(R.id.name);
        link = itemView.findViewById(R.id.link);
    }
    public void setData(LinkModel model){
        name.setText(model.getName());
        link.setText(model.getLink());

    }
}
