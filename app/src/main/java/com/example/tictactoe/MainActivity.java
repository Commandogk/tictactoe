package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  MediaPlayer bgm;
  TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgm = MediaPlayer.create(MainActivity.this,R.raw.videoplayback);
        bgm.start();
        bgm.setLooping(true);
        bgm.setVolume(100,100);
        a=findViewById(R.id.opening);
        Handler m = new Handler();
        Animation b = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation c = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        b.setDuration(4300);
        a.startAnimation(b);
        m.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a= new Intent(MainActivity.this,page1.class);
                startActivity(a);
            }
        },3000);

    }
}
