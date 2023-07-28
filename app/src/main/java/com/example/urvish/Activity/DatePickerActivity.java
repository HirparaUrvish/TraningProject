package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    DatePicker date_picker;
    AppCompatButton display_date;
    EditText first_date1, first_date2;
    TextView date_text;
    String day1, month1, year1;
    int mYear, mMonth, mDay;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener setListener;

    @SuppressLint({"MissingInflatedId", "SetTextI18n", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_view);

        date_text = findViewById(R.id.date_text);
        first_date1 = findViewById(R.id.first_date1);
        first_date2 = findViewById(R.id.first_date2);
        date_picker = findViewById(R.id.date_picker);
        display_date = findViewById(R.id.display_date);


        year1 = String.valueOf(calendar.get(Calendar.YEAR));
        month1 = String.valueOf(calendar.get(Calendar.MONTH));
        day1 = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        date_text.setText("" + day1 + "/" + month1 + 1 + "/" + year1);

        display_date.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String day = String.valueOf(date_picker.getDayOfMonth());
                String month = String.valueOf((date_picker.getMonth() + 1));
                String year = String.valueOf(date_picker.getYear());

                date_text.setText("" + day + "/" + month + "/" + year);

            }
        });

        first_date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DatePickerActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                first_date1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }

        });

        first_date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(DatePickerActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,setListener,mYear,mMonth,mDay);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month=month+1;
                String date=day+"/"+month+"/"+year;
                first_date2.setText(date);

            }
        };

    }
}