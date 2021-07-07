package com.example.recyclerviewwe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mtvName;
    private TextView mtvAge;
    private TextView mtvRollNo;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        intiView(itemView);
    }

    private void intiView(View view) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvAge = itemView.findViewById(R.id.tvAge);
        mtvRollNo = itemView.findViewById(R.id.tvRollNo);
    }

    public void setData(Student student){
        mtvName.setText(student.getName());
        mtvAge.setText(student.getAge()+"");
        mtvRollNo.setText(student.getRollNo());
    }
}
