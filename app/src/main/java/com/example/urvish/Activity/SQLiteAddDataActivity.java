package com.example.urvish.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.urvish.HelperClasses.SQLiteDatabaseHelperClass;
import com.example.urvish.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SQLiteAddDataActivity extends AppCompatActivity {

    CircleImageView user_image;
    EditText user_name, user_email, user_age, user_number;
    String name, email,age, number,s5;
    AppCompatButton user_ok;
    RadioButton user_male,user_female;
    String MobilePattern = "[0-9]{10}";
    Uri resultUri;
    StringBuffer user_check=new StringBuffer();

    @SuppressLint({"MissingInflatedId", "WrongThread"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_adddata);

        user_image = findViewById(R.id.user_image);
        user_name = findViewById(R.id.user_name);
        user_email = findViewById(R.id.user_email);
        user_age = findViewById(R.id.user_age);
        user_number = findViewById(R.id.user_number);
        user_male = findViewById(R.id.user_male);
        user_female = findViewById(R.id.user_female);
        user_ok = findViewById(R.id.user_ok);


        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(SQLiteAddDataActivity.this);

            }
        });



        user_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = String.valueOf(user_name.getText());
                email = String.valueOf(user_email.getText());
                age= String.valueOf(user_age.getText());
                number = String.valueOf(user_number.getText());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if (user_check.toString().isEmpty()) {
                        user_check.append("male");
                    }
                }


                if(name.equals(""))
                {
                    user_name.setError("Please enter your Name");
                }else if(email.equals(""))
                {
                    user_email.setError("please enter your Email");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    user_email.setError("Invalid Email Address");
                }else if(age.equals(""))
                {
                    user_age.setError("Please enter your Age");
                }else if(number.equals(""))
                {
                    user_number.setError("please enter your Phone no.");
                }else if(!number.matches(MobilePattern))
                {
                    user_number.setError("Invalid Phone no.");
                }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if(resultUri==null || resultUri.toString().isEmpty())
                    {
                        Toast.makeText(SQLiteAddDataActivity.this, "please select image", Toast.LENGTH_LONG).show();
                    } else{

                        String chckegender=user_check.toString();


                        SQLiteDatabaseHelperClass dbhelper=new SQLiteDatabaseHelperClass(SQLiteAddDataActivity.this);
                        dbhelper.insertdata(name,email,age,number, String.valueOf(resultUri),chckegender);
                        Toast.makeText(SQLiteAddDataActivity.this, "Data Add Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SQLiteAddDataActivity.this, SQLiteDataBaseActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                resultUri = result.getUri();
                user_image.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    public void Ongender(View view) {

        switch (view.getId()) {

            case R.id.user_male:

                user_female.setChecked(false);
                if (user_male.isChecked()) {
                    user_check.delete(0, user_check.length());
                    user_check.append("male");

                }
                break;

            case R.id.user_female:

                user_male.setChecked(false);
                if (user_female.isChecked()) {
                    user_check.delete(0, user_check.length());
                    user_check.append("female");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setMessage("You ")
                .setMessage("You Don't Add data ?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(SQLiteAddDataActivity.this, SQLiteDataBaseActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}