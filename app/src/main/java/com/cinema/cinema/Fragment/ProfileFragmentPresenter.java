package com.cinema.cinema.Fragment;



import android.net.Uri;

import java.io.File;

public class ProfileFragmentPresenter implements ProfileFragmentPresenterInterface {
  private ProfileFragmentViewInterface view;

  public ProfileFragmentPresenter(ProfileFragmentViewInterface view) {
    this.view = view;
  }

  @Override
  public File createImageFile(){

      return null;
  }

    @Override
    public void uploadImage(Uri imageFile) {

    }

    @Override
    public void getUserData() {

    }
}