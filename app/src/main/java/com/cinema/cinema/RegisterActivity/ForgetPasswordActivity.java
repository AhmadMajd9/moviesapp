package com.cinema.cinema.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinema.cinema.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity implements ForgetPasswordActivityViewInterface {
    ForgetPasswordActivityPresenter presenter;
    EditText input_email;
    TextView link_login;
    Button btn_reset_password;
    String email;
    ImageView backbtn;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        presenter = new ForgetPasswordActivityPresenter(this);

        input_email = findViewById(R.id.email);

        btn_reset_password = findViewById(R.id.btn_reset_password);
        btn_reset_password.setOnClickListener(v -> {

            email = input_email.getText().toString().trim();
            presenter.forget(email);
        });


        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(v -> onBackPressed());

        link_login = findViewById(R.id.link_login);
        link_login.setOnClickListener(v -> onBackPressed());
    }

    @Override
    public void onForgetSuccess() {
        Toast.makeText(getApplicationContext(), "Reset email sent successfully",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onForgetFailed(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}