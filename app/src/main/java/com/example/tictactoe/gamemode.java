package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gamemode extends AppCompatActivity {
    Button mode1,mode2,mode3;
    String playernam1,playernam2;
    MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode);
        mode1= findViewById(R.id.mode3x3);
        mode2=findViewById(R.id.mode4x4);
        mode3=findViewById(R.id.mode5x5);
        bgm = MediaPlayer.create(gamemode.this,R.raw.videoplayback);
        bgm.start();
        bgm.setLooping(true);
        bgm.setVolume(100,100);
        Intent a =getIntent();
            playernam1=a.getStringExtra("player1");
            playernam2=a.getStringExtra("player2");

        mode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(gamemode.this,game3x3.class);
                b.putExtra("player1",playernam1);
                b.putExtra("player2",playernam2);
                startActivity(b);
                bgm.stop();
                finish();
            }
        });
        mode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(gamemode.this,game4X4.class);
                b.putExtra("player1",playernam1);
                b.putExtra("player2",playernam2);
                startActivity(b);
                bgm.stop();
                finish();
            }
        });
        mode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(gamemode.this,game5x5.class);
                b.putExtra("player1",playernam1);
                b.putExtra("player2",playernam2);
                startActivity(b);
                bgm.stop();
                finish();
            }
        });

    }
}
