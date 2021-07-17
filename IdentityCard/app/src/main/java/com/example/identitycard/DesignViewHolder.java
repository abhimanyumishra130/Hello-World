package com.example.identitycard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class DesignViewHolder extends RecyclerView.ViewHolder {

    private TextView company,profession,age;
    private ImageView img;

    public DesignViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        company=itemView.findViewById(R.id.company);
        profession=itemView.findViewById(R.id.profession);
        age=itemView.findViewById(R.id.age);
        img=itemView.findViewById(R.id.Image);
    }
    public void setData(Design design){
        company.setText(design.getCompany());
        profession.setText(design.getProfession());
        age.setText(design.getAge()+"");
        img.setImageResource(design.getImageId());
    }
}
