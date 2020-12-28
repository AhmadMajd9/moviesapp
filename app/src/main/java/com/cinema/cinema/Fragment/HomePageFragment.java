package com.cinema.cinema.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.cinema.cinema.Adapter.HomePageCategoriesAdapter;
import com.cinema.cinema.Adapter.HomePageFeaturedAdapter;
import com.cinema.cinema.Adapter.ImageSliderAdapter;
import com.cinema.cinema.Model.HomePage_Featured;
import com.cinema.cinema.Model.HomePage_categories;
import com.cinema.cinema.R;
import java.util.ArrayList;


public class HomePageFragment extends Fragment {
  View root;
  ArrayList<HomePage_Featured> myListDataFeature;
  ArrayList<HomePage_categories> myListDataCategories;

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    root = inflater.inflate(R.layout.fragment_home_page, container, false);


    myListDataFeature = new ArrayList();
    myListDataCategories = new ArrayList();

    ViewPager moViewPager = (ViewPager) root.findViewById(R.id.imageView3);
    ImageSliderAdapter adapterView = new ImageSliderAdapter(getContext());
    moViewPager.setAdapter(adapterView);

    myListDataCategories.add(
                new HomePage_categories(R.drawable.img1, "Comedy")
    );
    myListDataCategories.add(
                new HomePage_categories(R.drawable.img2, "Action"));
    myListDataCategories.add(
                new HomePage_categories(R.drawable.img2, "Action")
    );




    myListDataFeature.add(
                new HomePage_Featured("VENOM", "Action", "9.9", "2020", R.drawable.images3)
    );
    myListDataFeature.add(
                new HomePage_Featured("SpiderMan", "Action", "9.9", "2020", R.drawable.images2)
    );
    myListDataFeature.add(
                new HomePage_Featured("The Great Battle", "Action",
                        "9.9", "2020", R.drawable.download)
    );
    myListDataFeature.add(
                new HomePage_Featured("VENOM", "Action", "9.9", "2020", R.drawable.images3)
    );
    myListDataFeature.add(
                new HomePage_Featured("The Great Battle", "Action",
                        "9.9", "2020", R.drawable.images)
    );
    myListDataFeature.add(
                new HomePage_Featured("The Great Battle", "Action",
                        "9.9", "2020", R.drawable.images1)
    );


    // recyclerViewFeature
    RecyclerView recyclerView =  root.findViewById(R.id.RecyclerView);
    HomePageFeaturedAdapter adapter = new HomePageFeaturedAdapter(myListDataFeature);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
            LinearLayoutManager.HORIZONTAL, false));
    recyclerView.setAdapter(adapter);

    // recyclerViewCategories
    RecyclerView recyclerViewCategories =
             (RecyclerView) root.findViewById(R.id.CategoriesRecyclerView);
    HomePageCategoriesAdapter adapterCategories =
                new HomePageCategoriesAdapter(myListDataCategories);
    recyclerViewCategories.setHasFixedSize(true);
    recyclerViewCategories.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
    recyclerViewCategories.setAdapter(adapterCategories);

    return  root;
  }
}