package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;

public class solo extends AppCompatActivity {
    EditText Player_name;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);
        Player_name = findViewById(R.id.plname);
        start=findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Player_name.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"enter player name",Toast.LENGTH_SHORT).show();
                }
                else {
                    String Player_Ai = "AI";
                    String Playername = Player_name.getText().toString();
                    Intent b = new Intent(solo.this,game3x3.class);
                    b.putExtra("player1",Playername);
                    b.putExtra("player2",Player_Ai);
                    startActivity(b);
                    finish();
                }
            }
        });

    }
}
