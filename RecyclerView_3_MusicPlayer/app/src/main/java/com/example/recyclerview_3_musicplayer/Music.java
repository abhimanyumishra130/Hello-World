package com.example.recyclerview_3_musicplayer;

public class Music {

    private int cover_image, music;
    private String song_name, duration;

    public Music(int cover_image, int music, String song_name, String duration) {
        this.cover_image = cover_image;
        this.music = music;
        this.song_name = song_name;
        this.duration = duration;
    }

    public int getCover_image() {
        return cover_image;
    }

    public int getMusic() {
        return music;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getDuration() {
        return duration;
    }

}
