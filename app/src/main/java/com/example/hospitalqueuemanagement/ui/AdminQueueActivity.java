package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hospitalqueuemanagement.R;

public class AdminQueueActivity extends Activity {

    private int nowServing = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_queue);

        TextView currentToken =
                findViewById(R.id.txtAdminCurrentToken);

        TextView nowServingText =
                findViewById(R.id.txtAdminNowServing);

        TextView peopleWaiting =
                findViewById(R.id.txtAdminPeopleWaiting);

        TextView status =
                findViewById(R.id.txtAdminQueueStatus);

        TextView department =
                findViewById(R.id.txtAdminDepartment);

        TextView doctor =
                findViewById(R.id.txtAdminDoctor);

        SharedPreferences preferences =
                getSharedPreferences("QueueData", MODE_PRIVATE);

        int token =
                preferences.getInt("lastToken", 0);

        String departmentName =
                preferences.getString(
                        "department",
                        "No Department"
                );

        String doctorName =
                preferences.getString(
                        "doctorName",
                        "No Doctor"
                );

        department.setText(
                "Department: " + departmentName
        );

        doctor.setText(
                "Doctor: " + doctorName
        );

        if (token == 0) {

            currentToken.setText("--");
            nowServingText.setText("--");
            peopleWaiting.setText("0");
            status.setText("No active queue");

        } else {

            currentToken.setText(
                    String.format("%02d", token)
            );

            nowServingText.setText(
                    String.format("%02d", nowServing)
            );

            int waiting = token - nowServing;

            if (waiting < 0) {
                waiting = 0;
            }

            peopleWaiting.setText(
                    String.valueOf(waiting)
            );

            if (token == nowServing) {
                status.setText("Patient's Turn");
            } else {
                status.setText("Queue Active");
            }
        }
    }
}