package com.example.myapplication;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    JSONArray heroList;

    public HeroesAdapter(Context mCtx, JSONArray heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @Override
    public HeroViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        String hero = null;
        try {
            hero = heroList.getString(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Glide.with(mCtx)
                .load(hero)
                .into(holder.imageView);

        holder.textView.setText("item "+position);
        holder.textView1.setText("Description of item "+position);
    }

    @Override
    public int getItemCount() {
        return heroList.length();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,textView1;

        public HeroViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView1);
        }
    }
}
