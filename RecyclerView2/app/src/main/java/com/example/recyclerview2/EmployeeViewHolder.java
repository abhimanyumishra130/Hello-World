package com.example.recyclerview2;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvName,mtvAge,mtvAddress;
    private ImageView ivEdit;
    private itemClickListener itemClickListener;

    public EmployeeViewHolder(@NonNull  View itemView,itemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener=itemClickListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvAge=itemView.findViewById(R.id.tvAge);
        mtvAddress=itemView.findViewById(R.id.tvAddress);
        ivEdit=itemView.findViewById(R.id.ivEdit);
    }
    public void setData(Employee employee){
        mtvName.setText(employee.getName());
        mtvAge.setText(employee.getAge()+"");
        mtvAddress.setText(employee.getAddress());
        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(),employee);
            }
        });

    }
}
