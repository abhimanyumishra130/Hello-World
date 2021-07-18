package com.example.birdgridview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class BIrdViewHolder extends RecyclerView.ViewHolder {

    private ClickListener clickListener;
    private ImageView img;
    private RelativeLayout relativeLayout;
    public BIrdViewHolder(@NonNull  View itemView,ClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        img=itemView.findViewById(R.id.img);
        relativeLayout=itemView.findViewById(R.id.relativeLayout);
    }
    public void setData(Bird bird,ClickListener clickListener){
        img.setImageResource(bird.getImg());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(bird);
            }
        });
    }
}
