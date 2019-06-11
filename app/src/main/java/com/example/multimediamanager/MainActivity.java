package com.example.multimediamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnPlay = findViewById(R.id.activity_main_btn_play);
        btnPlay.setOnClickListener(this);
        final Button btnStop = findViewById(R.id.activity_main_btn_stop);
        btnStop.setOnClickListener(this);
        final Button btnPSound= findViewById(R.id.activity_main_btn_play_sound);
        btnPSound.setOnClickListener(this);
        final Button btnPlayInService = findViewById(R.id.activity_main_btn_play_in_service);
        btnPlayInService.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

 //       mediaPlayer = MediaPlayer.create(this, R.raw.bensoundbrazilsamba);

        AssetFileDescriptor ins = getResources().openRawResourceFd( R.raw.bensoundbrazilsamba);
        try {
            mediaPlayer.setDataSource(ins.getFileDescriptor());
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(this);
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bensoundbrazilsamba);
//        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_play:
                mediaPlayer.prepareAsync();
                break;
            case R.id.activity_main_btn_stop:
                break;
            case R.id.activity_main_btn_play_sound:
                break;
            case R.id.activity_main_btn_play_in_service:
                break;
                default:
        }

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
