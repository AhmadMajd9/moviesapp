package com.cinema.cinema.Adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.cinema.cinema.Fragment.CatalogiesFragment;
import com.cinema.cinema.Model.HomePage_Featured;
import com.cinema.cinema.Model.HomePage_categories;
import com.cinema.cinema.R;

import java.util.ArrayList;


public class HomePageCategoriesAdapter extends RecyclerView.Adapter<HomePageCategoriesAdapter.ViewHolder> {
    private ArrayList<HomePage_categories> listdata;


    // RecyclerView recyclerView;
    public HomePageCategoriesAdapter(ArrayList<HomePage_categories> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.home_page_categories_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String cata = listdata.get(position).getCagTitle();
        holder.title.setText(listdata.get(position).getCagTitle());
        holder.iv_image.setBackgroundResource(listdata.get(position).getImg());
        holder.iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("aaa1" , "it's Cilcked");
                Fragment fragment = new CatalogiesFragment();
                Bundle bundle = new Bundle();
                bundle.putString("cate" ,cata );
                fragment.setArguments(bundle);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tv_cataogle);
            this.iv_image = (ImageView) itemView.findViewById(R.id.imageView4);
        }
    }




}
