package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

import java.util.Calendar;

public class AppointmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        EditText date = findViewById(R.id.edtDate);
        EditText time = findViewById(R.id.edtTime);
        TextView confirmAppointment = findViewById(R.id.btnConfirmAppointment);

        // Get selected department and doctor
        String department = getIntent().getStringExtra("department");
        String doctorName = getIntent().getStringExtra("doctorName");

        // Date Picker
        date.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    AppointmentActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String selectedDate = selectedDay + "/" +
                                (selectedMonth + 1) + "/" +
                                selectedYear;

                        date.setText(selectedDate);
                    },
                    year,
                    month,
                    day
            );

            dialog.show();
        });

        // Time Picker
        time.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(
                    AppointmentActivity.this,
                    (view, selectedHour, selectedMinute) -> {
                        String selectedTime = String.format(
                                "%02d:%02d",
                                selectedHour,
                                selectedMinute
                        );

                        time.setText(selectedTime);
                    },
                    hour,
                    minute,
                    true
            );

            dialog.show();
        });

        // Confirm Appointment
        confirmAppointment.setOnClickListener(v -> {

            String selectedDate = date.getText().toString();
            String selectedTime = time.getText().toString();

            Intent intent = new Intent(
                    AppointmentActivity.this,
                    ConfirmationActivity.class
            );

            intent.putExtra("date", selectedDate);
            intent.putExtra("time", selectedTime);
            intent.putExtra("department", department);
            intent.putExtra("doctorName", doctorName);

            startActivity(intent);
        });
    }
}