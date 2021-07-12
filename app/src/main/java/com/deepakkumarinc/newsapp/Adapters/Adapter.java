package com.deepakkumarinc.newsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deepakkumarinc.newsapp.Models.ModelClass;
import com.deepakkumarinc.newsapp.R;
import com.deepakkumarinc.newsapp.webView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelList;

    public Adapter(Context context, ArrayList<ModelClass> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull

    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",modelList.get(position).getUrl());
                context.startActivity(intent);

            }
        });

        holder.time.setText("Published At:-"+modelList.get(position).getPublishedAt());
        holder.author.setText(modelList.get(position).getAuthor());
        holder.heading.setText(modelList.get(position).getTitle());
        holder.content.setText(modelList.get(position).getDescription());

        Glide.with(context).load(modelList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, content, author, time;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
