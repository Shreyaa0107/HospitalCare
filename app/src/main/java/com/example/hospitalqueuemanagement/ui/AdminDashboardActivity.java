package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class AdminDashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button patientRecords =
                findViewById(R.id.btnPatientRecords);

        Button doctorRecords =
                findViewById(R.id.btnDoctorRecords);

        Button statistics =
                findViewById(R.id.btnStatistics);

        Button queueManagement =
                findViewById(R.id.btnQueueManagement);

        TextView totalPatients =
                findViewById(R.id.txtTotalPatients);

        TextView totalDoctors =
                findViewById(R.id.txtTotalDoctors);

        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int token =
                preferences.getInt("lastToken", 0);

        totalPatients.setText(String.valueOf(token));
        totalDoctors.setText("15");

        // Patient Records
        patientRecords.setOnClickListener(v -> {

            Intent intent = new Intent(
                    AdminDashboardActivity.this,
                    PatientRecordsActivity.class
            );

            startActivity(intent);
        });

        // Doctor & Department Records
        doctorRecords.setOnClickListener(v -> {

            Intent intent = new Intent(
                    AdminDashboardActivity.this,
                    DoctorRecordsActivity.class
            );

            startActivity(intent);
        });

        // Basic Statistics
        statistics.setOnClickListener(v -> {

            Intent intent = new Intent(
                    AdminDashboardActivity.this,
                    StatisticsActivity.class
            );

            startActivity(intent);
        });

        // Queue Management
        queueManagement.setOnClickListener(v -> {

            Intent intent = new Intent(
                    AdminDashboardActivity.this,
                    AdminQueueActivity.class
            );

            startActivity(intent);
        });
    }
}