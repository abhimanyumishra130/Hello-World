package com.example.notifyadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button button;

    NotifyAdapter adapter;
    private ArrayList<NotifyModel> list = new ArrayList<>();
    OnClickListener clickListener;

    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setRecyclerView();
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        list.add(new NotifyModel("Books"));
        list.add(new NotifyModel("Podcasts"));
        list.add(new NotifyModel("News"));
        list.add(new NotifyModel("Business"));
        list.add(new NotifyModel("Entertainment"));
        list.add(new NotifyModel("Sports"));
        list.add(new NotifyModel("Technology"));
        list.add(new NotifyModel("Pronunciation"));
        list.add(new NotifyModel("Grammar"));
        list.add(new NotifyModel("Health"));
        list.add(new NotifyModel("Health"));
    }

    private void setRecyclerView() {
        adapter = new NotifyAdapter(list, clickListener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(gridLayoutManager);
    }

    private void initView() {
        button = findViewById(R.id.btnBooks);

        rcv = findViewById(R.id.recycler_view);
    }


    @Override
    public void onClicked(NotifyModel model, int position) {

    }
}