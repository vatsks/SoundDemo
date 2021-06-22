package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    public void start(View view){

        mediaPlayer=MediaPlayer.create(this,R.raw.birdschirping);
        mediaPlayer.start();

    }
public void pause(View view){

        mediaPlayer.pause();

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}