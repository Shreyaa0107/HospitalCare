package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class QueueActivity extends Activity {

    private int nowServing = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        TextView tokenText = findViewById(R.id.txtToken);
        TextView departmentText = findViewById(R.id.txtDepartment);
        TextView doctorText = findViewById(R.id.txtDoctor);
        TextView dateText = findViewById(R.id.txtDate);
        TextView timeText = findViewById(R.id.txtTime);
        TextView nowServingText = findViewById(R.id.txtNowServing);
        TextView peopleAheadText = findViewById(R.id.txtPeopleAhead);
        TextView statusText = findViewById(R.id.txtQueueStatus);
        Button refreshButton = findViewById(R.id.btnRefreshQueue);

        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int currentToken = preferences.getInt("lastToken", 0);

        String department =
                preferences.getString("department", "");

        String doctorName =
                preferences.getString("doctorName", "");

        String date =
                preferences.getString("date", "");

        String time =
                preferences.getString("time", "");

        departmentText.setText(
                department.isEmpty()
                        ? "Department: --"
                        : "Department: " + department
        );

        doctorText.setText(
                doctorName.isEmpty()
                        ? "Doctor: --"
                        : "Doctor: " + doctorName
        );

        dateText.setText(
                date.isEmpty()
                        ? "Date: --"
                        : "Date: " + date
        );

        timeText.setText(
                time.isEmpty()
                        ? "Time: --"
                        : "Time: " + time
        );

        updateQueue(
                currentToken,
                tokenText,
                nowServingText,
                peopleAheadText,
                statusText
        );

        refreshButton.setOnClickListener(v -> {

            if (currentToken > nowServing) {
                nowServing++;
            }

            updateQueue(
                    currentToken,
                    tokenText,
                    nowServingText,
                    peopleAheadText,
                    statusText
            );
        });
    }

    private void updateQueue(
            int currentToken,
            TextView tokenText,
            TextView nowServingText,
            TextView peopleAheadText,
            TextView statusText) {

        if (currentToken == 0) {

            tokenText.setText("NO TOKEN");
            nowServingText.setText("Now Serving: --");
            peopleAheadText.setText("People Ahead: --");
            statusText.setText("Status: No Appointment");

        } else {

            int peopleAhead = currentToken - nowServing;

            tokenText.setText(
                    "TOKEN " + String.format("%02d", currentToken)
            );

            nowServingText.setText(
                    "Now Serving: " + String.format("%02d", nowServing)
            );

            peopleAheadText.setText(
                    "People Ahead: " + peopleAhead
            );

            if (currentToken == nowServing) {
                statusText.setText("Status: Your Turn");
            } else {
                statusText.setText("Status: Waiting");
            }
        }
    }
}