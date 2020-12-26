package com.cinema.cinema.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cinema.cinema.R;


public class CatalogiesFragment extends Fragment {
    TextView categoryTv ;
    View root ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_catalogies, container, false);
        categoryTv = root.findViewById(R.id.categoryTv) ;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            categoryTv.setText(bundle.getString("catName"));
        }

        return root;

    }
}