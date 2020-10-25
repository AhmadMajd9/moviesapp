package com.cinema.cinema.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.cinema.cinema.Adapter.HomePageFeaturedAdapter;
import com.cinema.cinema.Model.HomePage_Featured;
import com.cinema.cinema.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchFragment extends Fragment {

  View root;
ArrayList<HomePage_Featured> SrearchArray;
ArrayList<HomePage_Featured> myListDataFeature;
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =   inflater.inflate(R.layout.fragment_search, container, false);
        searchView = root.findViewById(R.id.SearchView);

        myListDataFeature = new ArrayList();

        myListDataFeature.add(
                new HomePage_Featured("VENOM", "Action" , "9.9" , "2020" , R.drawable.images3)
                );
        myListDataFeature.add(
                new HomePage_Featured("SpiderMan" , "Action" , "9.9" , "2020" ,R.drawable.images2)
                );
        myListDataFeature.add(
                new HomePage_Featured("The Great Battle" , "Action" , "9.9" , "2020",R.drawable.download)
                );
        myListDataFeature.add(
                new HomePage_Featured("VENOM", "Action" , "9.9" , "2020" , R.drawable.images3)
                );
       myListDataFeature.add(
               new HomePage_Featured("The Great Battle" , "Action" , "9.9" , "2020" , R.drawable.images)
                );
        myListDataFeature.add(
                new HomePage_Featured("The Great Battle" , "Action" , "9.9" , "2020" , R.drawable.images1)
                );




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }});



        // recyclerViewFeature
        RecyclerView recyclerView =  root.findViewById(R.id.result_list);
        HomePageFeaturedAdapter adapter = new HomePageFeaturedAdapter(myListDataFeature);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        return root ;

    }
}