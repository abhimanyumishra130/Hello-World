package com.example.recyclerview_3_musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {

    TextView songName, duration;
    ImageView coverImage;
    MusicAdapter adapter;
    private ArrayList<Music> musicArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRecyclerView();
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        for (int i = 1; i < 3; i++) {
            musicArrayList.add(new Music(R.drawable.naruto_jiraiya, R.raw.aaron_smith_dancin, "Aaron Smith - Dancin(KRONO REMIX)", "03:30"));
            musicArrayList.add(new Music(R.drawable.montero, R.raw.montero, "Montero", "03:30"));
            musicArrayList.add(new Music(R.drawable.pray_for_me, R.raw.pray_for_me, "pray for me ", "03:30"));
            musicArrayList.add(new Music(R.drawable.seven_years, R.raw.seven_years, "7 years", "03:30"));
            musicArrayList.add(new Music(R.drawable.tokyo_drift, R.raw.tokyo_drift, "tokyo drift", "03:30"));
            musicArrayList.add(new Music(R.drawable.stellar_ashes, R.raw.ashes_stellar, "stellar ashes", "03:30"));
            musicArrayList.add(new Music(R.drawable.worth_it, R.raw.worth_it, "worth it", "03:30"));
            musicArrayList.add(new Music(R.drawable.we_dont_talk_anymore, R.raw.we_dont_talk_anymore, "we don't  talk anymore", "03:30"));
            musicArrayList.add(new Music(R.drawable.say_my_name, R.raw.say_my_name, "say my name", "03:30"));
        }
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MusicAdapter(musicArrayList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initView() {
        songName = findViewById(R.id.song_title);
        coverImage = findViewById(R.id.song_cover);
        duration = findViewById(R.id.duration);
        recyclerView = findViewById(R.id.recycler_view);

    }


    @Override
    public void onClicked(int position, Music music) {
        musicArrayList.remove(position);
        adapter.updateData(musicArrayList);
    }
}