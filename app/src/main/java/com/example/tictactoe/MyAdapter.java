package com.example.tictactoe;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    int count=1;
    String w[],l[],d[];
    Context ct;
    public MyAdapter(Context context, String[] winner, String[] loser, String[] draw,int cout) {
        w=winner;
        l=loser;
        d=draw;
        ct=context;
        count=cout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(ct);
       View view = inflater.inflate(R.layout.module,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if((w[position].equals("w"))&&(d[position].equals("no"))&&(l[position].equals("l"))){
            holder.draw.setVisibility(View.INVISIBLE);
            holder.draw.setVisibility(View.INVISIBLE);
            holder.win.setVisibility(View.INVISIBLE);
            holder.won.setVisibility(View.INVISIBLE);
            holder.lost.setVisibility(View.INVISIBLE);
            holder.t.setVisibility(View.INVISIBLE);
            holder.u.setVisibility(View.INVISIBLE);
            holder.y.setVisibility(View.INVISIBLE);
            holder.o.setVisibility(View.INVISIBLE);
        }
        else{
            holder.draw.setVisibility(View.VISIBLE);
            holder.draw.setVisibility(View.VISIBLE);
            holder.win.setVisibility(View.VISIBLE);
            holder.won.setVisibility(View.VISIBLE);
            holder.lost.setVisibility(View.VISIBLE);
            holder.t.setVisibility(View.VISIBLE);
            holder.u.setVisibility(View.VISIBLE);
            holder.y.setVisibility(View.VISIBLE);
            holder.o.setVisibility(View.VISIBLE);
        if(d[position].equals("no")){

            holder.draw.setVisibility(View.INVISIBLE);
            holder.playerwin.setText(w[position]);
            holder.playerlost.setText(l[position]);
            holder.won.setImageResource(R.drawable.win);
            holder.won.setBackgroundColor(Color.TRANSPARENT);

        }
        else{
            holder.playerwin.setText(w[position]);
            holder.playerlost.setText(l[position]);
            holder.draw.setVisibility(View.VISIBLE);
            holder.win.setVisibility(View.INVISIBLE);
            holder.won.setVisibility(View.INVISIBLE);
            holder.lost.setVisibility(View.INVISIBLE);
            holder.won.setImageResource(R.drawable.win);
            holder.won.setBackgroundColor(Color.TRANSPARENT);
        }

        }

    }

    @Override
    public int getItemCount() {
        return w.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView win,lost,draw,playerwin,playerlost;
        ImageView won;
        ConstraintLayout t;
        RelativeLayout y;
        CardView u;
        RecyclerView o;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            playerwin= ((View)itemView).findViewById(R.id.playerw );
            playerlost= ((View)itemView).findViewById(R.id.playerl );
            win=((View)itemView).findViewById(R.id.win);
            lost=((View)itemView).findViewById(R.id.lose);
            draw=((View)itemView).findViewById(R.id.draw);
            won=((View)itemView).findViewById(R.id.imgw);
            t=itemView.findViewById(R.id.full);
            y=itemView.findViewById(R.id.full3);
            u=itemView.findViewById(R.id.full1);
            o=itemView.findViewById(R.id.full2);
        }
    }
}
