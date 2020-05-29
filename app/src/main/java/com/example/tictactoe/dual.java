package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dual extends AppCompatActivity {
    EditText player_name1,player_name2;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual);
        player_name1=findViewById(R.id.pl1name);
        player_name2=findViewById(R.id.pl2name);
        start=findViewById(R.id.start1);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player_name1.getText().toString().isEmpty()||player_name2.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"enter player name",Toast.LENGTH_SHORT).show();
                else  if(player_name1.getText().toString().equals(player_name2.getText().toString()))
                    Toast.makeText(getApplicationContext(),"enter different player names",Toast.LENGTH_SHORT).show();
                else {
                    String pl1,pl2;
                    pl1=player_name1.getText().toString();
                    pl2=player_name2.getText().toString();
                    Intent a = new Intent(dual.this,gamemode.class);
                    a.putExtra("player1",pl1);
                    a.putExtra("player2",pl2);
                    startActivity(a);
                    finish();
                }
            }
        });
    }
}
