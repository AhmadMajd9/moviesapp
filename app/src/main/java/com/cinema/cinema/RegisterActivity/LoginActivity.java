package com.cinema.cinema.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginActivityPresenter(this);


        // firebase instance
        mAuth = FirebaseAuth.getInstance();
        //inputs from user
        email_input = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        // button
        btn_login = findViewById(R.id.btn_login);
        Creat_Account_in_login = findViewById(R.id.Creat_Account_in_login);
        backbtn = findViewById(R.id.backbtn);
        link_forgotpassword = findViewById(R.id.link_forgotpassword);

        if(mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        btn_login.setOnClickListener(v -> {
            email = email_input.getText().toString().trim();
            password = input_password.getText().toString();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(LoginActivity.this, "One of the fields is missing", Toast.LENGTH_SHORT).show();
            }else if(password.length() < 6){
                Toast.makeText(LoginActivity.this, "Password can't be less than 6 characters", Toast.LENGTH_SHORT).show();
            }else {
                presenter.login(email, password);
            }
        });

        Creat_Account_in_login.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        });

        backbtn.setOnClickListener(v -> onBackPressed());

        link_forgotpassword.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity.class));

        });

    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            this.finishAffinity();
            System.exit(0);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }

}