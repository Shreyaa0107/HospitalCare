package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class StatisticsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView txtPatients = findViewById(R.id.txtStatsPatients);
        TextView txtDoctors = findViewById(R.id.txtStatsDoctors);
        TextView txtDepartments = findViewById(R.id.txtStatsDepartments);
        TextView txtToken = findViewById(R.id.txtStatsToken);

        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int token = preferences.getInt("lastToken", 0);

        txtPatients.setText(String.valueOf(token));
        txtDoctors.setText("15");
        txtDepartments.setText("5");
        txtToken.setText(
                token == 0
                        ? "--"
                        : String.format("%02d", token)
        );
    }
}