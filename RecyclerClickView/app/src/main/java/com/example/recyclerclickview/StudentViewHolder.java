package com.example.recyclerclickview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout relativeLayout;
    private ImageView mivStudentImg;
    private TextView mtvName,mtvAge,mtvDob,mtvAddress;
    private  itemClickListener itemClickListener;
    public StudentViewHolder(@NonNull  View itemView,itemClickListener itemClickListener) {
        super(itemView);
        initView(itemView);
        this.itemClickListener=itemClickListener;
    }

    private void initView(View itemView) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvAge=itemView.findViewById(R.id.tvAge);
        mtvDob=itemView.findViewById(R.id.tvDob);
        mtvAddress=itemView.findViewById(R.id.tvAddress);
        mivStudentImg=itemView.findViewById(R.id.ivStudentImg);
        relativeLayout=itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(StudentModel studentModel){
        mivStudentImg.setImageResource(studentModel.getImageId());
        mtvName.setText(studentModel.getName());
        mtvAge.setText(studentModel.getAge()+"");
        mtvAddress.setText(studentModel.getAddress());
        mtvDob.setText(studentModel.getDob());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
itemClickListener.onItemClicked(studentModel,getAdapterPosition());
            }
        });
    }
}
