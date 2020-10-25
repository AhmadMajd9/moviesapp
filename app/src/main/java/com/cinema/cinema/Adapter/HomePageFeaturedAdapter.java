package com.cinema.cinema.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cinema.cinema.Model.HomePage_Featured;
import com.cinema.cinema.R;

import java.util.ArrayList;

public class HomePageFeaturedAdapter extends RecyclerView.Adapter<HomePageFeaturedAdapter.ViewHolder>{
    private ArrayList<HomePage_Featured> listdata;


    // RecyclerView recyclerView;
    public HomePageFeaturedAdapter(ArrayList<HomePage_Featured> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.home_page_featured_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HomePage_Featured myListData = listdata.get(position);
        holder.title.setText(listdata.get(position).getTitle());
        holder.cataloge.setText(listdata.get(position).getCataloge());
        holder.retting.setText(listdata.get(position).getRetting());
        holder.date.setText("("+ listdata.get(position).getDate()+")");
        holder.iv_image.setBackgroundResource(listdata.get(position).getImg());

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView cataloge;
        public TextView retting;
        public TextView date;
        public ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tv_Title);
            this.cataloge = (TextView) itemView.findViewById(R.id.tv_cataloge);
            this.retting = (TextView) itemView.findViewById(R.id.tv_ratting);
            this.date = (TextView) itemView.findViewById(R.id.tv_date);
            this.iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}