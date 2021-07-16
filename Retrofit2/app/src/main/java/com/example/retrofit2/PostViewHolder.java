package com.example.retrofit2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName, mTvEmail, mTvBody;

    public PostViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);

    }

    public void setData(Responsemodel responseModel) {
        mTvName.setText(responseModel.getName());
        mTvEmail.setText(responseModel.getEmail());
        mTvBody.setText(responseModel.getBody());
    }

    private void initView(View itemView) {
        mTvName=itemView.findViewById(R.id.tvName);
        mTvEmail=itemView.findViewById(R.id.tvEmail);
        mTvBody=itemView.findViewById(R.id.tvBody);
    }
}
