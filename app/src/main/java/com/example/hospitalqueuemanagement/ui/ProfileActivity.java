package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;

import com.example.hospitalqueuemanagement.R;

public class ProfileActivity extends Activity {

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);

        Button btnSave = findViewById(R.id.btnSaveProfile);

        SharedPreferences preferences =
                getSharedPreferences("UserProfile", MODE_PRIVATE);

        // Load previously saved details
        edtName.setText(
                preferences.getString("name", "")
        );

        edtEmail.setText(
                preferences.getString("email", "")
        );

        edtPhone.setText(
                preferences.getString("phone", "")
        );

        // Save profile
        btnSave.setOnClickListener(v -> {

            preferences.edit()
                    .putString("name", edtName.getText().toString())
                    .putString("email", edtEmail.getText().toString())
                    .putString("phone", edtPhone.getText().toString())
                    .apply();

            new android.app.AlertDialog.Builder(ProfileActivity.this)
                    .setTitle("Profile Updated")
                    .setMessage("Your profile details have been saved.")
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}