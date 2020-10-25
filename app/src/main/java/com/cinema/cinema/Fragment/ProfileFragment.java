package com.cinema.cinema.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cinema.cinema.ChangePassWordFragment;
import com.cinema.cinema.FavoritesFragment;
import com.cinema.cinema.R;
import com.cinema.cinema.RegisterActivity.ForgetPasswordActivity;

public class ProfileFragment extends Fragment {

    View root ;
    LinearLayout FavoritesLiner;
    LinearLayout ChangePassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_profile, container, false);
        FavoritesLiner = root.findViewById(R.id.FavoritessItme);
        ChangePassword = root.findViewById(R.id.ChangePassword);

        FavoritesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainFragment(new FavoritesFragment());
            }
        });

        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainFragment(new ChangePassWordFragment());
            }
        });

        return root;
    }
    public void goToMainFragment(Fragment FragmentName) {

        Fragment fragment =  FragmentName;
        FragmentTransaction ftConfig = getActivity().getSupportFragmentManager().beginTransaction();
        ftConfig.replace(R.id.FrameLayout, fragment);
        ftConfig.commit();
    }

}