package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.GalleryViewHolder> {
    private List<com.example.tourismapp.Gallery> galleryList;
    private Context context;
    private OnRowClickListener listener;

    public HorizontalAdapter(List<Gallery> galleryList, Context context, OnRowClickListener clickListener) {
        this.galleryList = galleryList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.gallery_row, parent, false);
        return new GalleryViewHolder(itemView, listener);
    }

    public interface OnRowClickListener {
        void onItemClick (int position);
    }
    public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView galleryImageView;
        public OnRowClickListener onRowClickListener;

        public GalleryViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            galleryImageView = itemView.findViewById(R.id.galleryImageView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }
    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.galleryImageView.setImageResource(galleryList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return galleryList.size();
    }
}