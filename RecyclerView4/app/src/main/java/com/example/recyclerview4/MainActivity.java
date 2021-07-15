package com.example.recyclerview4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText metOption, metSendMessage;
    private ImageView mivSend;
    public ChatAdaoter chatAdaoter;
    private ArrayList<BaseModel> messageList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRecycleView();
    }

    private void setRecycleView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        chatAdaoter =new ChatAdaoter(messageList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatAdaoter);

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        metOption = findViewById(R.id.etChoice);
        metSendMessage = findViewById(R.id.etSendMessage);
        mivSend = findViewById(R.id.ivSend);
        mivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildList();
            }
        });
    }

    private void buildList() {
        if(metOption.getText().toString().equals("0")){
            messageList.add(new SenderModel(metSendMessage.getText().toString()));
        }else if(metOption.getText().toString().equals("1")){
            messageList.add(new ReceiverModel(metSendMessage.getText().toString()));
        }
        chatAdaoter.updateData(messageList);
    }
}