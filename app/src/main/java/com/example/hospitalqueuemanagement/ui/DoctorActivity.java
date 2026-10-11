package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class DoctorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        String department = getIntent().getStringExtra("department");

        TextView doctor1 = findViewById(R.id.btnDoctor1);
        TextView doctor2 = findViewById(R.id.btnDoctor2);
        TextView doctor3 = findViewById(R.id.btnDoctor3);

        if (department == null) {
            department = "General Medicine";
        }

        if (department.equals("Cardiology")) {

            doctor1.setText("Dr. Amit Kulkarni\nCardiologist");
            doctor2.setText("Dr. Neha Joshi\nCardiologist");
            doctor3.setText("Dr. Raj Mehta\nCardiologist");

        } else if (department.equals("Dermatology")) {

            doctor1.setText("Dr. Priya Shah\nDermatologist");
            doctor2.setText("Dr. Anjali Patil\nDermatologist");
            doctor3.setText("Dr. Rohan Desai\nDermatologist");

        } else if (department.equals("Pediatrics")) {

            doctor1.setText("Dr. Sneha Joshi\nPediatrician");
            doctor2.setText("Dr. Rahul Mehta\nPediatrician");
            doctor3.setText("Dr. Kavita Sharma\nPediatrician");

        } else if (department.equals("Orthopedics")) {

            doctor1.setText("Dr. Vikram Patil\nOrthopedic Specialist");
            doctor2.setText("Dr. Ankit Sharma\nOrthopedic Specialist");
            doctor3.setText("Dr. Pooja Deshmukh\nOrthopedic Specialist");

        } else {

            doctor1.setText("Dr. A. Sharma\nGeneral Physician");
            doctor2.setText("Dr. R. Patil\nGeneral Physician");
            doctor3.setText("Dr. S. Deshmukh\nGeneral Physician");
        }

        String finalDepartment = department;

        doctor1.setOnClickListener(v ->
                openAppointment(
                        doctor1.getText().toString(),
                        finalDepartment
                ));

        doctor2.setOnClickListener(v ->
                openAppointment(
                        doctor2.getText().toString(),
                        finalDepartment
                ));

        doctor3.setOnClickListener(v ->
                openAppointment(
                        doctor3.getText().toString(),
                        finalDepartment
                ));
    }

    private void openAppointment(String doctorName, String department) {

        Intent intent = new Intent(
                DoctorActivity.this,
                AppointmentActivity.class
        );

        intent.putExtra("doctorName", doctorName);
        intent.putExtra("department", department);

        startActivity(intent);
    }
}