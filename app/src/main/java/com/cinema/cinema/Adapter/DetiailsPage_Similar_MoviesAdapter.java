package com.cinema.cinema.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cinema.cinema.Model.DetiailsPage_Similar_Movies;
import com.cinema.cinema.Model.Movie;
import com.cinema.cinema.R;

import java.util.List;


public class DetiailsPage_Similar_MoviesAdapter extends RecyclerView.Adapter<DetiailsPage_Similar_MoviesAdapter.ViewHolder>{
    private List<Movie> listdata;
    private Context context;
    private DetiailsPage_Similar_MoviesAdapter.OnItemClickListener mOnItemClickListener;

    // RecyclerView recyclerView;
    public DetiailsPage_Similar_MoviesAdapter(Context context, List<Movie> listdata, DetiailsPage_Similar_MoviesAdapter.OnItemClickListener mOnItemClickListener) {
        this.listdata = listdata;
        this.context = context;
        this.mOnItemClickListener = mOnItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.details_simailar_films, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem, mOnItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = listdata.get(position);
        Glide.with(context).load(movie.getUrlPoster()).into(holder.iv_image);

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView iv_image;
        DetiailsPage_Similar_MoviesAdapter.OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView, DetiailsPage_Similar_MoviesAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            this.iv_image = (ImageView) itemView.findViewById(R.id.iv_image1);

            //listener
            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

    }
}
