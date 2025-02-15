package com.example.gana;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Elements
        ImageView logo = findViewById(R.id.appLogo);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);
        TextView signUpText = findViewById(R.id.signUpText);

        // ✅ Logo Animation (Make sure fade_in.xml exists in res/anim)
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        if (fadeIn != null) {
            logo.startAnimation(fadeIn);
        } else {
            Toast.makeText(this, "Animation file missing!", Toast.LENGTH_SHORT).show();
        }

        // ✅ Login Button Click Listener
        loginBtn.setOnClickListener(v -> {
            if (email.getText().toString().equals("test@example.com") &&
                    password.getText().toString().equals("12345")) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // ✅ Sign Up Click Listener
        signUpText.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }
}
