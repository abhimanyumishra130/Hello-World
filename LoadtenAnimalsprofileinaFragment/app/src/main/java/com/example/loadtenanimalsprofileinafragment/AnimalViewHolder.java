package com.example.loadtenanimalsprofileinafragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private ImageView img;
    public AnimalViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        name = itemView.findViewById(R.id.ivName);
        img = itemView.findViewById(R.id.ivAnimal);
    }

    public  void setData(Animal model){
        name.setText(model.getName());
        img.setImageResource(model.getImageId());
    }
}
