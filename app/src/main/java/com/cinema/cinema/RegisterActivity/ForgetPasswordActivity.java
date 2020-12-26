package com.cinema.cinema.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.cinema.cinema.R;

public class ForgetPasswordActivity extends AppCompatActivity implements ForgetPasswordActivityViewInterface {
    ForgetPasswordActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        presenter = new ForgetPasswordActivityPresenter(this);
    }

    @Override
    public void onForgetSuccess() {

    }

    @Override
    public void onForgetFailed(String message) {

    }
}