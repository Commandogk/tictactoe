package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class score extends AppCompatActivity {
    RecyclerView recyclerView;
    Button back;
    int i=1;
    String[] winner= new String[20] ,loser= new String[20],draw= new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        recyclerView=findViewById(R.id.recycle);
        back=findViewById(R.id.back);
        for (int i = 0; i < 20; i++) {
            winner[i] = "w";
            loser[i] = "l";
            draw[i] = "no";
        }
        load();
        Intent a=getIntent();
        if(a.getBooleanExtra("yes",false)) {
            MyAdapter myAdapter ;
            myAdapter = new MyAdapter(this,winner,loser,draw ,i);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else {
            load();
            Intent g = getIntent();
            if (!g.getStringExtra("winner").isEmpty()) {
                winner[i - 1] = g.getStringExtra("winner");
                loser[i - 1] = g.getStringExtra("loser");
                draw[i - 1] = g.getStringExtra("draw");
            }
            MyAdapter myAdapter ;
            myAdapter = new MyAdapter(this,winner,loser,draw ,i);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            i++;
            save();
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c =new Intent(score.this,page1.class);
                startActivity(c);
            }
        });
    }
    public void save(){
        SharedPreferences sharedPreferences= getSharedPreferences("Shared",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        for(int k=0;k<20;k++){
            editor.putString("winner_"+k,winner[k]);
            editor.putString("loser_"+k,loser[k]);
            editor.putString("draw_"+k,draw[k]);
        }
        if(i==10)
            i=1;
        editor.putInt("i",i);
        editor.apply();
    }
    public void load(){
        SharedPreferences sharedPreferences=getSharedPreferences("Shared",MODE_PRIVATE);
        i=sharedPreferences.getInt("i",1);
        for(int k=0;k<20;k++){
            winner[k]=sharedPreferences.getString("winner_"+k,"w");
            loser[k]=sharedPreferences.getString("loser_"+k,"l");
            draw[k]=sharedPreferences.getString("draw_"+k,"no");
        }

    }


}
