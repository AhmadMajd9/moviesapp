package com.cinema.cinema.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cinema.cinema.FavoritesFragment;
import com.cinema.cinema.Model.User;
import com.cinema.cinema.R;
import com.cinema.cinema.registeractivity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment implements ProfileFragmentViewInterface {

    View root;
    LinearLayout FavoritesLiner;

    private ImageView profile_img;
    private LinearLayout LogOut;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private TextView profile_uesrname, numberid_profile, email_profile;
    private static final int pic_id = 123;
    private java.io.File image_file;
    private StorageReference mStorageRef;
    private String fileUrl;
    private ProgressDialog dialog;
    String imageFilePath;
    ProfileFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_profile, container, false);
        FavoritesLiner = root.findViewById(R.id.FavoritessItme);
        presenter = new ProfileFragmentPresenter(this);

        // get views
        profile_uesrname = root.findViewById(R.id.profile_uesrname);
        numberid_profile = root.findViewById(R.id.numberid_profile);
        email_profile = root.findViewById(R.id.email_profile);
        profile_img = root.findViewById(R.id.profile_img);
        LogOut = root.findViewById(R.id.LogOut);

        //Firebase Instance
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();


        FavoritesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainFragment(new FavoritesFragment());
            }
        });
        presenter.getUserData();

        //action to change profile picture
        profile_img.setOnClickListener(v -> openCameraIntent());

        //logout action
        LogOut.setOnClickListener(v -> {
            FirebaseUser user = mAuth.getCurrentUser();
            if(user != null){
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            } else {
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
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

    @Override
    public void onUploadSuccess(String url) {
        fileUrl = url;
        Toast.makeText(getContext(), "Image uploaded successfully", Toast.LENGTH_LONG);
        dialog.dismiss();
    }

    @Override
    public void onUploadFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
        dialog.dismiss();
    }

    @Override
    public void onGetProfileSuccess(User user) {
        profile_uesrname.setText(user.getName());
        numberid_profile.setText(user.getPhoneNumber());
        email_profile.setText(user.getEmail());
        if(getContext() != null) {
            if(user.getPictureLink() != null) {
                Glide.with(getContext()).load(user.getPictureLink()).into(profile_img);
            }
        }
    }

    @Override
    public void onProfileDataFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG);
    }

    // listen to the result coming back from camera intent and call uploadImage function.
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case pic_id:
                if (resultCode == RESULT_OK) {

                    Matrix matrix = new Matrix();
                    try {
                        ExifInterface exif = new ExifInterface(imageFilePath);
                        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                        switch (orientation) {
                            case ExifInterface.ORIENTATION_ROTATE_90:
                                matrix.postRotate(90);
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_180:
                                matrix.postRotate(180);
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_270:
                                matrix.postRotate(270);
                                break;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    image_file=new java.io.File(imageFilePath);
                    Uri selectedImage =(Uri.fromFile(image_file));

                    InputStream imageStream = null;
                    try {
                        imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    final Bitmap imagebitmap = BitmapFactory.decodeStream(imageStream);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(imagebitmap, 0, 0, imagebitmap.getWidth(), imagebitmap.getHeight(), matrix, true);

                    Bitmap  resized = Bitmap.createScaledBitmap(rotatedBitmap,(int)(rotatedBitmap.getWidth()*0.7), (int)(rotatedBitmap.getHeight()*0.7), true);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    resized.compress(Bitmap.CompressFormat.JPEG, 20, baos);

                    profile_img.setImageBitmap(resized);
                    Log.d("profile", "image path: "+imageFilePath);

                    if(selectedImage != null){
                        dialog = new ProgressDialog(getContext());
                        dialog.setCancelable(false);
                        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        dialog.setProgress(0);
                        dialog.setMessage("Uploading...");
                        dialog.show();

                        presenter.uploadImage(selectedImage);
                    }
                }
        }
    }


    // function to open camera intent and make temp file for image
    private void openCameraIntent() {
        Intent pictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);

        Log.d("profile", "inside");
        //Create a file to store the image
        java.io.File photoFile = null;
        try {
            photoFile = presenter.createImageFile();
            imageFilePath = photoFile.getAbsolutePath();
        } catch (IOException ex) {
            // Error occurred while creating the File

        }
        if (photoFile != null) {
            Uri photoURI = FileProvider.getUriForFile(getContext().getApplicationContext(), getActivity().getPackageName()+".provider", photoFile);
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(pictureIntent, pic_id);
        }
    }
}