package com.androidabcd.networking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidabcd.networking.R;
import com.androidabcd.networking.model.ItemsItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.GithubViewHolder> {

    private List<ItemsItem> listItems;

    public void setListItems(List<ItemsItem> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        holder.tvName.setText(listItems.get(position).getLogin());
        holder.tvDesc.setText(listItems.get(position).getUrl());
        Glide.with(holder.imageView)
                .load(listItems.get(position).getAvatarUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(listItems == null)
            return 0;
        else
            return listItems.size();
    }


    //Viewholder is complete
    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName;
        TextView tvDesc;

        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
