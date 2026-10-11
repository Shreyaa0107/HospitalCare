package com.example.hospitalqueuemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.PopupMenu;

import com.example.hospitalqueuemanagement.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Book Appointment
        TextView bookAppointment =
                findViewById(R.id.btnBookAppointment);

        bookAppointment.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    DepartmentActivity.class
            );
            startActivity(intent);
        });

        // My Queue card
        LinearLayout myQueue =
                findViewById(R.id.btnMyQueue);

        myQueue.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    QueueActivity.class
            );
            startActivity(intent);
        });

        // My Profile card
        LinearLayout myProfile =
                findViewById(R.id.btnMyProfile);

        myProfile.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ProfileActivity.class
            );
            startActivity(intent);
        });

        // Bottom Navigation
        TextView navHome =
                findViewById(R.id.navHome);

        TextView navQueue =
                findViewById(R.id.navQueue);

        TextView navProfile =
                findViewById(R.id.navProfile);

        TextView navAdmin =
                findViewById(R.id.navAdmin);

        // Home
        navHome.setOnClickListener(v -> {
            // Already on Home
        });

        // Queue
        navQueue.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    QueueActivity.class
            );
            startActivity(intent);
        });

        // Profile
        navProfile.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ProfileActivity.class
            );
            startActivity(intent);
        });

        // Admin
        navAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AdminLoginActivity.class
            );
            startActivity(intent);
        });

        // Three-dot More Menu
        TextView btnMore =
                findViewById(R.id.btnMore);

        btnMore.setOnClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(
                    MainActivity.this,
                    btnMore
            );

            // ONLY these options
            popupMenu.getMenu().add("About HospitalCare");
            popupMenu.getMenu().add("Help & Support");
            popupMenu.getMenu().add("Logout");

            popupMenu.setOnMenuItemClickListener(item -> {

                String selected =
                        item.getTitle().toString();

                // About HospitalCare
                if (selected.equals("About HospitalCare")) {

                    new android.app.AlertDialog.Builder(
                            MainActivity.this
                    )
                            .setTitle("About HospitalCare")
                            .setMessage(
                                    "HospitalCare is a hospital queue " +
                                            "management application that helps " +
                                            "patients book appointments and " +
                                            "track their queue status."
                            )
                            .setPositiveButton("OK", null)
                            .show();

                }

                // Help & Support
                else if (selected.equals("Help & Support")) {

                    new android.app.AlertDialog.Builder(
                            MainActivity.this
                    )
                            .setTitle("Help & Support")
                            .setMessage(
                                    "For assistance, please contact " +
                                            "the hospital reception."
                            )
                            .setPositiveButton("OK", null)
                            .show();

                }

                // Logout
                else if (selected.equals("Logout")) {

                    new android.app.AlertDialog.Builder(
                            MainActivity.this
                    )
                            .setTitle("Logout")
                            .setMessage(
                                    "Are you sure you want to logout?"
                            )
                            .setNegativeButton("Cancel", null)
                            .setPositiveButton(
                                    "Logout",
                                    (dialog, which) -> finish()
                            )
                            .show();
                }

                return true;
            });

            popupMenu.show();
        });
    }
}