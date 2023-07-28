package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;

public class ToastExampleActivity extends AppCompatActivity {

    AppCompatButton simple_toast, custom_toast;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_example);

        simple_toast = findViewById(R.id.simple_toast);
        custom_toast = findViewById(R.id.custom_toast);

        simple_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ToastExampleActivity.this, "Simple Toast", Toast.LENGTH_SHORT).show();

            }
        });

        custom_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast toast = new Toast(getApplicationContext());

                View view1 = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.view_toast));

                toast.setView(view1);

                TextView txtmsg = view1.findViewById(R.id.txtMsg);

                txtmsg.setText("Custom Toast");

                toast.setDuration(Toast.LENGTH_LONG);


                toast.show();


            }
        });

    }
}