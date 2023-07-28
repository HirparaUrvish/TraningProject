package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackBarControlActivity extends AppCompatActivity {

    AppCompatButton default_snackbar, click_snackbar, custom_snackbar;
    TextView textView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_control);


        default_snackbar = findViewById(R.id.default_snackbar);
        click_snackbar = findViewById(R.id.click_snackbar);
        custom_snackbar = findViewById(R.id.custom_snackbar);
        textView = findViewById(R.id.hhhhhhhh);

        default_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar = Snackbar
                        .make(view, "Hello...!!!! Default SnackBar example", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        click_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar1 = Snackbar.make(view, "Message is deleted", Snackbar.LENGTH_LONG);
                        snackbar1.setAction("Dismiss", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                snackbar1.dismiss();
                            }
                        });
                        snackbar1.setAction("ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackbar1.dismiss();
                            }
                        });
                snackbar1.show();
            }
        });

        custom_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar1 = Snackbar.make(view, "Message is deleted", Snackbar.LENGTH_LONG);
                snackbar1.setAnchorView(textView);
                snackbar1.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar1.dismiss();
                    }
                });
                snackbar1.show();

            }
        });

    }
}