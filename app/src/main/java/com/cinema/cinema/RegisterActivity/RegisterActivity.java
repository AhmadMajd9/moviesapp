package com.cinema.cinema.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.cinema.MainActivity;
import com.cinema.cinema.Model.User;
import com.cinema.cinema.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity implements RegisterActivityViewInterface {
    RegisterActivityPresenter presenter;

    private FirebaseAuth mAuth;
    private EditText input_name, input_email, input_password, input_phonenumber;
    private Button btn_signup;
    private TextView loginBtnSignUp;
    private String email, password, phonenumber, name;
    private ImageView backbtn;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter = new RegisterActivityPresenter(this);


        // firebase instances
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        // inputs
        input_name = findViewById(R.id.input_name);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_phonenumber = findViewById(R.id.input_phonenumber);
        // buttons
        btn_signup = findViewById(R.id.btn_signup);
        loginBtnSignUp = findViewById(R.id.loginBtnSignUp);
        backbtn = findViewById(R.id.backbtn);


        btn_signup.setOnClickListener(v -> {
            email = input_email.getText().toString().trim();
            password = input_password.getText().toString();
            phonenumber = input_phonenumber.getText().toString().trim();
            name = input_name.getText().toString().trim();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phonenumber) || TextUtils.isEmpty(name)){
                Toast.makeText(RegisterActivity.this, "One of the fields is missing.", Toast.LENGTH_SHORT).show();
            }else if (password.length() < 6){
                Toast.makeText(RegisterActivity.this, "Password can't be less than 6 characters", Toast.LENGTH_SHORT).show();
            }else {
                presenter.createAccount(email, password, name, phonenumber);
            }

        });

        loginBtnSignUp.setOnClickListener(v -> {
            onBackPressed();
        });

        backbtn.setOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onCreateSuccess(String email, String name, String phone) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User userData = new User(user.getUid(), name, email, phonenumber, null);
        db.collection("users").document(user.getUid()).set(userData);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onCreateFailed(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}