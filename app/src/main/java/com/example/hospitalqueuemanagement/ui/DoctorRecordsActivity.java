package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class DoctorRecordsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_records);

        TextView records = findViewById(R.id.txtDoctorRecords);

        String doctorData =
                "GENERAL MEDICINE\n\n" +
                        "Dr. A. Sharma\n" +
                        "General Physician\n\n" +
                        "Dr. R. Patil\n" +
                        "General Physician\n\n" +
                        "Dr. S. Deshmukh\n" +
                        "General Physician\n\n\n" +

                        "CARDIOLOGY\n\n" +
                        "Dr. Amit Kulkarni\n" +
                        "Cardiologist\n\n" +
                        "Dr. Neha Joshi\n" +
                        "Cardiologist\n\n" +
                        "Dr. Raj Mehta\n" +
                        "Cardiologist\n\n\n" +

                        "DERMATOLOGY\n\n" +
                        "Dr. Priya Shah\n" +
                        "Dermatologist\n\n" +
                        "Dr. Anjali Patil\n" +
                        "Dermatologist\n\n" +
                        "Dr. Rohan Desai\n" +
                        "Dermatologist\n\n\n" +

                        "PEDIATRICS\n\n" +
                        "Dr. Sneha Joshi\n" +
                        "Pediatrician\n\n" +
                        "Dr. Rahul Mehta\n" +
                        "Pediatrician\n\n" +
                        "Dr. Kavita Sharma\n" +
                        "Pediatrician\n\n\n" +

                        "ORTHOPEDICS\n\n" +
                        "Dr. Vikram Patil\n" +
                        "Orthopedic Specialist\n\n" +
                        "Dr. Ankit Sharma\n" +
                        "Orthopedic Specialist\n\n" +
                        "Dr. Pooja Deshmukh\n" +
                        "Orthopedic Specialist";

        records.setText(doctorData);
    }
}