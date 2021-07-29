package com.example.idenditycardproblemcontinuation;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class DesignViewHolder extends RecyclerView.ViewHolder {

    private OnClickListener onClickListener;
    private TextView company,profession,age;
    private ImageView img;
    private RelativeLayout relativeLayout;

    public DesignViewHolder(@NonNull  View itemView, OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener=onClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        relativeLayout=itemView.findViewById(R.id.RelativeLayout);
        company=itemView.findViewById(R.id.company);
        profession=itemView.findViewById(R.id.profession);
        age=itemView.findViewById(R.id.age);
        img=itemView.findViewById(R.id.Image);
    }
    public void setData(IdentityModel design){
        company.setText(design.getCompany());
        profession.setText(design.getProfession());
        age.setText(design.getAge()+"");
        img.setImageResource(design.getImageId());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.OnClicked(design,getAdapterPosition());
            }
        });
    }
}
