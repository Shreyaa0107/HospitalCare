package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class DepartmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        TextView generalMedicine = findViewById(R.id.btnGeneralMedicine);
        TextView cardiology = findViewById(R.id.btnCardiology);
        TextView dermatology = findViewById(R.id.btnDermatology);
        TextView pediatrics = findViewById(R.id.btnPediatrics);
        TextView orthopedics = findViewById(R.id.btnOrthopedics);

        generalMedicine.setOnClickListener(v ->
                openDoctors("General Medicine"));

        cardiology.setOnClickListener(v ->
                openDoctors("Cardiology"));

        dermatology.setOnClickListener(v ->
                openDoctors("Dermatology"));

        pediatrics.setOnClickListener(v ->
                openDoctors("Pediatrics"));

        orthopedics.setOnClickListener(v ->
                openDoctors("Orthopedics"));
    }

    private void openDoctors(String department) {

        Intent intent = new Intent(
                DepartmentActivity.this,
                DoctorActivity.class
        );

        intent.putExtra("department", department);

        startActivity(intent);
    }
}