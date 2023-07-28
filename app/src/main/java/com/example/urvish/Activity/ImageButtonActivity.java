package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urvish.R;

public class ImageButtonActivity extends AppCompatActivity {

    ImageButton first_image,second_image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        first_image=findViewById(R.id.first_image);
        second_image=findViewById(R.id.second_image);

        first_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ImageButtonActivity.this, "Camera button press", Toast.LENGTH_SHORT).show();

            }
        });

        second_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ImageButtonActivity.this, "Person button press", Toast.LENGTH_SHORT).show();

            }
        });

    }
}