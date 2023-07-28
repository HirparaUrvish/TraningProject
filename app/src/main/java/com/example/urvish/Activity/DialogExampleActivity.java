package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.text.HtmlCompat;

import com.example.urvish.R;

public class DialogExampleActivity extends AppCompatActivity {
    AppCompatButton single_dialog, multi_dialog, custom_dialog, option_dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        single_dialog = findViewById(R.id.single_dialog);
        multi_dialog = findViewById(R.id.multi_dialog);
        custom_dialog = findViewById(R.id.custom_dialog);
        option_dialog = findViewById(R.id.option_dialog);


        single_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogExampleActivity.this);
                builder.setMessage("do you want to close this dialog")
                        .setTitle("Single Choice Alert Dialog")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(DialogExampleActivity.this, "you click ok", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        multi_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogExampleActivity.this);
                builder.setMessage("do you want to close this dialog")
                        .setTitle("multi Choice Alert Dialog")
                        .setCancelable(true);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(DialogExampleActivity.this, "You click ok", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(DialogExampleActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogExampleActivity.this, "You click Neutral", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        custom_dialog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(DialogExampleActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setCancelable(false);
                LinearLayout view1 = dialog.findViewById(R.id.first_theme);

                TextView textView = dialog.findViewById(R.id.text_custom);
                textView.setText(HtmlCompat.fromHtml("<font color='#f00000'>Note :</font> you will only get<font color='#2625FA'> 1 Pro</font> theme per day", HtmlCompat.FROM_HTML_MODE_LEGACY));

                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(DialogExampleActivity.this, "Purchase to unlock all catalog", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                LinearLayout view11 = dialog.findViewById(R.id.second_theme);

                view11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(DialogExampleActivity.this, "Watch a video AD  \n to get these theme", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }


        });

        option_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] Items = {"Red", "Black", "White", "Blue", "Yellow", "Pink", "Green", "Orange"};

                AlertDialog alertDialog;
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogExampleActivity.this);
                builder1.setTitle("Option Dialog");
                builder1.setCancelable(true);
                builder1.setItems(Items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(DialogExampleActivity.this, "" + Items[which], Toast.LENGTH_SHORT).show();

                    }
                });
                alertDialog = builder1.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });

    }
}