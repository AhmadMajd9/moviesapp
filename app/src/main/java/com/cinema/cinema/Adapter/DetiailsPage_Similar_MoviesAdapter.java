package com.cinema.cinema.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.cinema.cinema.Model.DetiailsPage_Similar_Movies;
import com.cinema.cinema.R;


public class DetiailsPage_Similar_MoviesAdapter extends RecyclerView.Adapter<DetiailsPage_Similar_MoviesAdapter.ViewHolder>{
    private DetiailsPage_Similar_Movies[] listdata;


    // RecyclerView recyclerView;
    public DetiailsPage_Similar_MoviesAdapter(DetiailsPage_Similar_Movies[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.details_simailar_films, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv_image.setBackgroundResource(listdata[position].getImg());

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.iv_image = (ImageView) itemView.findViewById(R.id.iv_image1);
        }
    }
}
