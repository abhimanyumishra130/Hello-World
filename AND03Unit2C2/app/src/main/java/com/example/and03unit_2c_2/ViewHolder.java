package com.example.and03unit_2c_2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView date, positive, negative, hospitalizedCurrently,onVentilatorCurrently, death, dateChecked;
    public ViewHolder(@NonNull  View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        death= itemView.findViewById(R.id.death);
        positive=itemView.findViewById(R.id.positive);
        negative = itemView.findViewById(R.id.negative);
        hospitalizedCurrently=itemView.findViewById(R.id.hospitalizedCurrently);
        onVentilatorCurrently=itemView.findViewById(R.id.onVentilatorCurrently);
        date=itemView.findViewById(R.id.date);
        dateChecked=itemView.findViewById(R.id.dateChecked);
    }

    public void setData(ResponseModel responsemodel){
        date.setText(responsemodel.getDate()+"");
        positive.setText(responsemodel.getPositive()+"");
        negative.setText(responsemodel.getNegative()+"");
        hospitalizedCurrently.setText(responsemodel.getHospitalizedCurrently()+"");
        onVentilatorCurrently.setText(responsemodel.getOnVentilatorCurrently()+"");
        death.setText(responsemodel.getDeath()+"");
        dateChecked.setText(responsemodel.getDeath()+"");
    }
}
