package com.example.retrofitusingrecyclertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyHolder> {

    Context context;
    List<ArticlesModel> articlesModelList=new ArrayList<>();

    public JsonAdapter(Context context, List<ArticlesModel> articlesModelList) {
        this.context = context;
        this.articlesModelList = articlesModelList;
    }

    @NonNull
    @Override
    public JsonAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonAdapter.MyHolder holder, int position) {

        holder.nameText.setText(articlesModelList.get(position).getSourceDetails().getName());
        holder.titleText.setText(articlesModelList.get(position).getTitle());
        holder.descriptionText.setText(articlesModelList.get(position).getDescription());
        holder.publishedAtText.setText(articlesModelList.get(position).getPublishedAt());

        Glide.with(context).load(articlesModelList.get(position).getUrlToImage())
                .centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imageDisplay);

    }

    @Override
    public int getItemCount() {
        return articlesModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

             TextView nameText, titleText,descriptionText, publishedAtText;
             ImageView imageDisplay;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.desciption);
            publishedAtText = itemView.findViewById(R.id.publishedAt);

            imageDisplay = itemView.findViewById(R.id.image);
        }
    }
}
