package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class PatientRecordsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_records);

        TextView patientRecord =
                findViewById(R.id.txtPatientRecord);

        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int token =
                preferences.getInt("lastToken", 0);

        String department =
                preferences.getString(
                        "department",
                        "No Department"
                );

        String doctor =
                preferences.getString(
                        "doctorName",
                        "No Doctor"
                );

        String date =
                preferences.getString(
                        "date",
                        "No Date"
                );

        String time =
                preferences.getString(
                        "time",
                        "No Time"
                );

        if (token == 0) {

            patientRecord.setText(
                    "No patient records available."
            );

        } else {

            String record =
                    "PATIENT 01\n\n" +
                            "Patient: Registered Patient\n\n" +
                            "Token: " +
                            String.format("%02d", token) + "\n\n" +
                            "Department: " +
                            department + "\n\n" +
                            "Doctor: " +
                            doctor + "\n\n" +
                            "Appointment Date: " +
                            date + "\n\n" +
                            "Appointment Time: " +
                            time;

            patientRecord.setText(record);
        }
    }
}