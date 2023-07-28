package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity {

    TimePicker time_picker;
    String format = "";
    AppCompatButton display_time;
    EditText edit_time;
    TextView first_time1, first_time2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_view);

        time_picker = findViewById(R.id.time_picker);
        first_time1 = findViewById(R.id.first_time1);
        edit_time = findViewById(R.id.edit_time);
        display_time = findViewById(R.id.display_time);
        first_time2 = findViewById(R.id.first_time2);
        time_picker.setIs24HourView(false);

        display_time.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int hour = time_picker.getCurrentHour();
                int min = time_picker.getCurrentMinute();

                first_time2.setText("24 Hour Format= " + time_picker.getCurrentHour() + " : " + time_picker.getCurrentMinute());

                if (hour == 0) {
                    hour += 12;
                    format = "AM";
                } else if (hour == 12) {
                    format = "PM";
                } else if (hour > 12) {
                    hour -= 12;
                    format = "PM";
                } else {
                    format = "AM ";
                }

                first_time1.setText("12 hour Format= " + new StringBuilder().append(hour).append(" : ").append(min)
                        .append(" ").append(format));

            }
        });

        edit_time.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (view.isShown()) {
                            c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                            c.set(Calendar.MINUTE, minute);

                            if (hourOfDay == 0) {
                                hourOfDay += 12;
                                format = "AM";
                            } else if (hourOfDay == 12) {
                                format = "PM";
                            } else if (hourOfDay > 12) {
                                hourOfDay -= 12;
                                format = "PM";
                            } else {
                                format = "AM";
                            }
                            edit_time.setText("  12 hour format : " + new StringBuilder().append(hourOfDay).append(" : ").append(minute).append(" ").
                                    append(format) + "\n" + "  24 hour format : " + c.get(Calendar.HOUR_OF_DAY) + " : " + c.get(Calendar.MINUTE));
                        }
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute, true);
                timePickerDialog.setTitle("Choose hour:");
                timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                timePickerDialog.show();

            }
        });

    }
}