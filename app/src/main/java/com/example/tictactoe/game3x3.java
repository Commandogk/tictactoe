package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game3x3 extends AppCompatActivity {
    TextView player1, player2;
    Boolean turn;
    Button[][] buttons = new Button[3][3];
    String[][] board = new String[3][3];
    String A, B, pl1, pl2, winner = "",loser="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3x3);
        player1 = findViewById(R.id.player1name);
        player2 = findViewById(R.id.player2name);
        buttons[0][0] = findViewById(R.id.button_00);
        buttons[0][1] = findViewById(R.id.button_01);
        buttons[0][2] = findViewById(R.id.button_02);
        buttons[1][0] = findViewById(R.id.button_10);
        buttons[1][1] = findViewById(R.id.button_11);
        buttons[1][2] = findViewById(R.id.button_12);
        buttons[2][0] = findViewById(R.id.button_20);
        buttons[2][1] = findViewById(R.id.button_21);
        buttons[2][2] = findViewById(R.id.button_22);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = " ";
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
        if (pl1.equals("X"))
            turn = true;
        else
            turn = false;
        player1.setText("Player1: " + A + "---" + pl1);
        player2.setText("Player2: " + B + "---" + pl2);
        if(savedInstanceState!=null){
            String savedpl1 = savedInstanceState.getString("pl1");
            pl1=savedpl1;
            String savedpl2 = savedInstanceState.getString("pl2");
            pl2=savedpl2;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    buttons[i][j].setText(savedInstanceState.getString(""+i+j));
                }
        }
        else{
        }

        if (b.getBooleanExtra("solo",false)) {
            solomode();

        } else {
            dualmode();

        }
    }

    private int Win(String[][] board) {
        for (int i= 0; i<3; i++)
        {
            if( (board[i][0]==board[i][1] )&& (board[i][1]==board[i][2]))
            {
                if (board[i][0]==pl2)
                    return +10;
                else if (board[i][0]==pl1)
                    return -10;
            }
            if ((board[0][i]==board[1][i]) &&(board[1][i]==board[2][i]))
            {
                if (board[0][i]==pl2)
                    return +10;

                else if (board[0][i]==pl1)
                    return -10;
            }
        }

        if ((board[0][0]==board[1][1] )&& (board[1][1]==board[2][2]))
        {
            if (board[0][0]==pl2)
                return +10;
            else if (board[0][0]==pl1)
                return -10;
        }

        if (board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            if (board[0][2]==pl2)
                return +10;
            else if (board[0][2]==pl1)
                return -10;
        }
        return 0;
    }

    private void dualmode() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setOnClickListener(new OnClickListener() {
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
                        for (int k = 0; k < 3; k++) {
                            for (int j = 0; j < 3; j++) {
                                if (((buttons[k][0]).getText().toString().equals(buttons[k][1].getText().toString())) && ((buttons[k][0]).getText().toString().equals(buttons[k][2].getText().toString())) && (!buttons[k][0].getText().toString().isEmpty())) {
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
                                    break;
                                } else if (((buttons[0][k]).getText().toString().equals(buttons[1][k].getText().toString())) && ((buttons[0][k]).getText().toString().equals(buttons[2][k].getText().toString())) && (!buttons[0][k].getText().toString().isEmpty())) {
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
                                    break;
                                } else if ((buttons[0][0].getText().toString().equals(buttons[1][1].getText().toString())) && (buttons[0][0].getText().toString().equals(buttons[2][2].getText().toString())) && (!buttons[0][0].getText().toString().isEmpty())) {
                                    if (buttons[0][0].getText().toString().equals(pl1)) {
                                        winner = A;
                                        loser=B;
                                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        winner = B;
                                        loser=A;
                                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                                    }
                                    (buttons[0][0]).setBackgroundColor(R.drawable.title);
                                    (buttons[1][1]).setBackgroundColor(R.drawable.title);
                                    (buttons[2][2]).setBackgroundColor(R.drawable.title);
                                    break;
                                } else if ((buttons[0][2].getText().toString().equals(buttons[1][1].getText().toString())) && (buttons[0][2].getText().toString().equals(buttons[2][0].getText().toString())) && (!buttons[0][2].getText().toString().isEmpty())) {
                                    if (buttons[0][0].getText().toString().equals(pl1)) {
                                        winner = A;
                                        loser=B;
                                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        winner = B;
                                        loser=A;
                                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                                    }
                                    (buttons[0][2]).setBackgroundColor(R.drawable.title);
                                    (buttons[1][1]).setBackgroundColor(R.drawable.title);
                                    (buttons[2][0]).setBackgroundColor(R.drawable.title);
                                    break;
                                }

                            }
                        }
                        if(!winner.isEmpty()){
                            Handler m = new Handler();
                            m.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent p= new Intent(game3x3.this,finalpage.class);
                                    p.putExtra("winner",winner);
                                    p.putExtra("loser",loser);
                                    p.putExtra("draw","no");
                                    startActivity(p);
                                    finish();
                                }
                            },3000);
                        }
                        else{
                            boolean g;
                            g=ismoveleft();

                            if(g){
                                final String draw ="Draw";
                                Handler m = new Handler();
                                m.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent p= new Intent(game3x3.this,finalpage.class);
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

                });

            }


    }

    private boolean ismovelft(String board[][]) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty())
                    return true;
            }
        return false;
    }

    private void solomode() {
        final int m = -1, n = -1;
        for (int p = 0; p < 3; p++)
            for (int l = 0; l < 3; l++) {

                buttons[p][l].setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (turn) {
                            if (((Button) view).getText().toString().isEmpty()) {
                                ((Button) view).setText(pl1);
                            }
                            else
                                return;
                            turn = !turn;
                        }
                        for (int i = 0; i < 3; i++)
                            for (int j = 0; j < 3; j++)
                                board[i][j] = buttons[i][j].getText().toString();
                        if (ismovelft(board))
                            Findbestmove(board, m, n);
                        for (int k = 0; k < 3; k++) {
                            for (int j = 0; j < 3; j++) {
                                if (((buttons[k][0]).getText().toString().equals(buttons[k][1].getText().toString())) && ((buttons[k][0]).getText().toString().equals(buttons[k][2].getText().toString())) && (!buttons[k][0].getText().toString().isEmpty())) {
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
                                    break;
                                } else if (((buttons[0][k]).getText().toString().equals(buttons[1][k].getText().toString())) && ((buttons[0][k]).getText().toString().equals(buttons[2][k].getText().toString())) && (!buttons[0][k].getText().toString().isEmpty())) {
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
                                    break;
                                } else if ((buttons[0][0].getText().toString().equals(buttons[1][1].getText().toString())) && (buttons[0][0].getText().toString().equals(buttons[2][2].getText().toString())) && (!buttons[0][0].getText().toString().isEmpty())) {
                                    if (buttons[0][0].getText().toString().equals(pl1)) {
                                        winner = A;
                                        loser=B;
                                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        winner = B;
                                        loser=A;
                                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                                    }
                                    (buttons[0][0]).setBackgroundColor(R.drawable.title);
                                    (buttons[1][1]).setBackgroundColor(R.drawable.title);
                                    (buttons[2][2]).setBackgroundColor(R.drawable.title);
                                    break;
                                } else if ((buttons[0][2].getText().toString().equals(buttons[1][1].getText().toString())) && (buttons[0][2].getText().toString().equals(buttons[2][0].getText().toString())) && (!buttons[0][2].getText().toString().isEmpty())) {
                                    if (buttons[0][0].getText().toString().equals(pl1)) {
                                        winner = A;
                                        loser=B;
                                        Toast.makeText(getApplicationContext(), A + "wins!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        winner = B;
                                        loser=A;
                                        Toast.makeText(getApplicationContext(), B + "wins!", Toast.LENGTH_SHORT).show();
                                    }
                                    (buttons[0][2]).setBackgroundColor(R.drawable.title);
                                    (buttons[1][1]).setBackgroundColor(R.drawable.title);
                                    (buttons[2][0]).setBackgroundColor(R.drawable.title);
                                    break;
                                }

                            }
                        }
                        if(!winner.isEmpty()){
                            Handler m = new Handler();
                            m.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent p= new Intent(game3x3.this,finalpage.class);
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
                                final String draw ="Draw";
                                Handler m = new Handler();
                                m.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent p= new Intent(game3x3.this,finalpage.class);
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

                });
            }
    }
    private boolean ismoveleft() {
        for(int i =0;i<3;i++)
            for(int j=0;j<3;j++){
                if(buttons[i][j].getText().toString().isEmpty()) {
                    return false;
                }
            }
        return true;
    }
    private void Findbestmove(String[][] board, int m, int n) {

        int bestVal = -100;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j].isEmpty())
                {
                    board[i][j] = pl2;
                    int moveVal = Minimax(board, 0, false);
                    board[i][j] = buttons[i][j].getText().toString();
                    if (moveVal > bestVal)
                    {
                        m=i;n=j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        buttons[m][n].setText(pl2);
        turn = !turn;
    }

    private int Minimax(String board[][],
                       int count, Boolean Ai)
    {
        int score = Win(board);
        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (ismovelft(board) == false)
            return 0;
        if (Ai) {
            int best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].isEmpty()) {
                        board[i][j] = pl2;
                        best =( Math.max(best, Minimax(board, count + 1, !Ai))-count);
                        board[i][j] = buttons[i][j].getText().toString();
                    }
                }
            }
            return best;
        }
        else
        {
            int best = 100;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j].isEmpty())
                    {
                        board[i][j] = pl1;
                        best = (Math.min(best, Minimax(board,  count+ 1, !Ai))+count);
                        board[i][j] = buttons[i][j].getText().toString();
                    }
                }
            }
            return best;
        }
    }
    @Override
    public  void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("pl1",pl1);
        savedInstanceState.putString("pl2",pl2);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                savedInstanceState.putString(""+i+j,buttons[i][j].getText().toString());
            }
         super.onSaveInstanceState(savedInstanceState);
    }
}