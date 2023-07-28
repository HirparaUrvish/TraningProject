package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.urvish.R;
import com.example.urvish.databinding.ActivityEditTextBinding;

public class EditTextActivity extends AppCompatActivity {

    /* EditText phone_number, email_text, name_text;
     TextView show_phone, show_email, show_name;
     AppCompatButton display;
     String MobilePattern = "[0-9]{10}";
     String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";*/
    /* ActivityEditTextBinding activityMainBinding;

    ActivityEditTextBinding activityEditTextBinding;
*/

    ActivityEditTextBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_edit_text);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_text);

        activityMainBinding.display.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String name = activityMainBinding.nametext.getText().toString();
                String mobile = activityMainBinding.phonenumber.getText().toString();
                String email = activityMainBinding.emailtext.getText().toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (!activityMainBinding.nametext.getText().toString().isEmpty() && !activityMainBinding.emailtext.getText().toString().isEmpty() && !activityMainBinding.phonenumber.getText().toString().isEmpty()) {
                        activityMainBinding.showphone.setText("Phone:" + mobile);
                        activityMainBinding.showemail.setText("Email:" + email);
                        activityMainBinding.showname.setText("Name:" + name);
                    }
                }
                if (!Patterns.PHONE.matcher(mobile).matches()) {
                    activityMainBinding.phonenumber.setError(" Invalid Phone number");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    activityMainBinding.emailtext.setError("Invalid Email Address");
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (activityMainBinding.nametext.getText().toString().isEmpty()) {
                        activityMainBinding.nametext.setError("Enter your name");
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (activityMainBinding.emailtext.getText().toString().isEmpty()) {
                        activityMainBinding.emailtext.setError("Enter Email Address");
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (activityMainBinding.phonenumber.getText().toString().isEmpty()) {
                        activityMainBinding.phonenumber.setError("Enter Phone number");
                    }
                }

            }
        });

//        Edit_text text= DataBindingUtil.setContentView(Edit_text.this, R.layout.activity_edit_text);


       /* phone_number = findViewById(R.id.phone_number);
        email_text = findViewById(R.id.email_text);
        name_text = findViewById(R.id.name_text);
        show_phone = findViewById(R.id.show_phone);
        show_email = findViewById(R.id.show_email);
        show_name = findViewById(R.id.show_name);
        display = findViewById(R.id.display);


        display.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String name = name_text.getText().toString();
                String mobile = phone_number.getText().toString();
                String email = email_text.getText().toString();


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (!name_text.getText().toString().isEmpty() && !email_text.getText().toString().isEmpty() && !phone_number.getText().toString().isEmpty()) {
                        show_phone.setText("Phone:" + mobile);
                        show_email.setText("Email:" + email);
                        show_name.setText("Name:" + name);
                    }
                }
                if (!phone_number.getText().toString().matches(MobilePattern)) {
                    phone_number.setError(" Invalid Phone number");
                }
                if (!email.matches(emailPattern) && email.length() > 0 && email.contains("@gmail.com") && !email.endsWith("@gmail.com") || !email.endsWith("@yahoo.com") || !email.endsWith("@outlook.com")) {
                    email_text.setError("Invalid Email Address");
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (name_text.getText().toString().isEmpty()) {
                        name_text.setError("Enter your name");
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (email_text.getText().toString().isEmpty()) {
                        email_text.setError("Enter Email Address");
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (phone_number.getText().toString().isEmpty()) {
                        phone_number.setError("Enter Phone number");
                    }
                }

            }
        });*/


    }
}