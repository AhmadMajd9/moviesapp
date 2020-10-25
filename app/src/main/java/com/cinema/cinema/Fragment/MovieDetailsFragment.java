package com.cinema.cinema.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cinema.cinema.Adapter.DetiailsPage_Similar_MoviesAdapter;
import com.cinema.cinema.Model.DetiailsPage_Similar_Movies;
import com.cinema.cinema.R;


public class MovieDetailsFragment extends Fragment {
 View root ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_movie_details, container, false);



        DetiailsPage_Similar_Movies[] myListDataSimilar_Movies = new DetiailsPage_Similar_Movies[] {
                new DetiailsPage_Similar_Movies(R.drawable.images3 ),
                new DetiailsPage_Similar_Movies(R.drawable.images2 ),
                new DetiailsPage_Similar_Movies(R.drawable.images1),
        };





       // recyclerViewSimilar_Movies
        RecyclerView RecyclerVueSimilar_Movies = (RecyclerView) root.findViewById(R.id.RecyclerVueSimilar_Movies);
        DetiailsPage_Similar_MoviesAdapter adapterSimilar_Movies = new DetiailsPage_Similar_MoviesAdapter(myListDataSimilar_Movies);
        RecyclerVueSimilar_Movies.setHasFixedSize(true);
        RecyclerVueSimilar_Movies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerVueSimilar_Movies.setAdapter(adapterSimilar_Movies);



        return  root ;
    }
}