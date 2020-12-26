package com.cinema.cinema.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.cinema.MainActivity;
import com.cinema.cinema.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginActivityViewInterface {

    private LoginActivityPresenter presenter;

    private EditText email_input, input_password;
    private Button btn_login;
    private TextView Creat_Account_in_login, link_forgotpassword;
    private ImageView backbtn;
    private FirebaseAuth mAuth;
    private String email, password;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginActivityPresenter(this);
    }

    @Override
    public void onLoginSuccess() {
        
    }

    @Override
    public void onLoginFailed(String message) {

    }
}