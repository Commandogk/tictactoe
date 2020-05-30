package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalpage extends AppCompatActivity {
         String winner,loser,draw;
         TextView h;
         Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        TextView n;
        n=findViewById(R.id.status);
        button=findViewById(R.id.backf);
        h=findViewById(R.id.winner);
        Intent p =getIntent();
        draw=p.getStringExtra("draw");
        winner=p.getStringExtra("winner");
        loser=p.getStringExtra("loser");

        if(draw.equals("no"))
            h.setText(winner);
        else
            n.setText(draw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g= new Intent(finalpage.this,score.class);
                g.putExtra("winner",winner);
                g.putExtra("loser",loser);
                g.putExtra("draw",draw);
                startActivity(g);
            }
        });
    }
}
