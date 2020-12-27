package com.cinema.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.cinema.cinema.Fragment.HomePageFragment;
import com.cinema.cinema.Fragment.ProfileFragment;
import com.cinema.cinema.Fragment.SearchFragment;

import com.cinema.cinema.Model.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityViewInterface {
    BottomNavigationView bottomNavigationView;
    public static List<Movie> moviesList;
    public  List<Movie> featuredMovies;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= findViewById(R.id.BottomNavigationView);



        goToMainFragment(new HomePageFragment()) ;


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                                                     @Override
                                                                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                         switch (item.getItemId()) {
                                                                             case R.id.Home:
                                                                                 goToMainFragment(new HomePageFragment()) ;
                                                                                 return true;
                                                                             case R.id.Search:{
                                                                                 goToMainFragment(new SearchFragment()) ;}
                                                                                 return true;
                                                                             case R.id.Profile:{
                                                                                 goToMainFragment(new ProfileFragment()) ;}
                                                                                 return true;
                                                                         }
                                                                         return false;
                                                                     }
                                                                 }
            );


/*
        DetiailsPage_Similar_Movies[] myListDataSimilar_Movies = new DetiailsPage_Similar_Movies[] {
                new DetiailsPage_Similar_Movies(R.drawable.images3 ),
                new DetiailsPage_Similar_Movies(R.drawable.images2 ),
                new DetiailsPage_Similar_Movies(R.drawable.images1),
        };
*/




  /*      // recyclerViewSimilar_Movies
        RecyclerView RecyclerVueSimilar_Movies = (RecyclerView) findViewById(R.id.RecyclerVueSimilar_Movies);
        DetiailsPage_Similar_MoviesAdapter adapterSimilar_Movies = new DetiailsPage_Similar_MoviesAdapter(myListDataSimilar_Movies);
        RecyclerVueSimilar_Movies.setHasFixedSize(true);
        RecyclerVueSimilar_Movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RecyclerVueSimilar_Movies.setAdapter(adapterSimilar_Movies);


*/

   /*     ViewPager mViewPager = (ViewPager) findViewById(R.id.imageView3);
        ImageSliderAdapter adapterView = new ImageSliderAdapter(this);
        mViewPager.setAdapter(adapterView);*/
    }
    public void goToMainFragment(Fragment FragmentName) {

        Fragment fragment =  FragmentName;
        FragmentTransaction ftConfig = getSupportFragmentManager().beginTransaction();
        ftConfig.replace(R.id.FrameLayout, fragment);
        ftConfig.commit();
    }


    @Override
    public void onGetMoviesSuccess(List<Movie> moviesList) {
        
    }

    @Override
    public void onGetMoviesFailed(String message) {

    }
}