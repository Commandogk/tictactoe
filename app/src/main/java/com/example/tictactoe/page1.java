package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page1 extends AppCompatActivity {
    TextView title;
    int i=1;
    Button singleplay,dualplay,scoreboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        title= findViewById(R.id.title);
        singleplay=findViewById(R.id.singleplay);
        dualplay=findViewById(R.id.dualplay);
        scoreboard=findViewById(R.id.scoreboard);
        Intent c=getIntent();
        i=c.getIntExtra("i",1);
        Intent b= new Intent(page1.this,score.class);
        b.putExtra("i",i);

        singleplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(page1.this,solo.class);
                startActivity(a);
            }
        });
        dualplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(page1.this,dual.class);
                startActivity(a);
            }
        });
        scoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(page1.this,score.class);
                a.putExtra("yes",true);
                startActivity(a);

            }
        });



    }
}
