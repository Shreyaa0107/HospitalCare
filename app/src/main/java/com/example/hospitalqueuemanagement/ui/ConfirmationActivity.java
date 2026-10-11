package com.example.hospitalqueuemanagement.ui;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class ConfirmationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView details = findViewById(R.id.txtConfirmationDetails);
        TextView btnDone = findViewById(R.id.btnDone);

        // Get appointment details
        String department = getIntent().getStringExtra("department");
        String doctorName = getIntent().getStringExtra("doctorName");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");

        // Prevent blank values
        if (department == null || department.isEmpty()) {
            department = "General Medicine";
        }

        if (doctorName == null || doctorName.isEmpty()) {
            doctorName = "Doctor";
        }

        if (date == null || date.isEmpty()) {
            date = "--";
        }

        if (time == null || time.isEmpty()) {
            time = "--";
        }

        // Get previous token
        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int lastToken = preferences.getInt("lastToken", 0);

        // Generate next token
        int currentToken = lastToken + 1;

        // Save latest appointment details
        preferences.edit()
                .putInt("lastToken", currentToken)
                .putString("department", department)
                .putString("doctorName", doctorName)
                .putString("date", date)
                .putString("time", time)
                .apply();

        // Show confirmation
        String confirmationText =
                "Department: " + department + "\n\n" +
                        "Doctor: " + doctorName + "\n\n" +
                        "Date: " + date + "\n\n" +
                        "Time: " + time + "\n\n" +
                        "Token Number: " +
                        String.format("%02d", currentToken);

        details.setText(confirmationText);

        btnDone.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ConfirmationActivity.this,
                    MainActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });
    }
}