package com.example.recyclerview_3_musicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private ClickListener clickListener;
    private TextView songTitle, songDuration;
    private ImageView imageId;
    private Button play, pause, delete;

    public MusicViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initView(itemView);

    }

    private void initView(View itemView) {
        songDuration = itemView.findViewById(R.id.duration);
        songTitle = itemView.findViewById(R.id.song_title);
        imageId = itemView.findViewById(R.id.song_cover);
        play = itemView.findViewById(R.id.play_button);
        pause = itemView.findViewById(R.id.pause_button);
        delete = itemView.findViewById(R.id.delete_button);

    }

    public void setData(Music music) {
        songTitle.setText(music.getSong_name());
        imageId.setImageResource(music.getCover_image());
        songDuration.setText(music.getDuration());
        MediaPlayer mediaPlayer = MediaPlayer.create(songTitle.getContext(), music.getMusic());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  clickListener.onClicked(getAdapterPosition(), music);
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // clickListener.onClicked(getAdapterPosition(), music);
                mediaPlayer.pause();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClicked(getAdapterPosition(), music);


            }
        });
    }

}
