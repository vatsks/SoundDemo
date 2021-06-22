package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.transition.Scene;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void start(View view){


        mediaPlayer.start();

    }
public void pause(View view){

        mediaPlayer.pause();

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxvol =audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentvol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);



        mediaPlayer=MediaPlayer.create(this,R.raw.birdschirping);

        SeekBar seekBar=findViewById(R.id.seekBarvolume);
        seekBar.setMax(maxvol);
        seekBar.setProgress(currentvol);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("info",Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar1=findViewById(R.id.seekBarscrub);
        seekBar1.setMax(mediaPlayer.getDuration());
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("info",Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                   seekBar1.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);

    }
}