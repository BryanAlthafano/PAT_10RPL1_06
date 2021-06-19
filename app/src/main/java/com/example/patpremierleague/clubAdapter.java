package com.example.patpremierleague;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class clubAdapter extends RecyclerView.Adapter<clubAdapter.clubHolder> {

    private ArrayList<setterGetter> listData;
    private Callback callback;

    interface Callback {
        void onClick(int position);
    }

    public clubAdapter(ArrayList<setterGetter> listData, Callback callback){
        this.listData = listData;
        this.callback = callback;
    }

    @NonNull
    @Override
    public clubHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_club,parent,false);
        clubHolder holder = new clubHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull clubAdapter.clubHolder holder, int position) {
        final setterGetter getData = listData.get(position);
        String name = getData.getName();
        String description = getData.getDescription();
        String image = getData.getImage();

        holder.nameClub.setText(name);
        holder.descriptionClub.setText(description);

        if(image.equals("arsenal")){
            holder.imageClub.setImageResource(R.drawable.arsenal);
        }else if(image.equals("aston")){
            holder.imageClub.setImageResource(R.drawable.aston);
        }else if(image.equals("brighton")){
            holder.imageClub.setImageResource(R.drawable.brighton);
        }else if(image.equals("burnley")){
            holder.imageClub.setImageResource(R.drawable.burnley);
        }else if(image.equals("chelsea")){
            holder.imageClub.setImageResource(R.drawable.chelsea);
        }else if(image.equals("crystal")){
            holder.imageClub.setImageResource(R.drawable.crystal);
        }else if(image.equals("everton")){
            holder.imageClub.setImageResource(R.drawable.everton);
        }else if(image.equals("fulham")){
            holder.imageClub.setImageResource(R.drawable.fulham);
        }else if(image.equals("leeds")){
            holder.imageClub.setImageResource(R.drawable.leeds);
        }else if(image.equals("leicester")){
            holder.imageClub.setImageResource(R.drawable.leicester);
        }else if(image.equals("liverpool")){
            holder.imageClub.setImageResource(R.drawable.liverpool);
        }else if(image.equals("mancity")){
            holder.imageClub.setImageResource(R.drawable.mancity);
        }else if(image.equals("manutd")){
            holder.imageClub.setImageResource(R.drawable.manutd);
        }else if(image.equals("newcastle")){
            holder.imageClub.setImageResource(R.drawable.newcastle);
        }else if(image.equals("sheffield")){
            holder.imageClub.setImageResource(R.drawable.sheffield);
        }else if(image.equals("southampton")){
            holder.imageClub.setImageResource(R.drawable.southampton);
        }else if(image.equals("tottenham")){
            holder.imageClub.setImageResource(R.drawable.tottenham);
        }else if(image.equals("wba")){
            holder.imageClub.setImageResource(R.drawable.wba);
        }else if(image.equals("westham")){
            holder.imageClub.setImageResource(R.drawable.westham);
        }else if(image.equals("wolverhampton")){
            holder.imageClub.setImageResource(R.drawable.wolverhampton);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class clubHolder extends RecyclerView.ViewHolder {

        TextView nameClub;
        TextView descriptionClub;
        ImageView imageClub;
        LinearLayout linearLayout;

        public clubHolder(@NonNull View itemView) {
            super(itemView);

            nameClub = itemView.findViewById(R.id.name);
            descriptionClub = itemView.findViewById(R.id.description);
            imageClub = itemView.findViewById(R.id.image);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });

        }
    }
}
