package com.example.imsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    ImageView backbutton;
    private EditText editTextUserName, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt = findViewById(R.id.textView14);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PasswordRecovery1.class);
                startActivity(intent);
            }
        });

        editTextUserName = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText3);

        findViewById(R.id.imageView3).setOnClickListener(this);

        backbutton = findViewById(R.id.imageView3);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void userSignUp(){
        String email = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (email.isEmpty()){
            editTextUserName.setError("Email is required");
            editTextUserName.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextUserName.setError("Enter a valid email");
            editTextUserName.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextUserName.setError("Password is required");
            editTextUserName.requestFocus();
            return;
        }

        if (password.length() < 6){
            editTextUserName.setError("Password must be a least 6 characters long");
            editTextUserName.requestFocus();
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView3:
                userSignUp();
        }
    }
}
