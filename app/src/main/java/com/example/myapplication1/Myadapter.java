package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    String data1[], data2[];
    int imager[];
    Context context;


    public Myadapter(Context ct, String s1[], String s2 [],int img[]){
        context = ct;
        data1= s1;
        data2 = s2;
        imager = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.myText1.setText(data1[position]);
        holder.myImage.setImageResource(imager[position]);

    }

    @Override
    public int getItemCount() {

        return imager.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout  lineritem;
        TextView myText1;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.list_item1);
            myImage = itemView.findViewById(R.id.myImageView);
            lineritem = itemView.findViewById(R.id.layoutItem);
        }
    }
}
