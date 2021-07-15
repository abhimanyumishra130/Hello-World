package com.example.recyclerview4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class RecieverViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvReceiverMessage;

    public RecieverViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        mTvReceiverMessage=itemView.findViewById(R.id.tvReceiverMessage);
    }

    public void setData(ReceiverModel receiverModel) {
        mTvReceiverMessage.setText(receiverModel.getReceiverMessage());
    }
}
