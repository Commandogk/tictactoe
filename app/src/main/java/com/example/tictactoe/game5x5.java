package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game5x5 extends AppCompatActivity implements View.OnClickListener {

    TextView player1, player2;
    Boolean turn = true;
    Button[][] buttons = new Button[5][5];
    String A, B, pl1, pl2, winner = "",loser="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5x5);
        player1 = findViewById(R.id.player1name);
        player2 = findViewById(R.id.player2name);
        buttons[0][0] = findViewById(R.id.button_00);
        buttons[0][1] = findViewById(R.id.button_01);
        buttons[0][2] = findViewById(R.id.button_02);
        buttons[0][3] = findViewById(R.id.button_03);
        buttons[0][4] = findViewById(R.id.button_04);
        buttons[1][0] = findViewById(R.id.button_10);
        buttons[1][1] = findViewById(R.id.button_11);
        buttons[1][2] = findViewById(R.id.button_12);
        buttons[1][3] = findViewById(R.id.button_13);
        buttons[1][4] = findViewById(R.id.button_14);
        buttons[2][0] = findViewById(R.id.button_20);
        buttons[2][1] = findViewById(R.id.button_21);
        buttons[2][2] = findViewById(R.id.button_22);
        buttons[2][3] = findViewById(R.id.button_23);
        buttons[2][4] = findViewById(R.id.button_24);
        buttons[3][0] = findViewById(R.id.button_30);
        buttons[3][1] = findViewById(R.id.button_31);
        buttons[3][2] = findViewById(R.id.button_32);
        buttons[3][3] = findViewById(R.id.button_33);
        buttons[3][4] = findViewById(R.id.button_34);
        buttons[4][0] = findViewById(R.id.button_40);
        buttons[4][1] = findViewById(R.id.button_41);
        buttons[4][2] = findViewById(R.id.button_42);
        buttons[4][3] = findViewById(R.id.button_43);
        buttons[4][4] = findViewById(R.id.button_44);


        Intent b = getIntent();
        A = b.getStringExtra("player1");
        B = b.getStringExtra("player2");
        String[] XO = {"X", "O"};
        XO[0] = "X";
        XO[1] = "O";
        Random rand = new Random();
        pl1 = XO[rand.nextInt(2)];
        if (pl1.equals("X"))
            pl2 = "O";
        else
            pl2 = "X";
        player1.setText("Player1: " + A + "                         " + pl1);
        player2.setText("Player2: " + B + "                         " + pl2);
        if(savedInstanceState!=null) {
            String savedpl1 = savedInstanceState.getString("pl1");
            pl1 = savedpl1;
            String savedpl2 = savedInstanceState.getString("pl2");
            pl2 = savedpl2;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++) {
                    buttons[i][j].setText(savedInstanceState.getString("" + i + j));
                }
        }
        dualmode();
    }

    private void dualmode() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setOnClickListener(this);
            }
    }

    @Override
    public void onClick(View v) {
        if (((Button) v).getText().toString().isEmpty()) {
            if (turn)
                ((Button) v).setText(pl1);
            else
                ((Button) v).setText(pl2);
            turn = !turn;
        } else
            return;
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                if (((buttons[k][0]).getText().toString().equals(buttons[k][1].getText().toString())) && ((buttons[k][0]).getText().toString().equals(buttons[k][2].getText().toString())) && (!buttons[k][0].getText().toString().isEmpty())&&((buttons[k][0]).getText().toString().equals(buttons[k][3].getText().toString()))&&(((buttons[k][0]).getText().toString().equals(buttons[k][4].getText().toString())))) {
                    if (buttons[k][0].getText().toString().equals(pl1)) {
                        winner = A;
                        loser=B;
                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        winner = B;
                        loser=A;
                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                    }
                    (buttons[k][0]).setBackgroundColor(R.drawable.title);
                    (buttons[k][1]).setBackgroundColor(R.drawable.title);
                    (buttons[k][2]).setBackgroundColor(R.drawable.title);
                    (buttons[k][3]).setBackgroundColor(R.drawable.title);
                    (buttons[k][4]).setBackgroundColor(R.drawable.title);
                    break;
                } else if (((buttons[0][k]).getText().toString().equals(buttons[1][k].getText().toString())) && ((buttons[0][k]).getText().toString().equals(buttons[2][k].getText().toString())) && (!buttons[0][k].getText().toString().isEmpty())&&((buttons[0][k]).getText().toString().equals(buttons[3][k].getText().toString()))&&(((buttons[0][k]).getText().toString().equals(buttons[4][k].getText().toString())))) {
                    if (buttons[0][k].getText().toString().equals(pl1)) {
                        winner = A;
                        loser=B;
                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        winner = B;
                        loser=A;
                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                    }
                    (buttons[0][k]).setBackgroundColor(R.drawable.title);
                    (buttons[1][k]).setBackgroundColor(R.drawable.title);
                    (buttons[2][k]).setBackgroundColor(R.drawable.title);
                    (buttons[3][k]).setBackgroundColor(R.drawable.title);
                    (buttons[4][k]).setBackgroundColor(R.drawable.title);
                    break;
                } else if ((buttons[0][0].getText().toString().equals(buttons[1][1].getText().toString()))&&(buttons[0][0].getText().toString().equals(buttons[2][2].getText().toString()))&&(!buttons[0][0].getText().toString().isEmpty())&&(buttons[0][0].getText().toString().equals(buttons[3][3].getText().toString()))&((buttons[0][0].getText().toString().equals(buttons[4][4].getText().toString())))){
                    if (buttons[0][0].getText().toString().equals(pl1)) {
                        winner = A;
                        loser= B;
                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        winner = B;
                        loser=A;
                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                    }
                    (buttons[0][0]).setBackgroundColor(R.drawable.title);
                    (buttons[1][1]).setBackgroundColor(R.drawable.title);
                    (buttons[2][2]).setBackgroundColor(R.drawable.title);
                    (buttons[3][3]).setBackgroundColor(R.drawable.title);
                    (buttons[4][4]).setBackgroundColor(R.drawable.title);
                    break;
                } else  if ((buttons[0][4].getText().toString().equals(buttons[1][3].getText().toString()))&&(buttons[2][2].getText().toString().equals(buttons[0][4].getText().toString()))&&(!buttons[0][4].getText().toString().isEmpty())&&(buttons[0][4].getText().toString().equals(buttons[3][1].getText().toString()))&&((buttons[0][4].getText().toString().equals(buttons[4][0].getText().toString())))){
                    if (buttons[0][4].getText().toString().equals(pl1)) {
                        winner = A;
                        loser=B;
                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        winner = B;
                        loser=A;
                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                    }
                    (buttons[0][4]).setBackgroundColor(R.drawable.title);
                    (buttons[1][3]).setBackgroundColor(R.drawable.title);
                    (buttons[2][2]).setBackgroundColor(R.drawable.title);
                    (buttons[3][1]).setBackgroundColor(R.drawable.title);
                    (buttons[4][0]).setBackgroundColor(R.drawable.title);
                    break;
                }

            }
        }
        if(!winner.isEmpty()){
            Handler m = new Handler();
            m.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent p= new Intent(game5x5.this,finalpage.class);
                    p.putExtra("winner",winner);
                    p.putExtra("loser",loser);
                    p.putExtra("draw","no");
                    startActivity(p);
                    finish();
                }
            },2000);
        }
        else{
            boolean g;
            g=ismoveleft();

            if(g){
                final String draw="Draw";
                Handler m = new Handler();
                m.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent p= new Intent(game5x5.this,finalpage.class);
                        p.putExtra("winner",A);
                        p.putExtra("loser",B);
                        p.putExtra("draw",draw);
                        startActivity(p);
                        finish();
                    }
                },2000);
            }
        }
    }

    private boolean ismoveleft() {
        for(int i =0;i<5;i++)
            for(int j=0;j<5;j++){
                if(buttons[i][j].getText().toString().isEmpty()) {
                    return false;
                }
            }
        return true;
    }
    @Override
    public  void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("pl1",pl1);
        savedInstanceState.putString("pl2",pl2);
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++){
                savedInstanceState.putString(""+i+j,buttons[i][j].getText().toString());
            }
        super.onSaveInstanceState(savedInstanceState);
    }

}