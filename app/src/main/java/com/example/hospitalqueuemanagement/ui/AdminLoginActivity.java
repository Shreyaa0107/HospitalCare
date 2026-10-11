package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalqueuemanagement.R;

public class AdminLoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        EditText username = findViewById(R.id.edtAdminUsername);
        EditText password = findViewById(R.id.edtAdminPassword);
        Button loginButton = findViewById(R.id.btnAdminLogin);

        loginButton.setOnClickListener(v -> {

            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            // Basic admin login for project/demo
            if (user.equals("admin") && pass.equals("admin123")) {

                Intent intent = new Intent(
                        AdminLoginActivity.this,
                        AdminDashboardActivity.class
                );

                startActivity(intent);
                finish();

            } else {
                Toast.makeText(
                        AdminLoginActivity.this,
                        "Invalid Admin Login",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}